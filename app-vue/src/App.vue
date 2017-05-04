<template lang="jade">
#app
  dheader
  transition(name='fade')
    keep-alive(exclude='moviesDetail')
      router-view
      
</template>

<script>
import Dheader from './header'
export default {
  components: {
    Dheader
  }
}
</script>

<style lang="sass">
@import './styles/base.sass';

</style>
