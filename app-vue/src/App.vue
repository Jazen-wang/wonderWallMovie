<template lang="jade">
#app
  dheader
  LoginDialog
  transition(name='fade')
    keep-alive(exclude='moviesDetail')
      router-view
      
</template>

<script>
import Dheader from './header'
import LoginDialog from './components/login-dialog'
export default {
  components: {
    Dheader, LoginDialog
  }
}
</script>

<style lang="sass">
@import './styles/base.sass';

</style>
