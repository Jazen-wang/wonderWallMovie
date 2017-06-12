import {getters} from './getters'
import {actions} from './actions'
import {mutations} from './mutations'
const state = {
  hotmoviesList: {
    subjects: []
  },
  moviesList: {  // 正在上映列表
    subjects: []
  },
  movieDetail: { // 电影详情
    rating: {},
    images: {}
  },
  id: '', // 电影ID
  name: '', // 电影名称
  cinemaList: [], // 电影院列表
  sessionList: [], // 场次列表
  seatInfo: null, // 座位信息
  loginDialogVisible: false, // 登陆对话框
  registerDialogVisible: false, // 注册对话框
  selectSeatDialogVisible: false, // 选座对话框
  user: null, // 登录用户
  selectedCinema: null, // 选择影院
  selectedSession: null, // 选择场次
  selectedSeat: [], // 选择座位
  orderResult: null, // 下单结果
}

export default {
  state,
  getters,
  actions,
  mutations
}
