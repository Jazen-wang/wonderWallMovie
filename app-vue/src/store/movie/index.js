import {getters} from './getters'
import {actions} from './actions'
import {mutations} from './mutations'
const state = {
  moviesList: {  // 正在上映列表
    subjects: []
  },
  movieDetail: { // 电影详情
    rating: {},
    images: {}
  },
  id: '', // 电影ID
  loginDialogVisible: false, // 登陆对话框
  registerDialogVisible: false, // 注册对话框
  user: null, // 登录用户
}

export default {
  state,
  getters,
  actions,
  mutations
}
