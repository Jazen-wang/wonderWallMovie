<template lang="jade">
  #select-ticket-info
    .date.info-box
      .label 日期：
      ul(@click="selectDate")
        li(v-for="date in allDate", :class="{'selected': selectedDate == date }") {{ date }}
    .cinema.info-box
      .label 影院：
      ul(@click="selectCinema")
        li(v-for="(cinema, index) in cinemaList", :class="{'selected': selectedCinemaIndex == index }", :cinema-key="index", :cinema-id='cinema.id') {{ cinema.name }}
</template>


<script>
export default {
  data: function() {
    return {
      allDate: ["今天", "明天"],
      selectedDate: "今天",
      selectedCinemaIndex: 0,
    }
  },
  methods: {
    selectDate: function(event) {
      if (event.target.tagName != "LI") return false;
      let date = event.target.innerHTML;
      this.selectedDate = date;
    },
    selectCinema: function() {
      if (event.target.tagName != "LI") return false;
      let cinemaIndex = event.target.getAttribute('cinema-key');
      this.selectedCinemaIndex = +cinemaIndex;

      let movieId = +this.$route.params['id'];
      let cinemaId = +event.target.getAttribute('cinema-id');
      this.$store.commit('SELECTED_CINEMA', {selectedCinema: cinemaId});
      this.$store.dispatch('getSessionList', {movieId, cinemaId});
    }
  },
  computed: {
    cinemaList: function () {
      return this.$store.getters.cinemaList;
    }
  },
  watch: {
    cinemaList: function () {
      if (this.cinemaList.length != 0) {
        let movieId = +this.$route.params['id'];
        let cinemaId = +this.cinemaList[0].id;
        this.$store.commit('SELECTED_CINEMA', {selectedCinema: cinemaId});
        this.$store.dispatch('getSessionList', {movieId, cinemaId});
      }
    }
  },
  mounted: function () {
    let movieId = +this.$route.params['id'];
    this.$store.dispatch('getCinemaList', movieId);
    
  }
}
</script>

<style lang="sass">
#select-ticket-info
  margin-left: auto
  margin-right: auto
  ul
    display: inline-block
  li
    display: inline-block
    padding: 0 5px
    margin: 0 2px
    cursor: pointer
    border: 1px solid #fff
    &:hover
      border: 1px solid #2bb8aa
      border-radius: 2px
  .selected
    border: 1px solid #2bb8aa
    background-color: #2bb8aa
    border-radius: 2px
    color: #fff
  .info-box
    position: relative
    padding-top: 10px
    padding-bottom: 10px
    padding-left: 50px
  .label
    position: absolute
    display: inline-block
    left: 5px
</style>