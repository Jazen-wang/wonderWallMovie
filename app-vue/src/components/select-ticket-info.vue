<template lang="jade">
  #select-ticket-info
    .date.info-box
      .label 日期：
      ul(@click="selectDate")
        li(v-for="date in allDate", :class="{'selected': selectedDate == date }") {{ date }}
    .area.info-box
      .label 区域：
      ul(@click="selectArea")
        li(v-for="area in allArea", :class="{'selected': selectedArea == area }") {{ area }}
    .cinema.info-box
      .label 影院：
      ul(@click="selectCinema")
        li(v-for="cinema in cinemaList", :class="{'selected': selectedCinema == cinema.name }") {{ cinema.name }}

    {{cinemaList}}
</template>


<script>
export default {
  data: function() {
    return {
      allDate: ["今天", "明天"],
      allArea: ["地铁附近", "番禺区"],
      selectedDate: "今天",
      selectedArea: "地铁附近",
      selectedCinema: "UA影院"
    }
  },
  methods: {
    selectDate: function(event) {
      if (event.target.tagName != "LI") return false;
      let date = event.target.innerHTML;
      this.selectedDate = date;
    },
    selectArea: function() {
      if (event.target.tagName != "LI") return false;
      let area = event.target.innerHTML;
      this.selectedArea = area;
    },
    selectCinema: function() {
      if (event.target.tagName != "LI") return false;
      let cinema = event.target.innerHTML;
      this.selectedCinema = cinema;
    }
  },
  computed: {
    cinemaList: function () {
      return this.$store.getters.cinemaList;
    }
  },
  mounted: function () {
    this.$store.dispatch('getCinemaList');
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