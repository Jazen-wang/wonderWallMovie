<template>
  <el-table :data="sessionList" border style="width: 100%">
    <el-table-column
      prop="language"
      label="语言"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="放映厅"
      width="180">
    </el-table-column>
    <el-table-column
      prop="price"
      label="票价"
      width="180">
    </el-table-column>
    <el-table-column label="在线选座">
      <template scope="scope">
        <el-button
          size="small"
          type="danger"
          @click="showSelectSeatDialog(scope.$index, scope.row)">选座购票</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
      }
    },
    methods: {
      showSelectSeatDialog(index, row) {
        let movieId = this.$route.params['id'];
        this.$store.dispatch('getSeatInfo', {movieId, hallId: row.address});
        this.$store.commit('SELECTED_SESSION', {selectedSession : row});
        this.$store.dispatch('showSelectSeatDialog', row);
      },
    },
    computed: {
      sessionList: function () {
        let sessionList = this.$store.getters.sessionList.map((item, index) => {
          let session = {};
          session.id = item.id;
          session.language = "英语3D";
          session.price = 30;
          session.address = item.number;
          return session;
        });
        
        return sessionList;
      }
    }
  }
</script>