<template lang="jade">
#select-seat
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

</template>

<script>

var initSeat = [
  [{seatNum: 0, state: 'occupied'},
  {seatNum: 1, state: 'selectable'},
  {seatNum: 2, state: 'selectable'},
  {seatNum: 3, state: 'selectable'},
  {seatNum: 4, state: 'occupied'}],
  [{seatNum: 0, state: 'occupied'},
  {seatNum: 1, state: 'selectable'},
  {seatNum: 2, state: 'selectable'},
  {seatNum: 3, state: 'selectable'},
  {seatNum: 4, state: 'occupied'}]
]

export default {
  data: function() {
    return {
      seat: initSeat,
    }
  },
  methods: {
    select: function(item, row, col) {
      item.state = "selected";
    }
  }

}
</script>

<style lang="sass" scoped>
@import "../styles/components/select-seat.sass"
</style>
