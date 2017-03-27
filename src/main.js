// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Resource from 'vue-resource'
import Iview from 'iview'
import 'iview/dist/styles/iview.css'
import router from './router/index.js'
import Carousel3d from 'vue-carousel-3d'

Vue.use(Resource)
Vue.use(Iview)
Vue.use(Carousel3d)

// Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
