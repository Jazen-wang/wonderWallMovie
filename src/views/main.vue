<template lang="jade">
  #movie
    #movie-nav
      movie-nav
    #movie-main
      router-view
</template>

<script>
import movieNav from '@/components/movie-nav'
export default {
  components: {
    movieNav
  }
}
</script>
<style lang="sass">
#movie-nav
  height: 60px

</style>
