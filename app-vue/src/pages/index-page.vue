<template lang="jade">
.index-page
  el-carousel(height="400px")
    el-carousel-item(v-for="item in carousels" key="item.src")
      img(:src="item.src")
  .hot-showing
    .title 正在热映
    movielist(:data="moviesList")

</template>


<script>
import { Carousel3d, Slide } from 'vue-carousel-3d'
import movielist from '@/components/movie-list'

let icarousels = [
  {src: require('../assets/movie-1.jpg')},
  {src: require('../assets/movie-2.jpg')},
  {src: require('../assets/movie-3.jpg')},
]

export default {
  data: function() {
    return {
      carousels: icarousels
    }
  },
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

<style>

.el-carousel {
  margin: 30px 0;
}

.el-carousel-item {
  display: table-cell; //主要是这个属性
  vertical-align: middle;
  text-align: center;
}

.el-carousel img {
}

</style>
