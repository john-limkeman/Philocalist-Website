<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div id="aboutContainer">

    <img src="../assets/Beth-Ethan-Wedding.jpg" alt="Beth's Photo">
    <p v-if="!this.$store.state.logIn">{{message}}</p>
    <div v-else>
    <textarea cols="40" rows="5" class="adminForm" v-model="message"> </textarea>
    <button v-on:click="saveChanges()">Save</button>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      //change to a db sourced string
      message: "Beth Schuurman is a wedding stationary designer. There are lots of facts about her that exist. Some will be listed here."
    }
  },
  methods: {
    saveChanges(){
        //commit to database
    }
  },
  created(){
    //grab message from DB
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
  margin: 20px;
  height: 70vh;
  width: auto;
  justify-self: center;
}
p{
  grid-area: info;
}
.adminForm{
  height: 300px;
}
</style>