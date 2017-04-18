import Vue from 'vue'
import Router from 'vue-router'
// 首页
import index from '@/components/index-page'
// 电影页
import movies from '@/components/movies'
// 电影详情页
import moviesDetail from '@/components/movies-detail'
// 选座
import selectSeats from '@/components/select-seat'

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
    },
    {
      path: '/movies/:id',
      name: 'moviesDetail',
      component: moviesDetail
    },
    {
      path: '/select/:id',
      name: 'selectSeats',
      component: selectSeats
    }
  ]
})

export default router
