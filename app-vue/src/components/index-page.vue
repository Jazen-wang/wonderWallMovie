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
    | 正在热映
  .will-showing
    | 即将上映
  div.movieTag {{ this.$store.getters.movingList }}
  div.movieTag(v-for="(item, index) in this.$store.getters.movingList") {{ item }}


</template>


<script>
import { Carousel3d, Slide } from 'vue-carousel-3d'

export default {
  mounted () {
    // 获取正在上映的列表
    this.$store.dispatch('getMoving')
  },
  components: {
    Carousel3d,
    Slide
  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.carousel-3d-slider, .carousel-3d-slide {
  width: 800px !important;
  height: 300px !important;
}
</style>

<style scoped>
.carousel-3d-slider img {
  width: 800px;
  height: 300px;
}

</style>
