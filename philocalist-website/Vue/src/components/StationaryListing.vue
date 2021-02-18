<template>
  <div>
      <!--should be replaced with a card component?  At the very least create a pop-out for the details-->
  <div v-for="invite in stationaries" v-bind:key="invite.id" >
        <h2>{{invite.theme}}</h2>
        <img v-bind:src="invite.imgURL" alt="error">
    </div>
  </div>
</template>

<script>
import StationaryService from '../services/StationaryService.js';
export default {
    data(){
        return{
            stationaries: [],
        }
    },
    props: ["StationaryType"],
    computed: {
        pageCategory(){
            return this.StationaryType;
        }
    },
      created() {
    StationaryService.getAllStationaryByCategory(this.pageCategory).then((response) => {
      this.stationaries = response.data;
    });
  },
}
</script>

<style>

</style>