<template>
  <div>
    <h1>Listing</h1>
    <div v-for="item in stationaries" v-bind:key="item.id" >
        <h2>{{item.theme}}</h2>
        <img src="item.imgURL" alt="item.theme">
    </div>
  </div>
</template>

<script>
import StationaryService from "../services/StationaryService.js";
export default {
  data() {
    return{
      stationaries: []
    }
  },
  computed: {},
  created() {
    StationaryService.getAllStationary().then((response) => {
      this.stationaries = response.data;
    });
  },
};
</script>

<style>
</style>