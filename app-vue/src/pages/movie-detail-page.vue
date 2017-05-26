<!-- 查看电影细节页 -->
<template lang="jade">
#movie-detail-page
  movieDetail(:data="movieDetail")
  #operation
    el-button(type="danger" name="buy" @click="toBuy(movieDetail, $event)") 立即购票
  div 待补充更多电影细节
  div 这里是很长很长的电影细节
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

<style lang="sass">

</style>
