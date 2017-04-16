<template lang="html">
  <div>
    <div id="banner">
      <div class="container">
        <img src="../assets/test.jpg" alt="test" class="poster">
        <div class="info-box">
          <h2>速度与激情8</h2>
          <p>The Fate of the Furious</p>
          <ul class="list">
            <li>动作,惊悚,犯罪</li>
            <li>美国 / 136分钟</li>
            <li>2017-04-14大陆上映</li>
          </ul>
          <p class="score">用户评分: 9.5</p>
        </div>
      </div>
    </div>
    <div id="operation">
      <button type="button" name="buy" class="buy-btn">购买</button>

    </div>
  </div>

</template>

<script>
export default {
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
        bottom: 10px
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
