/**
 * @author 王镇佳 <wzjfloor@163.com>
 * @date 2017/04/17
 */
export const getters = {
  moviesList: state => {
    if (state.moviesList) {
      for (let subject of state.moviesList.subjects) {
        subject.rating.average = subject.rating.average / 2
      }
      return state.moviesList
    }
  },
  movieDetail: state => {
    state.movieDetail.rating.average = state.movieDetail.rating.average / 2
    return state.movieDetail
  },
}
