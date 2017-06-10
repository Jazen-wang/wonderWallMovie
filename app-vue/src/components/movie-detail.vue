<!-- 电影详情的简单介绍框，作为组件使用, 传入获得的电影内容 -->
<template lang="jade">
div
  #banner
    .container
      div(v-if="data")
        img.poster(:src="data.images.large")
        .info-box
          h2 {{data.title}}
          p {{data.original_title}}
          ul.list
            li
              span(v-for="item in data.genres") {{item}} 
            li
              span(v-for="(item,index) in data.countries") {{item}}
            li 2017-06-14 大陆上映
          p.score 用户评分: {{data.rating.average * 2}}
      div(v-else)
        p 加载中
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

<style lang="sass" scoped>
@import "../styles/components/movie-detail.sass"
</style>
