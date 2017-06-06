import Vue from 'vue'
import Router from 'vue-router'
// 首页
import index from '@/pages/index-page'
// 电影详情页
import movieDetailPage from '@/pages/movie-detail-page'
// 选择影院
import selectCinema from '@/pages/select-cinema'
// 选座
import selectSeats from '@/components/select-seat'
// 电影页
import movies from '@/pages/movies'

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
      name: 'movieDetail',
      component: movieDetailPage
    },
    {
      path: '/select/',
      name: 'selectSeats',
      component: selectSeats
    },
    {
      path: '/movies/:id/cinema',
      name: 'selectCinema',
      component: selectCinema
    }
  ]
})

export default router
