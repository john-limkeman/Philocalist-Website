<template>
  <div>
      <h1>Thank You Cards</h1>
      <StationaryListing v-bind:StationaryType="this.category" />
  </div>
</template>

<script>
import StationaryListing from '../components/StationaryListing.vue';
export default {
data(){
  return{
    category: 'thankYou', //category naming convention from the DB
  }
},
computed: {},
components: {
  StationaryListing,
},
created(){

}
}
</script>

<style>

</style>