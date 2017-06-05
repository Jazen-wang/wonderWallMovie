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
      LoginDialog,
      RegisterDialog
    },
    
    data() {
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
      changeUrl(bar, index) {
        this.$router.push(bar.url)
      },
      searchMovie() {
        this.$store.commit('SEARCH_TEXT', {
          searchText: this.content
        })
        this.$store.dispatch('getSearchList')
        this.$store.commit('SEARCH_LOADING', {
          loading: true
        })
        this.$router.push({
          path: '/search',
          query: {
            searchText: this.content
          }
        })
      },
      showLoginDialog() {
        this.$store.dispatch('showLoginDialog')
      }
    }
  }
</script>

<style lang="sass" scoped>
@import "../styles/components/header.sass"
</style>
