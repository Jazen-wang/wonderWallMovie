<template lang="jade">
el-dialog(title="选座", v-model="visible", @close="cancel", size="small", :lock-scroll="false")
  #select-seat
    .session-info
      span 语言：{{ selectedSession.language }}
      span 放映厅：{{ selectedSession.address }}
      span 单张票价：{{ selectedSession.price }}
    .tips
      img(src="../assets/seat-empty.svg", alt="可选")
      span 可选座位
      img(src="../assets/seat-occupied.svg", alt="已售")
      span 已售座位
      img(src="../assets/seat-selected.svg", alt="已选")
      span 已选座位
    .select-group
      .row(v-for="row in seat")
        .col(v-for="item in row", @click="select(item)" v-if="item")
          .seat.selected(v-if="item.selected == true ")
          .seat.occupied(v-else-if="item.sold == true")
          .seat.selectable(v-else-if="item.selected == false && item.sold == false")
    div.footer
      div 总价：
        span.total-price {{ totalPrice }} ¥

      el-button.buy-btn(type="success", @click="buy", :loading="loading") 下单
</template>


<script>

export default {
  data: function() {
    return {
      selectSeats: [],
      loading: false,
    }
  },
  methods: {
    select: function(item) {
      if (item.sold == true) return false;
      if (item.selected == true) {
        item.selected = false;
        let pos = this.selectSeats.indexOf(item);
        this.selectSeats.splice(pos, 1);
      } else if (item.selected == false) {
        item.selected = true;
        this.selectSeats.push(item);
      }
    },
    cancel: function() {
      this.$store.dispatch('hideSelectSeatDialog');
    },
    buy: function() {
      let seats = this.seat.map(item => {
        return {
          id: item.id,
          sold: item.sold,
          positionX: item.positionX,
          positionY: item.positionY,
        }
      });
      let order = {
        seats: seats,
        orderDate: new Date(),
        ticketPrice: this.selectedSession.price
      }
      this.loading = true;
      this.$http.post(`/api/movies/${this.$route.params['id']}/cinema/${this.$store.getters.selectedCinema}/hall`, order, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(res => {
          this.loading = false;
          this.$notify({
            title: '成功',
            message: '购票成功',
            type: 'success'
          });
          this.$store.dispatch('hideSelectSeatDialog');
        }).catch(res => {
          this.loading = false;
          this.$notify({
            title: '失败',
            message: '购票失败,请检查你的网络配置',
            type: 'error'
          });
        });
    }
  },
  computed: {
    visible () {
      return this.$store.getters.selectSeatDialogVisible;
    },
    selectedSession () {
      if (this.$store.getters.selectedSession) {
        return this.$store.getters.selectedSession;
      } else {
        return {
          time: "",
          language: "",
          address: "",
          price: 0
        }
      }
    },
    totalPrice () {
      return this.selectedSession.price * this.selectSeats.length;
    },
    seat () {

      let seats = [];
      if (this.$store.getters.seatInfo) {
        seats = new Array(50);
        for (let i = 0; i < seats.length; ++i) {
          seats[i] = new Array(50);
        }
        this.$store.getters.seatInfo.forEach((seat, index) => {
          seats[seat.positionX][seat.positionY] = {
            id: seat.id,
            sold: seat.sold,
            positionX: seat.positionX,
            positionY: seat.positionY,
            selected: false
          }
        })
      }

      return seats;
    }
  },

}
</script>

<style lang="sass" scoped>
@import "../styles/components/select-seat.sass"
</style>
