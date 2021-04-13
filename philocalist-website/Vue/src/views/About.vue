<template>
  <div class="about">
    <h1>About Beth Schuurman</h1>
    <div id="aboutContainer">

    <img src="../assets/Beth-Ethan-Wedding.jpg" alt="Beth's Photo"> <!-- CHANGE WHEN PHOTO UPLOADED -->
    <p class="adminForm" v-if="!this.$store.state.logIn">{{webInfo.aboutMessage}}</p>
    <div v-else class="adminForm">
      EDIT ABOUT PAGE
      <div class="formItem">
      <label for="aboutMessage">About Message: </label>
    <textarea id="aboutMessage" cols="40" rows="5"  name="aboutMessage" v-model="webInfo.aboutMessage"> </textarea>
      </div>
      <div class="formItem">
    <label for="aboutImageURL">Image URL: </label>
    <input id="aboutImageURL" type="text" name="aboutImageURL" v-model="webInfo.aboutImageURL">
      </div>
    <button v-on:click="saveChanges()">Save</button>
    </div>
    </div>
  </div>
</template>

<script>
import WebsiteInformationService from '../services/WebsiteInformationService.js'
export default {
  data(){
    return{
      //placeholder for DB generated website information
      webInfo: {}
    }
  },
  methods: {
    saveChanges(){
        //commit to database
        console.log(this.webInfo);
        WebsiteInformationService.updateInformation(this.webInfo).then( 
        this.$router.push("/admin")
        )
    }
  },
  created(){
    //grab message from DB
    WebsiteInformationService.getInformation().then(response => {
      this.webInfo = response.data;
      console.log(this.webInfo)
    })
  }
}
</script>

<style scoped>

#aboutContainer{
 display: grid;
 grid-template-columns: 1fr 1fr;
 grid-template-areas: 
 "photo info";
}
img{
  grid-area: photo;
  margin: 30px;
  height: 70vh;
  width: auto;
  justify-self: center;
}
p{
  grid-area: info;
}
.adminForm{
  margin-top: 30px;
  display: flex;
  flex-direction: column;
  width: 500px;
  }
.formItem{
  margin: 15px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  width: 500px;
}

#aboutMessage, #aboutImageURL{
  width: 100%;
}
</style>