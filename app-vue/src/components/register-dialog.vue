<template lang="jade">
el-dialog(title="注册", v-model="registerDialogVisible", @close="cancel", size="tiny")
  el-form(:model="form")
    el-form-item(label="用户名")
      el-input(v-model="form.username", auto-complete="off")
    el-form-item(label="密码")
      el-input(v-model="form.password", auto-complete="off")
    el-form-item(label="重复密码")
      el-input(v-model="form.repassword", auto-complete="off")
  .dialog-footer(slot="footer")
    el-button(@click="cancel") 取消
    el-button(type="primary", @click="confirm") 注册


</template>

<script>
  export default {
    data: function() {
      return {
        form: {
          username: '',
          password: '',
          repassword: ''
        },
      }
    },
    computed: {
      registerDialogVisible () {
        return this.$store.getters.registerDialogVisible
      }
    },
    methods: {
      cancel: function() {
        this.$store.dispatch('hideRegisterDialog')
      },
      confirm: function() {
        this.$store.dispatch('hideRegisterDialog')
      }
    }
  }
</script>

<style lang="sass">
  .el-dialog__body
 
</style>