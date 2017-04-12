<template lang="jade">
  #app
    router-view
</template>

<script>

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
html, body, #app {
  width: 100%;
  height: 100%;
}
.fade-enter {
  animation: fade-in .5s;
}
.fade-leave {
  animation: fade-out .5s;
}
@keyframes fade-in {
  0% {
    opacity: 0
  }
  100% {
    opacity: 1
  }
}
@keyframes fade-out {
  0% {
    opacity: 0
  }
  100% {
    opacity: 1
  }
}
</style>
