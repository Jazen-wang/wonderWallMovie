/**
 * @author monkeywang
 * Date: 17/3/15
 */
import * as types from './types'
export const mutations = {
  [types.MOVING_LIST] (state, {list}) {
    console.log(list)
    state.movingList = list
  }
}
