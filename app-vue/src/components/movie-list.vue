<!-- @description 电影列表组件, 传入要显示的电影列表 -->
<!-- @author 王镇佳<wzjfloor@163.com> -->
<template lang="jade">

.moviesList-container
  el-card.movie-card(v-for='(subject, index) in data')
    .firm-pic
      .firm-overlay
      img.movieImg(:src='subject.images.large', alt='')
      .film-info
        .title {{ subject.title }}
        .grade {{ subject.rating.average * 2 }}
    .buy
      | 购票

</template>
<script>
export default{
  props: {
    data: Array
  },
  data () {
    return {
    }
  },
  watch: {
    data () {
      console.log(this.data)
    }
  },
  methods: {
    showDetail (id) {
      // this.$store.commit('DETAIL_LOADING', {loading: true})
      this.$router.push({path: '/moviesDetail', query: {id: id}})
    }
  },
  computed: {
    // loadingMoving () {
    //   return this.$store.getters.loadingMoving
    // }
  }
}
</script>

<style lang="sass">
.moviesList-container
  text-align: left
  margin: 0 auto
  .el-card__body
    padding: 0
  .firm-pic
    overflow: hidden
    height: 280px
    position: relative
    .firm-overlay
      position: absolute
      top: 0
      left: 0
      width: 200px
      height: 280px
      background: url('../assets/shadow.png') repeat-x bottom
      z-index: 5
      &:hover + img
        transform: scale(1.2)
  .movie-card
    width: 200px
    height: 320px
    margin-right: 20px
    margin-bottom: 30px
    display: inline-block
    img
      height: 280px
      width: 200px
  .film-info
    z-index: 6
    position: relative
    height: 30px
    line-height: 30px
    top: -36px
    .title, .grade
      display: block
      color: white
      font-size: 20px
      font-weight: bold
    .title
      float: left
      width: 70%
      padding-left: 10px
      text-overflow: ellipsis
      overflow: hidden
      white-space: nowrap
    .grade
      float: right
      margin-right: 8px
      color: #ffb400
      font-style: italic
  .buy
    height: 40px
    line-height: 40px
    text-align: center
    font-size: 20px
    font-weight: bold
    color: #ef4238
    &:hover
      background-color: #ef4238
      color: white
</style>
