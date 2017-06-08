<template lang="jade">
  #movies-view
    el-radio-group(v-model="sortType")
      el-radio(:label="1") 按名字排序
      el-radio(:label="2") 按时间排序
      el-radio(:label="3") 按评价排序
    movielist(:data="sortMovies")
</template>

<script>
import movielist from '@/components/movie-list'

export default {
  name: 'hello',
  data () {
    return {
      sortType: 1
    }
  },
  components: {
    movielist
  },
  mounted: function() {
    // 如果不为空，获取正在上映的列表
    this.$store.dispatch('getMovies');
  },
  watch: {
    // 观察排序选项，对电影进行排序
    sortType: function() {
      switch(this.sortType) { 
        case 1:
          this.sortMovies.sort(this.compareTitle);
          break;
        case 2:
          this.sortMovies.sort(this.compareId);
          break;
        case 3:
          console.log(this.sortMovies)
          this.sortMovies.sort(this.compareScore);
          console.log(this.sortMovies)
          break;
        default:
          this.sortMovies.sort(this.compareTitle);
      }
    }
  },
  methods: {
    // 对电影的标题进行排序（升序）
    compareTitle: function(a, b) {
      return a.title.localeCompare(b.title);
    },
    // 对电影的评分进行排序（降序）
    compareScore: function(a, b) {
      return a.rating.average > b.rating.average;
    },
    // 对电影的时间进行排序（没有时间？？？，用id大小来排吧）
    compareId: function(a, b) {
      return a.id > b.id;
    }
  },
  computed: {
    sortMovies () {
      return this.$store.getters.moviesList.subjects;
    }
  }

}
</script>

<style media="screen" lang="sass" scoped>
@import "../styles/pages/movies.sass"
</style>
