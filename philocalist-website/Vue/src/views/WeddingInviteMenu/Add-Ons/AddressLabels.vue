<template>
  <div>
      <h1>Address Labels</h1>
      <StationaryListing v-bind:StationaryType="this.category" />
  </div>
</template>

<script>
//needs additional '../../' due to menu folder
import StationaryListing from '../../../components/StationaryListing.vue';
export default {
data(){
  return{
    category: 'addressLabel', //category naming convention from the DB
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