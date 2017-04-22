import { Utils } from '@/common/utils'

let utils = new Utils()
export const actions = {
  /**
   * 获取电影列表
   * @param commit
   */
  getMovies ({commit, state}) {
    utils.get('/movie/in_theaters', {city: state.city}).then(res => {
      console.log(res);
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
}
