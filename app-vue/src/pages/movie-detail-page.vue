<!-- 查看电影细节页 -->
<template lang="jade">
#movie-detail-page
  movieDetail(:data="movieDetail")
  #operation
    el-button(type="danger" name="buy" @click="toBuy(movieDetail, $event)") 立即购票
  .movieSum 
    .title 《{{movieDetail.title}}》电影介绍
    .summary 
      .subTitle 剧情简介
      | {{movieDetail.summary}}
    .players
      .subTitle 演职人员
      .player(v-for="item in movieDetail.directors" )
        a(:href="item.alt" target="_blank")
          img(:src="item.avatars.small")
          .name {{item.name}} (导演)
      .player(v-for="item in movieDetail.casts")
        a(:href="item.alt" target="_blank")
          img(:src="item.avatars.small")
          .name {{item.name}} (演员)


</template>

<script>
import movieDetail from '../components/movie-detail'

export default {
  components: {
    movieDetail
  },
  data: function() {
    return {
    }
  },
  computed: {
    movieDetail () {
      return this.$store.getters.movieDetail
    }
  },
  mounted () {
    let id = this.$route.params['id'];
    this.$store.commit('MOVING_ID', {id});
    this.$store.dispatch('getMovieDetail');
  },
  methods: {
    // 跳转到购买页
    toBuy: function(movie, event) {
      this.$router.push('/movies/' + movie.id + '/cinema');
    }
  }
}
</script>

<style lang="sass" scoped>
@import '../styles/pages/movie-detail-page.sass';
</style>
