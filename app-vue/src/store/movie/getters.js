/**
 * @author 王镇佳 <wzjfloor@163.com>
 * @date 2017/04/17
 */
export const getters = {
  moviesList: state => {
    return state.moviesList
  },
  movieDetail: state => {
    return state.movieDetail
  },
  loginDialogVisible: state => {
    return state.loginDialogVisible
  },
  registerDialogVisible: state => {
    return state.registerDialogVisible
  },
  selectSeatDialogVisible: state => {
    return state.selectSeatDialogVisible
  },
  selectedSession: state => {
    return state.selectedSession
  }
}
