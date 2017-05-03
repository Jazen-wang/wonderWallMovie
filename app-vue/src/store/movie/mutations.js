/**
 * @author monkeywang
 * Date: 17/3/15
 */
import * as types from './types'
export const mutations = {
  [types.MOVIES_LIST] (state, {list}) {
    state.moviesList = list
  },
  [types.MOVING_ID] (state, {id}) {
    state.id = id
  },
  [types.MOVING_DETAIL] (state, {movieDetail}) {
    state.movieDetail = movieDetail
  },
  [types.LOGIN_DIALOG_VISIBLE] (state, {visible}) {
    state.loginDialogVisible = visible
  },
}
