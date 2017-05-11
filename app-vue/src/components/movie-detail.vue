<!-- 电影详情的简单介绍框，作为组件使用, 传入获得的电影内容 -->
<template lang="jade">
div
  #banner
    .container
      img.poster(:src="data.images.large")
      .info-box
        h2 {{data.title}}
        p {{data.original_title}}
        ul.list
          li
            span(v-for="item in data.genres") {{item}}
          li
            span(v-for="(item,index) in data.countries") {{item}}
          li 2017-04-14大陆上映
        p.score 用户评分: {{data.rating.average * 2}}

</template>

<script>
export default {
  props: {
    data: Object
  },
  data: function() {
    return {}
  }
}
</script>

<style lang="sass">

#banner
  background-image: url('../assets/banner.png')
  background-position: center
  background-size: cover
  background-repeat: no-repeat
  width: 100%
  height: 400px
  .container
    position: relative
    width: 1000px
    height: 360px
    margin-left: auto
    margin-right: auto
    text-align: left
    padding-top: 40px
    color: #fff
    .poster
      float: left
      height: 334px
      width: 240px
      border: 2px solid #fff
    .info-box
      margin-left: 20px
      float: left
      h2
        font-size: 28px
        margin: 0
      p
        font-size: 22px
        margin-top: 0
      .list
        font-size: 15px
        list-style: none
        li
          margin: 4px 0
      .score
        position: absolute
        bottom: 20px
        font-size: 15px

</style>
