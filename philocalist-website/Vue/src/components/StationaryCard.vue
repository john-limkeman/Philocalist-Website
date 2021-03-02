<template>
  <div id="cardContainer">
    <img v-bind:src="this.stationary.imgURL" alt="error"/>
    <h2>{{this.stationary.title}}</h2>
  </div>
</template>

<script>
import StationaryService from "../services/StationaryService.js";

export default {
  data() {
    return {
      stationary: [],
    };
  },
  computed: {},
  methods: {},
  props: ["id", "isCart"],

  created() {
    StationaryService.getStationaryById(this.id).then((response) => {
      this.stationary = response.data;
    });
  },
};
</script>

<style>
</style>