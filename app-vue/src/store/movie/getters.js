/**
 * @author 王镇佳 <wzjfloor@163.com>
 * @date 2017/04/17
 */
export const getters = {
  movingList: state => {
    if (state.movingList) {
      for (let subject of state.movingList.subjects) {
        subject.rating.average = subject.rating.average / 2
      }
      return state.movingList
    }
  }
}
