<template>
  <div id="app">
    <div id="content">
    <div id="nav">

    <div id="primaryNav">
      <span v-on:click="toggleAllOff">
      <router-link class="navlink" to="/"> Home </router-link>
      </span>
      &nbsp;|&nbsp;
      <span @mouseenter="toggleShopSuite" class="navlink menu">Shop By Suite </span>
      &nbsp;|&nbsp;
      <span @mouseenter="toggleShopEvent"  class="navlink menu" >Shop By Event</span> 
      &nbsp;|&nbsp;
      <span v-on:click="toggleAllOff">
      <router-link class="navlink" to="/about" v-on:click="toggleAllOff">About</router-link>
      &nbsp;|&nbsp;
      <router-link class="navlink" to="/contact">Contact</router-link>
      </span>

      <span id='rightNav' v-on:click="toggleAllOff">
            <span v-if="isLoggedIn()">
              <router-link class="navlink" to="/logout"> Logout </router-link>
            </span>
             <!-- <span v-else> // TO BE USED WHEN CUSTOMER LOGIN IS DEPLOYED
              <router-link class="navlink" to="/login"> Login </router-link>
            </span> -->
            &nbsp;|&nbsp;
            <span v-if='isAdmin()'>
                <router-link class="navlink" to="/admin"> Admin </router-link>
            </span>
            <span v-else>
                <router-link class="navlink" to="/cart"> {{cartCount}} Cart </router-link>
            </span>

      </span>
    </div>

    <div id="secondaryNav">    

      <div id="shopSuiteNav" v-if="this.suiteNav" >
           &nbsp;|&nbsp;
          <router-link class="navlink" v-for="theme in themes" v-bind:key="theme.id" v-bind:to="{ name: 'Themes', params: {id: theme.id}}">{{theme.name}}  &nbsp;|&nbsp; </router-link>
      </div>

      <div id="shopEventNav" v-if="this.eventNav" >
        <router-link class="navlink" v-bind:to="{ name: 'Save The Dates' }"> Save the Dates </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Wedding Invites' }"> Invitation Bundles </router-link>
        &nbsp;|&nbsp;
        <span @mouseenter="toggleParties" class="navlink menu">Parties</span>
        &nbsp;|&nbsp;
        <span @mouseenter="toggleDayOf" class="navlink menu">Day-of Essentials</span>
        &nbsp;|&nbsp;
        <span @mouseenter="toggleAddOns" class="navlink menu">Add-Ons</span>
      </div>

      <div class="shopEventOption" id="partiesNav" v-if="this.partiesNav" >
        <router-link class="navlink" v-bind:to="{ name: 'Bachelor Invites' }"> Bachelor & Bachelorette </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Bridal Shower Invites' }"> Bridal Shower </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Engagement Invites' }"> Engagement </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Rehearsal Dinner Invites' }"> Rehearsal Dinner </router-link>
      </div>
      
      <div class="shopEventOption" id="dayOfNav" v-if="this.dayOfNav" >
        <router-link class="navlink" v-bind:to="{ name: 'Favor Tags' }"> Favor Tags </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Menus' }"> Menus </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Placecards' }"> Place Cards </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Programs' }"> Programs </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Table Numbers' }"> Table Numbers </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Welcome Signs' }"> Welcome Signs </router-link>
      </div>

      <div class="shopEventOption" id="addOnNav" v-if="this.addOnNav" >
          <router-link class="navlink" v-bind:to="{ name: 'Thank You Cards' }"> Thank You Cards </router-link>
          &nbsp;|&nbsp;
          <router-link class="navlink" v-bind:to="{ name: 'Address Labels' }"> Address Labels </router-link>
          &nbsp;|&nbsp;
          <router-link class="navlink" v-bind:to="{ name: 'Envelopes' }"> Envelopes </router-link>
      </div>


    </div>


    </div>
    <router-view class="routerView"/>
    </div>

    <footer id="hiddenNav">
          <span class="navlink" v-on:click="pushIfAdmin()">Site Maintenance</span>
          &nbsp;|&nbsp;
          <span>Website by John Limkeman</span>
    </footer>
  </div>
</template>

