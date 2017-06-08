<template lang="jade">
  #order-page
    .container
      h1 请仔细核对场次信息
      el-table(:data="tableData", border="", style="width: 100%")
        el-table-column(prop="time", label="观影时间")
        el-table-column(prop="movie", label="影片")
        el-table-column(prop="address", label="放映厅")
        el-table-column(prop="seat", label="座位")

</template>

<script>
export default {
  data: function() {
    return {

    }
  },

}
</script>

<style lang="sass">
 #order-page
  .container
    position: relative
    width: 1000px
    margin-left: auto
    margin-right: auto
    text-align: left
    padding-top: 40px
  h1
    font-size: 24px
    margin-bottom: 20px
</style>