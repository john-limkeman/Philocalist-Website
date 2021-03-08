<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div id="aboutContainer">

    <img src="../assets/Beth-Ethan-Wedding.jpg" alt="Beth's Photo">
    <p>Beth Schuurman is a wedding stationary designer. There are lots of facts about her that exist. Some will be listed here.</p>
    </div>
  </div>
</template>

<script>
export default {
  
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
}
p{
  grid-area: info;
}

</style>