/**
 * @author monkeywang
 * Date: 17/3/15
 */
import * as types from './types'
export const mutations = {
  [types.MOVIES_LIST] (state, {list}) {
    state.moviesList = list
  }
}
