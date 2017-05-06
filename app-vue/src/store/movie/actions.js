import { Utils } from '@/common/utils'

let utils = new Utils()
export const actions = {
  /**
   * 获取电影列表
   * @param commit
   */
  getMovies ({commit, state}) {
    utils.get('/movie/in_theaters', {city: state.city}).then(res => {
      commit('MOVIES_LIST', {list: res})
    })
  },
  /**
   *获取电影详情
   * @param commit
   */
  getMovieDetail ({commit, state}) {
    utils.get(`/movie/subject/${state.id}`, {}).then(res => {
      // commit('DETAIL_LOADING', {loading: false})
      commit('MOVING_DETAIL', {movieDetail: res})
    })
  },
  /**
   * 显示登陆对话框
   */
  showLoginDialog ({commit, state}) {
    commit('LOGIN_DIALOG_VISIBLE', {visible: true})
  },
  /**
   * 隐藏登陆对话框
   */
  hideLoginDialog ({commit, state}) {
    commit('LOGIN_DIALOG_VISIBLE', {visible: false})
  },
  /**
   * 显示注册对话框
   */
  showRegisterDialog ({commit, state}) {
    commit('REGISTER_DIALOG_VISIBLE', {visible: true})
  },
  /**
   * 隐藏注册对话框
   */
  hideRegisterDialog ({commit, state}) {
    commit('REGISTER_DIALOG_VISIBLE', {visible: false})
  }
}
