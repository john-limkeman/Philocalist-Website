<template>
  <div>
      <div id="listAllStationariesContainer" v-if="!formVisible">
          <div v-for="item in stationaries" v-bind:key="item.id">
              <span>{{item.id}} &nbsp;|&nbsp; {{item.title}}</span>
              <button v-on:click="toggleMenu(item)">Edit</button>
              <button>Delete</button>
          </div>
          <button v-on:click="toggleEmptyMenu()">Add New Stationary</button>
      </div>
      <div id="formField" v-if="formVisible">
          <button v-on:click="toggleMenu()">X</button>
          <StationaryForm v-bind:selected="chosen" v-on:submitted="toggleEmptyMenu()"/>
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
methods: {
    toggleMenu(stationary){
        //change store adminChoice
        this.$store.dispatch('setAdminChoice', stationary);
        //make form visible
        this.formVisible = !this.formVisible;
    },
    toggleEmptyMenu(){
        this.$store.dispatch('emptyAdminChoice');
        this.formVisible = !this.formVisible;
    }
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