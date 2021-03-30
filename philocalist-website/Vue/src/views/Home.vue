<template>
  <div class="home">
    <h1 class="homeTitle">Philocalist Stationary</h1>
    <div class="welcomeContainer">
        <h3>Welcome to Philocalist Stationary! Thanks for stopping by!</h3>
    </div>
    <div class="featuredThemeContainer">
        <h3>Featured Theme: {{featuredTheme.name}}</h3>
        <img v-bind:src="featuredTheme.hero_image" alt="">
    </div>
  </div>
</template>

<script>
import ThemeService from "../services/ThemeService.js";
export default {
data() {
    return{
      featuredTheme: {},
    }
  },
    created() {
   ThemeService.getFeaturedTheme().then(response => {
     this.featuredTheme = response.data;
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

  display: flex;
  justify-content: center;
  align-items: center;
}

.featuredThemeContainer{
  grid-area: featured;
  border:black 3px solid;
}
.homeTitle{
  grid-area: title;
}
</style>
