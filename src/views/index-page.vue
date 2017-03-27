<template lang="jade">
carousel-3d
  slide.movie-1(:index='0')
    img(src="../assets/movie-1.jpg")
  slide.movie-2(:index='1')
    img(src="../assets/movie-2.jpg")
  slide.movie-3(:index='2')
    img(src="../assets/movie-3.jpg")

</template>


<script>
import { Carousel3d, Slide } from 'vue-carousel-3d'
export default {
  components: {
    Carousel3d,
    Slide
  }
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
