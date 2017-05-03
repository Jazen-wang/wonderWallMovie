<template lang="jade">
  el-dialog(title="收货地址", :visible.sync="loginDialogVisible")
    el-form(:model="form")
      el-form-item(label="活动名称", :label-width="formLabelWidth")
        el-input(v-model="form.name", auto-complete="off")
      el-form-item(label="活动区域", :label-width="formLabelWidth")
        el-select(v-model="form.region", placeholder="请选择活动区域")
          el-option(label="区域一", value="shanghai")
          el-option(label="区域二", value="beijing")
    .dialog-footer(slot="footer")
      el-button(@click="loginDialogVisible = false") 取 消
      el-button(type="primary", @click="loginDialogVisible = false") 确 定
</template>

<script>
  export default {
    data: function() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
      }
    },
    computed: {
      loginDialogVisible () {
        return true
        // return this.$store.getters.loginDialogVisible
      }
    }
  }
</script>