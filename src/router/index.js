import Vue from 'vue'
import Router from 'vue-router'
// 正在热映模块
// import onshowing from '@/components/onshowing'
// 即将上映模块
import upcoming from '@/components/upcoming'
import index from '@/components/index-page'

Vue.use(Router)
// 使用html5模式
var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'onshowing',
      component: index
    },
    {
      path: '/upcoming',
      name: 'upcoming',
      component: upcoming
    }
  ]
})

export default router
