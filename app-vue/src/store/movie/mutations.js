/**
 * @author monkeywang
 * Date: 17/3/15
 */
import * as types from './types'
export const mutations = {
  [types.HOT_MOVIES_LIST] (state, {list}) {
    for (let subject of list.subjects) {
      subject.rating.average = subject.rating.average / 2
    }
    state.hotmoviesList = list
  },
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
  [types.SELECT_SEAT_DIALOG_VISIBLE] (state, {visible, session}) {
    state.selectSeatDialogVisible = visible;
    state.selectedSession = session;
  },
  [types.LOGIN_USER] (state, {user}) {
    state.user = user;
  },
  [types.CINEMA_LIST] (state, {cinemaList}) {
    state.cinemaList = cinemaList;
  },
  [types.SESSION_LIST] (state, {sessionList}) {
    state.sessionList = sessionList;
  },
  [types.SEAT_INFO] (state, {seatInfo}) {
    state.seatInfo = seatInfo;
  },
  [types.SELECTED_CINEMA] (state, {selectedCinema}) {
    state.selectedCinema = selectedCinema;
  },
  [types.SELECTED_SESSION] (state, {selectedSession}) {
    state.selectedSession = selectedSession;
  }
}
