<!-- 电影选择电影院页 -->
<template lang="jade">
#select-cinema
  movieDetail(:data="movieDetail")

  SelectSeatDialog
  .container
    SelectTicketInfo
    SessionList.session-list
</template>

<script>
import MovieDetail from '../components/movie-detail'
import SelectTicketInfo from '../components/select-ticket-info'
import SessionList from '../components/session-list'
import SelectSeatDialog from '../components/select-seat'

export default {
  components: {
    MovieDetail, SelectTicketInfo, SessionList, SelectSeatDialog
  },
  data: function() {
    return {
    }
  },
  computed: {
    movieDetail () {
      return this.$store.getters.movieDetail;
    }
  },
  mounted () {
    let id = this.$route.params['id'];
    this.$store.commit('MOVING_ID', {id});
    this.$store.dispatch('getMovieDetail');
  },
  methods: {

  }
}
 
</script>

<style lang="sass" scoped>
@import '../styles/pages/select-cinema.sass';
</style>