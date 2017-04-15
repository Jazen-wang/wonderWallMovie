/*
 * @author 王镇佳 <wzjfloor@163.com>
 * @description store vuex 初始化
 */

import Vue from 'vue'
import Vuex from 'vuex'
import moving from './moving/index'

Vue.use(Vuex)

export default new Vuex.store({
  modules: {
    moving
  }
})
