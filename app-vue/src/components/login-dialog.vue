<template lang="jade">
el-dialog(title="登录", v-model="loginDialogVisible", @close="cancel", size="tiny", :lock-scroll="false")
  el-form(:model="form")
    el-form-item(label="用户名")
      el-input(v-model="form.username", auto-complete="off", placeholder="8-16位字母数字组合")
    el-form-item(label="密码")
      el-input(v-model="form.password", auto-complete="off", placeholder="密码", type="password")
    el-form-item
      el-checkbox(v-model="form.remember") 记住我
    span 没有账号?点击
      el-button(type="text" @click="register") 注册
  .dialog-footer(slot="footer")
    el-button(@click="cancel") 取消
    el-button(type="primary", @click="confirm", :loading="loading") {{!loading? '登录':'登录中'}}
</template>

<script>
  export default {
    data: function() {
      return {
        form: {
          username: '',
          password: '',
          remember: false,
        },
        loading: false,
      }
    },
    computed: {
      loginDialogVisible () {
        return this.$store.getters.loginDialogVisible;
      }
    },
    methods: {
      cancel: function() {
        this.$store.dispatch('hideLoginDialog');
      },
      confirm: function() {
        this.loading = true;
        let user = {
          username: this.username,
          password: this.password
        }
        
        this.$http.post('api/login', user)
          .then(res => {
            this.$store.dispatch('login', user);
            this.loading = false;
            this.$store.dispatch('hideLoginDialog');
            this.$message({
              message: '登陆成功',
              type: 'success'
            });
          })
      },
      register: function() {
        this.cancel();
        this.$store.dispatch('showRegisterDialog');
      }
    }
  }
</script>
