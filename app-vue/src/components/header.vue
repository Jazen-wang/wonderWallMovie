<!-- @author: 王镇佳 <wzjfloor@163.com>
     @date: 2016.04.15
 -->
<template lang="jade">
.ww-navbar
  LoginDialog
  RegisterDialog
  .ww-navbar-container
    .navbar-content
      a.title WonderWall
      .tabs
        el-button.tab-item(type="text", v-for="(bar, index) in barList" ,
          :key="index", @click="changeUrl(bar, index)", :class="{'active': $route.path == bar.url }") {{ bar.title }}
      .search-container
        el-input(placeholder='电影、影院', v-model='content', icon="search", :on-icon-click="searchMovie")
      el-button.login-btn(type="text", @click="showLoginDialog") 登陆

</template>

<script>
import LoginDialog from './login-dialog'
import RegisterDialog from './register-dialog'
  export default {
    components: {
      LoginDialog, RegisterDialog
    },
    data () {
      return {
        content: '',
        title: '首页',
        barList: [{
          title: '首页',
          url: '/'
        }, {
          title: '电影',
          url: '/movies'
        }]
      }
    },
    methods: {
      changeUrl (bar, index) {
        this.$router.push(bar.url)
      },
      searchMovie () {
        this.$store.commit('SEARCH_TEXT', {searchText: this.content})
        this.$store.dispatch('getSearchList')
        this.$store.commit('SEARCH_LOADING', {loading: true})
        this.$router.push({path: '/search', query: {searchText: this.content}})
      },
      showLoginDialog () {
        this.$store.dispatch('showLoginDialog')
      }
    }
  }
</script>
<style lang="sass">
.ww-navbar
  background: #fff
  width: 100%

  .ww-navbar-container
    width: 100%
    margin: 0 auto
    border-bottom: 1px solid #d8d8d8
    .navbar-content
      margin: 0 10%
      height: 75px
      .title
        color: #000
        font-size: 30px
        font-weight: bold
        line-height: 75px
        text-decoration-line: none
        float: left

      .search-container
        display: inline-block
        line-height: 75px
        vertical-align: top
        width: 250px
        margin-left: 50px
        margin-right: 50px
        input
          height: 34px

      .tabs
        height: 100%
        display: inline-block
        margin-left: 6%
        .tab-item
          width: 80px
          height: 100%
          color: #00b7ff
          border-radius: 0
          margin-left: 0
          font-size: 18px
          &:hover
            background-color: #eee
        .active
          background-color: #00b7ff
          color: #fff
          &:hover
            background-color: #00b7ff

      .login-btn
        width: 80px
        height: 100%
        float: right
        color: #00b7ff
        font-size: 18px
      .ww-title-img
        width: 175px
        height: 90px
        float: right
        margin-top: 10px

</style>
