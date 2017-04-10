<template lang="jade">
  #main-app
    #movie-name
      | wonderWall电影
    Menu(mode='horizontal', :theme='theme1', active-name='1')
      menu-item(name='1')
        icon(type='ios-paper')
        | 首页
</template>

<script>
export default {
  data () {
    return {
      theme1: 'light'
    }
  }
}
</script>
<!--
<style lang="sass">
#main-app

#movie-name, .ivu-menu
  float: left
  display: inline-block

#movie-name
  font-size: 20px
  color: #39f
  font-weight: black
  line-height: 60px
  padding: 0px 30px
  cursor: pointer

</style> -->
