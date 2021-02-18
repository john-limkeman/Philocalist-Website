<template>
  <div>
    <h1>Save The Dates</h1>
    <!-- replace this with component that reads in an arg from parent to determine which sql query to run -->
    <!-- <div v-for="invite in stationaries" v-bind:key="invite.id" >
        <h2>{{invite.theme}}</h2>
        <img src="invite.imgURL" alt="error">
    </div> -->
  </div>
</template>

<script>
// becuase its in a folder, it needs an additional '../' appended to imports
// import StationaryService from "src/services/StationaryService.js";
export default {
  data() {
    return{
      stationaries: []
    }
  },
  computed: {},
  // created() {
  //   StationaryService.getAllStationary().then((response) => {
  //     this.stationaries = response.data;
  //   });
  // },
};
</script>

<style>
</style>