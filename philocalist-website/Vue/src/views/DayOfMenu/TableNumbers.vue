<template>
  <div>
      <h1>Table Numbers</h1>
      <StationaryListing v-bind:StationaryType="this.category" />
  </div>
</template>

<script>
//needs additional '../' due to menu folder
import StationaryListing from '../../components/StationaryListing.vue';
export default {
data(){
  return{
    category: 'tableNumber', //category naming convention from the DB
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