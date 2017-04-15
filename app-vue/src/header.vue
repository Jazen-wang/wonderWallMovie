<!-- @author: 王镇佳 <wzjfloor@163.com>
     @date: 2016.04.15
 -->
<template lang="jade">
.ww-header
  .ww-header-container
    .ww-search
      a.title wonderWall电影
      .search-container
        el-input(placeholder='电影、影院', v-model='content')
          el-button(slot='append', icon='search', @click='searchMovie')
    ul.ww-bar
      li(v-for='bar in barList', @click='choiceUrl(bar.title)')
        router-link(:to='bar.url', :class="title===bar.title? 'active':''") {{bar.title}}

</template>

<script>
  export default{
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
      choiceUrl (title) {
        this.title = title
      },
      searchMovie () {
        this.$store.commit('SEARCH_TEXT', {searchText: this.content})
        this.$store.dispatch('getSearchList')
        this.$store.commit('SEARCH_LOADING', {loading: true})
        this.$router.push({path: '/search', query: {searchText: this.content}})
      }
    }
  }
</script>
<style lang="sass">
.ww-header
  background: #f0f3f5
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
    border-bottom: 1px solid #e3ebec
    .ww-search
      width: 950px
      margin: 0 auto
      height: 75px
      .title
        color: #27a
        font-size: 30px
        font-weight: bold
        line-height: 75px
        float: left

      .search-container
        display: inline-block
        line-height: 75px
        vertical-align: top
        width: 500px
        margin-left: 50px
        input
          height: 34px

      .ww-title-img
        width: 175px
        height: 90px
        float: right
        margin-top: 10px

</style>
