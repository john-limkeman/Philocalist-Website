<template>
  <div>
      <h1>Admin Tools</h1>
      <div class="adminContainer">
        <div class="adminListing">
          <h3>Stationaries</h3>
      <AdminListing />
        </div>
        <!-- edit about page -->
        <div class="pageEdits">
          <h3>Edits to About Me and Homepage?</h3>
          <p>What do you want to be able to change yourself, Beth?</p>
        </div>

      </div>
      <!-- lists all with edit button and delete button  -->
  </div>
</template>

<script>
import AdminListing from '../components/AdminListing.vue'
export default {
data(){
    return{

    }
},
components: {
    AdminListing
}
}
</script>

<style scoped>
 .adminContainer{
   display: flex;
   flex-direction: row;
   justify-content: center;
 }
 .pageEdits{
   margin: 10px;
 }
 .adminListing{
   margin: 10px;
 }
</style>