<script>
import ThemeService from './services/ThemeService.js'
export default {
  data() {
    return {
      suiteNav: false,
      eventNav: false,
      partiesNav: false,
      dayOfNav: false,
      addOnNav: false,

      featuredTheme: {},
      themes: [],
    };
  },
  methods: {
    toggleAllOff(){
      this.suiteNav = false;
      this.eventNav = false;
      this.partiesNav = false;
      this.dayOfNav = false;
      this.addOnNav = false;
    },
    toggleShopSuite(){
      this.eventNav = false;
      this.partiesNav = false;
      this.dayOfNav = false;
      this.addOnNav = false;
      this.suiteNav = !this.suiteNav
    },
    toggleShopEvent(){
      this.suiteNav = false;
      this.eventNav = !this.eventNav;

      if(this.eventNav == false){
        this.partiesNav = false;
        this.dayOfNav = false;
        this.addOnNav = false;
      }
    },
    toggleParties(){
      this.dayOfNav = false;
      this.addOnNav = false;
      this.partiesNav = !this.partiesNav;
    },
    toggleDayOf(){
      this.partiesNav = false;
      this.addOnNav = false;
      this.dayOfNav = !this.dayOfNav;
    },
    toggleAddOns(){
      this.partiesNav = false;
      this.dayOfNav = false;
      this.addOnNav = !this.addOnNav;
    },
    pushIfAdmin(){
      if(this.$store.state.logIn){
       if (this.$store.state.user.authorities[0].name == "ROLE_ADMIN"){
         this.$router.push({name: "Admin"});
       }
      } else {
        window.alert("You must be signed in as an administrator to access this page");
        this.$router.push({name: "login"});
      }
    },
      isAdmin() {
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          return true;
        }
      } else {
        return false;
      }
    },
    isLoggedIn(){
      if (this.$store.state.logIn){
        return true;
      }
      else {
        return false;
      }
    }
    
  },
  computed: {
    cartCount(){
      return this.$store.getters.getCartSize;
    },
  },
  created(){
    ThemeService.getAllThemes().then(response => {
      this.themes = response.data;
      console.log(this.themes)

   
    this.featuredTheme = this.themes.filter(item => {
      return item.is_featured === true
    })
    console.log("FEATURED THEME: ")
    console.log(this.featuredTheme)
    });
  }
};
</script>


<style>
*{
    margin: 0;
  padding: 0;
}

#app {
  font-family: 'Courier New', Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.routerView{
margin: 0px;
}
/*  NAVIGATION BAR  */

#nav{
  width: 100%;
  background-color: rgba(0, 0, 50, 0.2);;
  justify-content: center;
  align-items: center;
  margin: 0px;
}

#rightNav{
  position: absolute;
  right: 25px;
}
#primaryNav {
  padding: 10px;
  font-size: 20px;
}
#secondaryNav{
  padding: 10px;
  font-size:18px;
  background-color: rgba(0, 0, 0, 1);
  color: white;
}

#primaryNav a, #primaryNav span, #primaryNav a:visited {
  font-weight: bold;
  color: #2c3e50;
  cursor: pointer;
}
#secondaryNav a, #secondaryNav span, #secondaryNav a:visited{
  font-weight: bold;
  color: white;
  cursor: pointer;
}
#primaryNav a.router-link-exact-active{
  color: #FFD700;
}

#secondaryNav a.router-link-exact-active{
  color: #FFD700;
}


#primaryNav span, #secondaryNav span, .navlink{
  text-decoration: none;
}

#primaryNav span:hover{
  border-bottom: 2px, solid, black; /*not working */
}

.shopEventOption{
  margin: 10px
}

.menu:hover{
  color: #FFD700;
}
/* BUTTONS */

/* Exit Button */
.exitBtn{
  float: right;
  font-size: 22px;
  border: none;
  background: none;

  }
.exitBtn:hover{
    color: red;
    cursor: pointer;
  }

/* Add to Cart, Added to Cart, and Remove From Cart Buttons */
.addBtn{
background-color: rgba(255, 215, 0, 0.2);
   width: 80%;
   border-radius: 5px;
   border: none;
}

.addBtn:hover{
    background-color: rgba(255, 215, 0, 0.6);
    cursor:pointer;
}

.addedBtn{
    background-color: wheat;
    color: grey;
    width: 80%;
   border-radius: 5px;
   border: none;
}

.removeBtn{
background-color: rgba(255, 0, 0, 0.2);
   width: 80%;
   border-radius: 5px;
     border: none;
}

.removeBtn:hover{
background-color: rgba(255, 0, 0, 0.6);
cursor: pointer;
}


/* STICKY FOOTER */
#app{
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

#content{
  flex: 1;
}

footer{
  flex-shrink: 0;
  background-color: lightgray;
  color: white;
  margin-bottom: 0px;
  padding-bottom: 0px;;
  text-align: left;
}

footer a, footer a:visited{
  color: white;
  text-decoration: none;
}


</style>