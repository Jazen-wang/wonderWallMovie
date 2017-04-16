<template>
  <div id="movies-view">
    <el-radio-group v-model="sortType">
      <el-radio :label="1">按热门排序</el-radio>
      <el-radio :label="2">按时间排序</el-radio>
      <el-radio :label="3">按评价排序</el-radio>
    </el-radio-group>
    <div class="movie-list">
      <el-row>
        <el-col v-for="item in movies">
          <div class="item">
            <div class="poster"></div>
            <div class="linear-cover">
              <div class="info">
                <i class="score"> {{ item.score }} </i>
                <div class="title"> {{ item.title }} </div>
              </div>
            </div>
            <button type="button" name="buy-btn" class="buy-btn">购买</button>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>

var movies = [
  { title: "速度与激情8", score: 9.5 },
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
  width: 1000px
  margin-left: auto
  margin-right: auto
  .el-radio-group
    margin-left: 20px
    margin-top: 40px
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
        .poster
          width: 100%
          height: 220px
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
