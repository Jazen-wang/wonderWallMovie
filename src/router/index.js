import Vue from 'vue'
import Router from 'vue-router'
import main from '@/views/main'
import IndexPage from '@/views/index-page'
import test from '@/views/test'

Vue.use(Router)
// 使用html5模式
var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      component: main,
      children: [
        { path: 'index', component: IndexPage, name: 'index-page' },
        { path: 'test', component: test, name: 'test-page' }
      ]
    }
  ]
})

export default router
