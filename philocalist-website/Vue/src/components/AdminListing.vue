<template>
  <div>
      <div id="listAllStationariesContainer" v-if="!formVisible && !confirmationVisible">
          <div v-for="item in stationaries" v-bind:key="item.id" class="stationaryLine">
              <span>{{item.id}} &nbsp;|&nbsp; {{item.title}}</span>
                <span>
                     <button v-on:click="toggleMenu(item)" class="addBtn" id="neutralAddBtn">Edit</button>
                     <button v-on:click="toggleDeleteConfirmation(item)" class="removeBtn" id="adminRemoveBtn">Delete</button>
                </span>
          </div>
          <button v-on:click="toggleEmptyMenu()" class="addBtn" id="NewStationaryBtn">Add New Stationary</button>
      </div>
      <div id="formContainer" v-if="formVisible">
          <button v-on:click="toggleMenu()" class="exitBtn">X</button>
          <StationaryForm v-bind:selected="chosen" v-on:submitted="toggleEmptyMenu()"/>
      </div>
      <div id="deleteConfirmationContainer" v-if="confirmationVisible">
          <h2>Are you sure you want to delete {{itemToDelete.title}}</h2>
          <button v-on:click="deleteStationary(itemToDelete.id)" class="removeBtn" id="adminRemoveBtn">Delete</button>
          <button v-on:click="toggleDeleteConfirmation" class="addBtn" id="neutralAddBtn">Cancel</button>
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
        confirmationVisible: false,
        itemToDelete: {},
        idToDelete: "",
    }
},
computed: {
    chosen(){
        return this.$store.state.adminChoice;
    },
  
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
    },
    toggleDeleteConfirmation(item){
        if (this.idToDelete == ""){
            this.idToDelete = item.id;
            this.itemToDelete = item;
            this.confirmationVisible = true;
        } else {
            this.itemToDelete = [];
            this.idToDelete = "";
            this.confirmationVisible = false;
        }
    },
      deleteStationary(id){
        StationaryService.deleteStationary(id);
        this.confirmationVisible = false;
    },
},
created(){
    StationaryService.getAllStationary().then(response => {
    this.stationaries = response.data;
    })
}
}
</script>

<style scoped>

.stationaryLine{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 5px;
    align-items: center;
    
}
#neutralAddBtn{
    font-size: 15px;
    padding: 5px;
    width: 60px;
    margin: 5px;
    background-color: whitesmoke;
}

#neutralAddBtn:hover{
    background-color: lightgray;
}
#adminRemoveBtn{
    font-size: 15px;
    padding: 5px;
    width: 60px;
    margin: 5px;
}
#NewStationaryBtn{
    font-size: 15px;
    padding: 5px;
}
</style>