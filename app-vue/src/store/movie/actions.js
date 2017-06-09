import { Utils } from '@/common/utils'

let utils = new Utils()
export const actions = {
  /**
   * 获取正在热映电影列表
   * @param commit
   */
  getHotMovies ({commit, state}) {
    utils.get('/hotMovies', {city: state.city}).then(res => {
      commit('HOT_MOVIES_LIST', {list: res})
    })
  },
  /**
   * 获取电影列表
   * @param commit
   */
  getMovies ({commit, state}) {
    utils.get('/movies', {city: state.city}).then(res => {
      commit('MOVIES_LIST', {list: res})
    })
  },
  /**
   *获取电影详情
   * @param commit
   */
  getMovieDetail ({commit, state}) {
    utils.get(`/movies/${state.id}`, {}).then(res => {
      console.log(res);
      debugger;
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
  },
  /**
   * 显示注册对话框
   */
  showSelectSeatDialog ({commit, state}, session) {
    commit('SELECT_SEAT_DIALOG_VISIBLE', {visible: true, session: session})
  },
  /**
   * 隐藏注册对话框
   */
  hideSelectSeatDialog ({commit, state}) {
    commit('SELECT_SEAT_DIALOG_VISIBLE', {visible: false})
  },
  /**
   * 登录
   */
  login({commit, state}, user) {
    commit('LOGIN_USER', {user: user});
  }
}
