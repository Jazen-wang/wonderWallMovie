<template lang="jade">
el-dialog(title="提示", :visible.sync="dialogVisible", size="tiny", :before-close="handleClose")
  span 这是一段信息
  span.dialog-footer(slot="footer")
    el-button(@click="dialogVisible = false") 取 消
    el-button(type="primary", @click="dialogVisible = false") 确 定

</template>

<script>
  export default {
    data: function() {
      return {
        dialogVisible: false,
      }
    },
    computed: {
      loginDialogVisible () {
        return true
        // return this.$store.getters.loginDialogVisible
      },
      handleClose(done) {
        // this.$confirm('确认关闭？')
        //   .then(_ => {
        //     done();
        //   })
        //   .catch(_ => {});
      }
    }
  }
</script>