import Vue from 'vue'
import Router from 'vue-router'
import index from '@/pages/index-page' // 首页
import moviesDetail from '@/components/movies-detail' // 电影详情页
import selectSeats from '@/components/select-seat' // 选座
import selectTicketInfo from '@/components/select-ticket-info' // 选详情
import movies from '@/pages/movies' // 电影页

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
      name: 'selectTicketInfo',
      component: selectTicketInfo
    }
  ]
})

export default router
