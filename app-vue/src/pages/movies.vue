<template>
  <div id="movies-view">
    <el-radio-group v-model="sortType">
      <el-radio :label="1">按热门排序</el-radio>
      <el-radio :label="2">按时间排序</el-radio>
      <el-radio :label="3">按评价排序</el-radio>
    </el-radio-group>
    <div class="movie-list">
      <el-row :gutter="20">
        <el-col :span="4" class="item" v-for="item in movies">
          <div class="poster"></div>
          <a class="title"> {{ item.title }} </a>
          <p class="score"> {{ item.score }} </p>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>

var movies = [
  { title: "1", score: 9.5 },
  { title: "2", score: 8.0 },
  { title: "3", score: 5.5 },
  { title: "4", score: 10.0 },
  { title: "5", score: 8.4 },
  { title: "6", score: 6.2 },
  { title: "7", score: 2.0 },
]

export default {
  name: 'hello',
  data () {
    return {
      movies: movies,
      sortType: 1
    }
  },
  watch: {
    // 观察排序选项，对电影进行排序
    sortType: function() {
      switch(this.sortType) {
        case 1:
          this.movies.sort(this.compareTitle);
          break;
        case 2:
          this.movies.sort(this.compareScore);
          break;
        default:
          this.movies.sort(this.compareTitle);
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
      return a.score > b.score;
    }
  }

}
</script>

<style media="screen" lang="sass">
$score-color: #ffb400

#movies-view
  width: 950px
  margin-left: auto
  margin-right: auto
  .el-radio-group
    margin-top: 40px
    display: block
    text-align: left
  .movie-list
    margin-top: 10px
    .item
      .poster
        width: 100%
        height: 191px
        background-image: url('../assets/logo.png')
        background-position: center
        background-size: contain
        background-repeat: no-repeat
      .title
      .score
        color: $score-color
</style>
