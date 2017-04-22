<template lang="jade">
div
  #banner
    .container
      img.poster(:src="movieDetail.images.large")
      .info-box
        h2 {{movieDetail.title}}
        p {{movieDetail.original_title}}
        ul.list
          li
            span(v-for="item in movieDetail.genres") {{item}}
          li
            span(v-for="(item,index) in movieDetail.countries") {{item}}
          li 2017-04-14大陆上映
        p.score 用户评分: {{movieDetail.rating.average * 2}}
  #operation
    button.buy-btn(type="button", name="buy") 购买
</template>

<script>
export default {
  data: function() {
    return {}
  },
  computed: {
    movieDetail () {
      return this.$store.getters.movieDetail
    }
  },
  mounted () {
    let id = this.$route.params['id'];
    this.$store.commit('MOVING_ID', {id});
    this.$store.dispatch('getMovieDetail');
  },
}
</script>

<style lang="sass">

$buy-btn-color: #df2d2d
$buy-btn-color-active: #b12424

#banner
  background-image: url('../assets/banner.png')
  background-position: center
  background-size: cover
  background-repeat: no-repeat
  width: 100%
  height: 400px
  .container
    position: relative
    width: 1000px
    height: 360px
    margin-left: auto
    margin-right: auto
    text-align: left
    padding-top: 40px
    color: #fff
    .poster
      float: left
      height: 330px
      border: 2px solid #fff
    .info-box
      margin-left: 20px
      float: left
      h2
        font-size: 28px
        margin: 0
      p
        font-size: 22px
        margin-top: 0
      .list
        font-size: 15px
        list-style: none
        li
          margin: 4px 0
      .score
        position: absolute
        bottom: 20px
        font-size: 15px

#operation
  margin-top: 30px
  width: 1000px
  margin-left: auto
  margin-right: auto
  text-align: left
  .buy-btn
    cursor: pointer
    color: #fff
    font-size: 18px
    outline: none
    border: none
    background: $buy-btn-color
    width: 100px
    height: 40px
    &:active
      background: $buy-btn-color-active
</style>
