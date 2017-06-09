<template lang="jade">
el-dialog(title="选座", v-model="visible", @close="cancel", size="small", :lock-scroll="false")
  #select-seat
    .session-info
      span 时间：{{ selectedSession.time }}
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
      .row(v-for="(row, rowIndex) in seat")
        .col(v-for="(item, colIndex) in row", @click="select(item, rowIndex, colIndex)")
          .seat.selected(v-if="item.state == 'selected'")
          .seat.occupied(v-else-if="item.state == 'occupied'")
          .seat.selectable(v-else-if="item.state == 'selectable'")
    div.footer
      div 总价：
        span.total-price {{ totalPrice }} ¥
          
      el-button.buy-btn(type="success", @click="buy") 下单
</template>


<script>

var initSeat = [
  [
    {seatNum: 0, state: 'occupied'},
    {seatNum: 1, state: 'selectable'},
    {seatNum: 2, state: 'selectable'},
    {seatNum: 3, state: 'selectable'},
    {seatNum: 4, state: 'occupied'}
  ],
  [
    {seatNum: 0, state: 'occupied'},
    {seatNum: 1, state: 'selectable'},
    {seatNum: 2, state: 'selectable'},
    {seatNum: 3, state: 'selectable'},
    {seatNum: 4, state: 'occupied'}
  ]
]

export default {
  data: function() {
    return {
      seat: initSeat,
      selectCount: 0,
    }
  },
  methods: {
    select: function(item, row, col) {
      if (item.state == "occupied") return false;
      if (item.state == "selected") {
        item.state = 'selectable';
        this.selectCount -= 1;
      } else if (item.state == "selectable") {
        item.state = 'selected';
        this.selectCount += 1;
      }
    },
    cancel: function() {
      this.$store.dispatch('hideSelectSeatDialog');
    },
    buy: function() {

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
      return this.selectedSession.price * this.selectCount;
    }
  },

}
</script>

<style lang="sass" scoped>
@import "../styles/components/select-seat.sass"
</style>
