<template lang="jade">
  #select-ticket-info
    .date.info-box
      .label 日期：
      ul
        li 今天
        li 明天
    .area.info-box
      .label 区域：
      ul
        li 地铁附近
        li 番禺区
    .cinema.info-box
      .label 影院：
      ul
        li UA影院
        li 飞扬影院
</template>


<script>
export default {
  data: function() {
    return {
      date: ["今天", "明天"],
      allArea: ["地铁附近", "番禺区"],
      allCinema: ["UA影院", "飞扬影院"]
    }
  }
}
</script>

<style lang="sass">
#select-ticket-info
  width: 900px
  margin-left: auto
  margin-right: auto
  margin-top: 50px
  li
    display: inline-block
    padding: 0 5px
    cursor: pointer
    &:hover
      background-color: #2bb8aa
      border-radius: 2px
      color: #fff
  .info-box
    position: relative
    padding-top: 10px
    padding-bottom: 10px
    padding-left: 50px
  .label
    position: absolute
    display: inline-block
    left: 5px
</style>