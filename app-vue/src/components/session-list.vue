<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column
      prop="time"
      label="时间"
      width="180">
    </el-table-column>
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
        tableData: [{
          time: '12:00 − 14:22',
          language: '英语3D',
          address: '7号厅',
          price: 33
        }, {
          time: '13:15 − 15:37',
          language: '英语3D',
          address: '3号厅',
          price: 33
        }, {
          time: '14:25 − 16:47',
          language: '英语3D',
          address: '1号厅',
          price: 33
        }, {
          time: '15:45 − 18:07',
          language: '英语3D',
          address: '2号厅',
          price: 33
        }]
      }
    },
    methods: {
      showSelectSeatDialog(index, row) {
        this.$store.dispatch('showSelectSeatDialog', row);
      },
    }
  }
</script>