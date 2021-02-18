<template>
  <div>
      <h1>Programs</h1>
      <StationaryListing v-bind:StationaryType="this.category" />
  </div>
</template>

<script>
//needs additional '../' due to menu folder
import StationaryListing from '../../components/StationaryListing.vue';
export default {
data(){
  return{
    category: 'program', //category naming convention from the DB
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