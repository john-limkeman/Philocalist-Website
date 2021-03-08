<template>
  <div>
      <div id="listAllStationariesContainer">
          <div v-for="item in stationaries" v-bind:key="item.id">
              <span>{{item.id}} &nbsp;|&nbsp; {{item.title}}</span>
              <button>Edit</button>
              <button>Delete</button>
          </div>
          <button>Add New Stationary</button>
      </div>
      <div id="formField">
          <StationaryForm v-bind:selected="chosen"/>
      </div>
  </div>
</template>

<script>
import StationaryService from '../services/StationaryService'
import StationaryForm from '../components/StationaryForm.vue'
export default {
data(){
    return{
        stationaries : [],
        formVisible: false,
    }
},
computed: {
    chosen(){
        return this.$store.state.adminChoice;
    }
},
components: {
    StationaryForm,
},
created(){
    StationaryService.getAllStationary().then(response => {
    this.stationaries = response.data;
    })
}
}
</script>

<style>

</style>