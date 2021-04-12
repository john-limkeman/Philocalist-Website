<template>
  <div class="home">
    <h1 class="homeTitle">Philocalist Stationary</h1>
    <div class="welcomeContainer">
        <h3>Welcome to Philocalist Stationary! Thanks for stopping by!</h3>
    </div>
    <div class="featuredThemeContainer">
        <h3 class="featuredTitle">Featured Theme: {{featuredTheme.name}}</h3>
        <!-- <img class="featuredImage" v-bind:src="featuredTheme.hero_image" alt="" v-on:click="routeToTheme()"> -->
        <p class="featuredDescription">{{featuredTheme.description}}</p>
        <div class="featuredImages">
    <span id="arrowBtn" @click="prev" href="#">&#10094; </span>
      <span v-for="i in [currentIndex]" :key="i">
        <img :src="currentImage" class="featuredImage" v-on:click="routeToTheme()"/>
      </span>
    <span id="arrowBtn" @click="next" href="#">&#10095; </span>
  </div>
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
      timer: null,
      currentIndex: 0,
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
    },
    currentImage(){
      return this.themeImages[Math.abs(this.currentIndex) % this.themeImages.length];
    }
  },
  methods: {
    routeToTheme(){
      this.$router.push({name: 'Themes', params: {id: this.featuredTheme.id}})
    },
    startSlide(){
       this.timer = setInterval(this.next, 4000);
    },
    next(){
      this.currentIndex += 1;
    },
    prev(){
      this.currentIndex -=1;
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
  mounted(){
    this.startSlide();
  }
}
</script>

<style scoped>

.home{
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-rows: 20% 80%;
  grid-template-areas:
  "title title"
  "welcome featured";
  column-gap: 20px;;
  height: 100vh;
  background-image: url('https://smhttp-ssl-39245-greenbox.nexcesscdn.net/media/catalog/product/cache/4/image/9df78eab33525d08d6e5fb8d27136e95/b/e/beach-please_41.jpg');

  background-size: 100%;
}
.homeTitle{
  grid-area: title;
  display:flex;
  align-items: center;
  justify-self: center;
}

.welcomeContainer{
  grid-area: welcome;
  /* border:black 3px solid; */
  height: 100%;
  background-color: rgba(255,255,255,0.2);
  color:black;

  display: flex;
  justify-content: center;

  padding: 15px 10px 10px 10px;
}

.featuredThemeContainer{
  grid-area: featured;
  /* border:black 3px solid; */
  background-color: rgba(255,255,255,0.2);
  display: flex;
  flex-direction: column;
  height: 100%;

  padding: 15px 10px 10px 10px;

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
.featuredImages{
  display:flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
    margin-top:20px;

}

#arrowBtn{
  font-size: 30px;
  font-style: bold; 
  color: white;
  cursor: pointer;
  background-color: rgba(0,0,0,0.2);
  width: 35px;
  height: 34px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
}

</style>
