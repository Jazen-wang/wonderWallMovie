<template lang="jade">
el-dialog(title="注册", v-model="registerDialogVisible", @close="cancel", size="tiny")
  el-form(:model="form")
    el-form-item(label="用户名")
      el-input(v-model="form.username", auto-complete="off", placeholder="8-16位字母数字组合", pattern="/\w/g")
    el-form-item(label="密码")
      el-input(v-model="form.password", auto-complete="off", placeholder="6-16位字母数字组合")
    el-form-item(label="重复密码")
      el-input(v-model="form.repassword", auto-complete="off", placeholder="重复密码")
    span 已有账号?点击
      el-button(type="text" @click="login") 登录
  .dialog-footer(slot="footer")
    el-button(@click="cancel") 取消
    el-button(type="primary", @click="confirm", :load='loading') {{!loading ? '注册' : '请稍等'}}
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
        loading: false
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
        this.loading = true;
        let user = {
          username: this.username,
          password: this.password
        }
        this.$http.post('api/register', user)
          .then(res => { 
            this.$store.dispatch('login', user);
            this.loading = false;
            this.$store.dispatch('hideRegisterDialog');
            this.$message({
              message: '注册成功，现已登录',
              type: 'success'
            });
          })
      },
      login: function() {
        this.cancel();
        this.$store.dispatch('showLoginDialog');
      }
    }
  }
</script>
