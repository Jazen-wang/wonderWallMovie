/**
 * @author monkeywang
 * Date: 17/3/15
 */
import * as types from './types'
export const mutations = {
  [types.MOVIES_LIST] (state, {list}) {
    for (let subject of list.subjects) {
      subject.rating.average = subject.rating.average / 2
    }
    state.moviesList = list
  },
  [types.MOVING_ID] (state, {id}) {
    state.id = id
  },
  [types.MOVING_DETAIL] (state, {movieDetail}) {
    movieDetail.rating.average = movieDetail.rating.average / 2
    state.movieDetail = movieDetail
  },
  [types.LOGIN_DIALOG_VISIBLE] (state, {visible}) {
    state.loginDialogVisible = visible
  },
  [types.REGISTER_DIALOG_VISIBLE] (state, {visible}) {
    state.registerDialogVisible = visible
  },
}
