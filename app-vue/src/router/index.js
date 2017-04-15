import Vue from 'vue'
import Router from 'vue-router'
// 首页
import index from '@/components/index-page'
// 电影页
import movies from '@/components/movies'

Vue.use(Router)
// 使用html5模式
var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/movies',
      name: 'movies',
      component: movies
    }
  ]
})

export default router
