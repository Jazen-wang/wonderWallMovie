<!-- @author: 王镇佳 <wzjfloor@163.com>
     @date: 2016.04.15
 -->
<template lang="jade">
.ww-header
  .ww-header-container
    .ww-search
      a.title WonderWall
      .search-container
        el-input(placeholder='电影、影院', v-model='content', icon="search", :on-icon-click="searchMovie")
      el-button.login-btn(type="text", @click="showLoginDialog") 登陆
      el-tabs(v-model="activeName", @tab-click="handleClick")
        el-tab-pane(v-for='(bar, index) in barList', :label="bar.title", :name="bar.url", :key="index")

</template>

<script>
  export default{
    data () {
      return {
        activeName: '/',
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
      handleClick(tab, event) {
        this.$router.push(tab.name)
      },
      choiceUrl (title) {
        this.title = title
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
.ww-header
  background: #fff
  width: 100%
  height: 114px

  .ww-bar
    width: 950px
    margin: 0 auto
  ul
    li
      list-style: none
      float: left
      line-height: 20px
      cursor: pointer
      min-width: 80px
      a
        display: inline-block
        padding: 8px 0px
        font-size: 16px
        color: #aaa
        text-decoration: none
        width: 80px
      a.active
        color: #27a

  .ww-header-container
    width: 100%
    margin: 0 auto
    // border-bottom: 1px solid #d8d8d8
    .ww-search
      width: 950px
      margin: 0 auto
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
        width: 500px
        margin-left: 50px
        input
          height: 34px
      
      .login-btn
        height: 100%
        float: right
        color: #00b7ff
      .ww-title-img
        width: 175px
        height: 90px
        float: right
        margin-top: 10px

</style>
