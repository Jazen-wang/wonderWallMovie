<template lang="jade">
  #movies-view
    el-radio-group(v-model="sortType")
      el-radio(:label="1") 按热门排序
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
          this.sortMovies.sort(this.compareScore);
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
      return a.rating.average*2 > b.rating.average*2;
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

<style media="screen" lang="sass">
$score-color: #ffb400

#movies-view
  margin: 0 10%
  .el-radio-group
    margin-bottom: 20px
    margin-top: 20px
    display: block
    text-align: left
  .movie-list
    .el-col
      margin-top: 15px
      width: 200px
      padding: 0 10px
      .item
        position: relative
        cursor: pointer
        text-align: left
        border: 1px solid #efefef
        border-radius: 2px
        transition: all 0.2s
        &:hover
          box-shadow: 0 0 8px #fff, 0 5px 13px rgba(0,0,0,.07)
          // box-shadow: 1px 1px 1px #eee
        .poster
          width: 100%
          height: 250px
          background-image: url('../assets/test.jpg')
          background-position: center
          background-size: cover
          background-repeat: no-repeat
        .linear-cover
          position: absolute
          margin-top: -40px
          width: 100%
          height: 40px
          background: linear-gradient(rgba(0,0,0,0), rgba(0,0,0,0.6))
          .info
            padding: 0 10px
            box-sizing: border-box
            position: absolute
            width: 100%
            bottom: 7px
            line-height: 18px
            .title
              color: #fff
              font-size: 16px
              margin-right: 35px
              white-space: nowrap
              overflow: hidden
              text-overflow: ellipsis
            .score
              color: $score-color
              float: right
        .buy-btn
          outline: none
          cursor: pointer
          border: 0
          width: 100%
          height: 40px
          background-color: #fff
          color: #ef4238
          transition: all 0.2s
          &:hover
            background-color: #ef4238
            color: #fff
</style>
