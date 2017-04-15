<template>

  <div id="app">
    <Dheader></Dheader>
    <transition name="fade">
      <keep-alive exclude="moviesDetail">
        <router-view></router-view>
      </keep-alive>
    </transition>
  </div>
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

#app
  font-family: 'Avenir', Helvetica, Arial, sans-serif
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  text-align: center
  color: #2c3e50

html, body, #app
  width: 100%
  height: 100%
  margin: 0
  padding: 0

.fade-enter
  animation: fade-in .5s


@keyframes fade-in
  0%
    opacity: 0

  100%
    opacity: 1

@keyframes fade-out
  0%
    opacity: 0

  100%
    opacity: 1

ul, li
  margin: 0px
  padding: 0px

</style>
