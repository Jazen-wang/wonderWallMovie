<template lang="jade">
.index-page
  el-carousel
    el-carousel-item(v-for="item in carousels" key="item.src")
      img(:src="item.src")
  .hot-showing
    .title 正在热映
    movielist(:data="moviesList")

</template>


<script>
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
<style>

.index-page {
  margin: 0 10%;
}
.hot-showing, .will-show, .title {
  color: #27a;
  font-size: 30px;
  text-align: left;
  margin-bottom: 20px;
  font-weight: bold;
}
.moviesList-container {
  margin-left: 0px !important;
}
.el-carousel img {
  width: 100%;
}

.el-carousel {
  margin-bottom: 20px;
  min-width: 500px;
}

.el-carousel-item {
  display: table-cell; //主要是这个属性
  vertical-align: middle;
  text-align: center;
}

.el-carousel__container {
  min-width: 1100px;
}

</style>
