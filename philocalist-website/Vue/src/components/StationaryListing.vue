<template>
  <div>
      <!-- 
        Lists StationaryCards based on category prop passed to it from views
        NOT USED FOR CART, as it sets that parameter to false (use CartListing for that)
      -->
  <div v-for="invite in stationaries" v-bind:key="invite.id" >
      <StationaryCard  v-bind:id="invite.id" v-bind:isCart="false"/>
    </div>
  </div>
</template>

<script>
import StationaryService from '../services/StationaryService.js';
import StationaryCard from '../components/StationaryCard.vue'; //why this error?
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
    components: {
      StationaryCard
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