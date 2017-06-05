<!-- 电影选择电影院页 -->
<template lang="jade">
#select-cinema
  movieDetail(:data="movieDetail")
  #select-btn
    el-button(type="danger" name="buy" @click="toSelectSeat(movieDetail, $event)") 选座购票
  .cinema-detail 这里是好几个影院 test
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
    // 跳转到购买
    toSelectSeat: function(movie, event) {
      this.$router.push('/select/' + movie.id);
    }
  }
}

</script>

<style lang="sass" scoped>
@import '../styles/pages/select-cinema.sass';
</style>