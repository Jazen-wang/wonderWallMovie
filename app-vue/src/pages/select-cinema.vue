<!-- 电影选择电影院页 -->
<template lang="jade">
#select-cinema
  movieDetail(:data="movieDetail")
  .container
    selectTicketInfo
    el-button(type="danger" name="buy" @click="toSelectSeat(movieDetail, $event)") 选座购票
</template>

<script>
import movieDetail from '../components/movie-detail'
import selectTicketInfo from '../components/select-ticket-info'

export default {
  components: {
    movieDetail, selectTicketInfo
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

<style lang="sass">
#select-cinema 
  .container
    position: relative
    width: 1000px
    margin-left: auto
    margin-right: auto
    text-align: left
    padding-top: 40px
</style>