<template>
  <div class="home">
    <h1 class="homeTitle">Philocalist Stationary</h1>
    <div class="welcomeContainer">
        <h3>Welcome to Philocalist Stationary! Thanks for stopping by!</h3>
    </div>
    <div class="featuredThemeContainer">
        <h3 class="featuredTitle">Featured Theme: {{featuredTheme.name}}</h3>
        <img class="featuredImage" v-bind:src="featuredTheme.hero_image" alt="" v-on:click="routeToTheme()">
        <p class="featuredDescription">{{featuredTheme.description}}</p>
        <!-- <div v-for="image in themeImages" v-bind:key="image">
          <img v-bind:src="image" alt="">
        </div> -->
    </div>
  </div>
</template>

<script>
import StationaryService from '../services/StationaryService.js';
import ThemeService from "../services/ThemeService.js";
export default {
data() {
    return{
      featuredTheme: {},
      themeStationaries: [],
    }
  },
  computed: {
    themeImages(){
      let images = [];
      images.push(this.featuredTheme.hero_image)
      this.themeStationaries.forEach(item =>{
        images.push(item.imgURL);
      });
      return images;
    }
  },
  methods: {
    routeToTheme(){
      this.$router.push({name: 'Themes', params: {id: this.featuredTheme.id}})
    }
  },
    created() {
   ThemeService.getFeaturedTheme().then(response => {
     this.featuredTheme = response.data;

     StationaryService.getStationaryByTheme(this.featuredTheme.id).then(response => {
       this.themeStationaries = response.data;
     })
   })
  },
}
</script>

<style scoped>

.home{
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas:
  "title title"
  "welcome featured";
  grid-gap: 20px;
}

.welcomeContainer{
  grid-area: welcome;
  border:black 3px solid;
  height: 200px;
  background-color: black;
  color:white;

  display: flex;
  justify-content: center;
  align-items: center;
}

.featuredThemeContainer{
  grid-area: featured;
  border:black 3px solid;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "title title"
  "image description";
  background-color: rgba(0, 0, 50, 0.2);
}
.homeTitle{
  grid-area: title;
}

.featuredTitle{
  grid-area:title;
}
.featuredImage{
  grid-area:image;
  height: 400px;
  margin: 10px;
}
.featuredImage:hover{
  cursor: pointer;
}

.featuredDescription{
  grid-area: description;
}
</style>
