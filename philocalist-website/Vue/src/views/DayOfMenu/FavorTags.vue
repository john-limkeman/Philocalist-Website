<template>
  <div>
      <h1>Favor Tags</h1>
      <StationaryListing v-bind:StationaryType="this.category" />
  </div>
</template>

<script>
//needs additional '../' due to menu folder
import StationaryListing from '../../components/StationaryListing.vue';
export default {
data(){
  return{
    category: 'favor', //category naming convention from the DB
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