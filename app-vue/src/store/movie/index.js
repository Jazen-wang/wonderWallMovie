import {getters} from './getters'
import {actions} from './actions'
import {mutations} from './mutations'
const state = {
  moviesList: {  // 正在上映列表
    subjects: []
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
