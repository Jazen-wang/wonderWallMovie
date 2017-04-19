<template lang="jade">
.index-page
  carousel-3d
    slide.movie-1(:index='0')
      img(src="../assets/movie-1.jpg")
    slide.movie-2(:index='1')
      img(src="../assets/movie-2.jpg")
    slide.movie-3(:index='2')
      img(src="../assets/movie-3.jpg")
  .hot-showing
    .title 正在热映
    movielist(:data="moviesList")
  //- .will-show
  //-   .title 即将上映
  //-   movielist(:data="moviesList")

</template>


<script>
import { Carousel3d, Slide } from 'vue-carousel-3d'
import movielist from '@/components/movie-list'

export default {
  mounted () {
    // 获取正在上映的列表
    this.$store.dispatch('getMovies')
  },
  components: {
    Carousel3d,
    Slide,
    movielist
  },
  computed: {
    moviesList () {
      return this.$store.getters.moviesList.subjects
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="sass">
.carousel-3d-slider, .carousel-3d-slide
  width: 800px !important
  height: 300px !important
.index-page
  // max-width: 1000px
  margin: 0 10%
.hot-showing, .will-show
  // padding-left: 80px
  .title
    color: #27a
    font-size: 30px
    text-align: left
    margin-bottom: 20px
    font-weight: bold
.moviesList-container
  margin-left: 0px !important
</style>

<style scoped>
.carousel-3d-slider img {
  width: 800px;
  height: 300px;
}

</style>
