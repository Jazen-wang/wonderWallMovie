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
}

export default {
  state,
  getters,
  actions,
  mutations
}
