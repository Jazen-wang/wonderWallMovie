<!-- @description 电影列表组件, 传入要显示的电影列表 -->
<!-- @author 王镇佳<wzjfloor@163.com> -->
<template lang="jade">

.moviesList-container
  el-card.movie-card(v-for='(subject, index) in data' key="index")
    .firm-pic(@click="toDetail(subject)")
      .firm-overlay
      img.movieImg(:src='subject.images.large', alt='')
      .film-info
        .title {{ subject.title }}
        .grade {{ (subject.rating.average * 2 == 0) ? "" : subject.rating.average * 2 }}
    .buy(@click="toBuy(subject, $event)")
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
  methods: {
    // 跳转到电影详情
    toDetail: function(movie) {
      // 获取详情
      this.$store.commit('MOVING_ID', {id: movie.id});
      this.$store.dispatch('getMovieDetail');
      // 跳转
      this.$router.push('/movies/' + movie.id);

    },
    // 跳转到购买页
    toBuy: function(movie, event) {
      this.$router.push('/movies/' + movie.id + '/cinema');
      event.stopPropagation();
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
@import "../styles/components/movie-list.sass"
</style>
