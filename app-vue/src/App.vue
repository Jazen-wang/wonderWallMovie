<template lang="jade">
#app
  dheader
  transition(name='fade')
    keep-alive(exclude='moviesDetail')
      router-view
      
</template>

<script>
import dheader from './components/header'
export default {
  components: {
    dheader
  }
}
</script>

<style lang="sass">
@import './styles/base.sass';
</style>
