<template>
  <div>
      <h1>Wedding Invites</h1>
         <div v-for="invite in stationaries" v-bind:key="invite.id" >
        <h2>{{invite.theme}}</h2>
        <img v-bind:src="invite.imgURL" alt="error">
         </div>
  </div>
</template>

<script>
// becuase its in a folder, it needs an additional '../' appended to imports
import StationaryService from "../../services/StationaryService.js";
export default {
  data() {
    return{
      stationaries: []
    }
  },
    created() {
    StationaryService.getAllStationary().then((response) => {
      this.stationaries = response.data;
    });
  },
}
</script>

<style>

</style>