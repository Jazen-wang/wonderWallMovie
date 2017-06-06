<template lang="jade">
el-dialog(title="选座", v-model="visible", @close="cancel", size="small")
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
    el-button(type="success", @click="buy") 下单
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
    }
  },
  methods: {
    select: function(item, row, col) {
      if (item.state == "occupied") return false;
      item.state = (item.state == "selected") ? "selectable" : "selected";
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
    }
  },

}
</script>

<style lang="sass">
#select-seat
  text-align: center
  .session-info span
    margin: 0 5px
  .tips
    img
      height: 30px
      vertical-align: middle
    span
      font-size: 14px
      margin-right: 20px
  .select-group
    margin-top: 30px
    img
      margin: 0 10px
      cursor: pointer
      height: 30px
    .col
      display: inline-block
    .seat
      display: inline-block
      width: 30px
      height: 30px
      background-size: contain
      cursor: pointer
      margin: 0 5px
    .selectable
      background-image: url('../assets/seat-empty.svg')
      &:hover
        background-image: url('../assets/seat-hover.svg')
    .occupied
      background-image: url('../assets/seat-occupied.svg')
    .selected
      background-image: url('../assets/seat-selected.svg')
</style>
