<template lang="jade">
.index-page
  el-carousel
    el-carousel-item(v-for="item in carousels" key="item.src")
      img(:src="item.src")
  .hot-showing
    .title 正在热映（可立即购票）
    movielist(:data="moviesList" v-bind:showBuy='true')

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
    // 获取正在热映的列表
    this.$store.dispatch('getHotMovies')
  },
  components: {
    movielist
  },
  computed: {
    moviesList () {
      return this.$store.getters.hotmoviesList.subjects
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="sass" scoped>
@import "../styles/pages/index-page.sass"
</style>
