<template>
  <div id="app">
    <div id="content">
    <div id="nav">
    <div id="primaryNav">
      <span v-on:click="toggleAllOff">
      <router-link class="navlink" to="/"> Home </router-link>
      &nbsp;|&nbsp;
      <router-link class="navlink" to="/about">About</router-link>
      &nbsp;|&nbsp;
      <router-link class="navlink" to="/contact">Contact</router-link>
      &nbsp;|&nbsp;
      </span>
      <span @mouseenter="toggleWedding" class="navlink">Weddings &nbsp;|&nbsp;</span>

      <span @mouseenter="toggleParty"  class="navlink" >Parties &nbsp;|&nbsp;</span> 
      <span @mouseenter="toggleDayOf" class="navlink">Day-Of &nbsp;|&nbsp;</span> <!--Day Of, Wedding Day Materials, Day Of Materials, The Day-->
      <span v-on:click="toggleAllOff">
    
    <span id='rightNav'>
       <span v-on:click="toggleAllOff" v-if='isAdmin'>
         <router-link class="navlink" to="/admin" v-on:click="toggleAllOff"> Admin </router-link>
         </span>
       <span v-on:click="toggleAllOff" v-else>
         <router-link class="navlink" to="/cart" v-on:click="toggleAllOff"> {{cartCount}} Cart </router-link>
         </span>

    </span>
      </span>
    </div>

    <div id="secondaryNav">
      <div  v-if="this.isWeddingMenuOpen" @mouseleave="toggleWedding">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Wedding Invites' }"
        >
          Invitation
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Save The Dates' }"
        >
          Save the Date</router-link
        >
        &nbsp;|&nbsp;
          <router-link class="navlink" to="/thank-you">
        Thank You
      </router-link>
           &nbsp;|&nbsp;
        <span @mouseenter="toggleAddOns">Add Ons</span>

        <div id="addOnMenu" v-if="this.isAddOnMenuOpen" @mouseleave="toggleAddOns">
          <router-link
            class="navlink"
            v-bind:to="{ name: 'Address Labels' }"
          >
            Address Labels
          </router-link>
          &nbsp;|&nbsp;
          <router-link
            class="navlink"
            v-bind:to="{ name: 'Directions Cards' }"
          >
            Directions Cards
          </router-link>
          &nbsp;|&nbsp;
          <router-link
            class="navlink"
            v-bind:to="{ name: 'Envelopes' }"
          >
            Envelopes
          </router-link>
          &nbsp;|&nbsp;
          <router-link
            class="navlink"
            v-bind:to="{ name: 'Events Cards' }"
          >
            Events Cards
          </router-link>
        </div>
      </div>

      <div id="partyMenu" v-if="this.isPartyMenuOpen" @mouseleave="toggleParty">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Bachelor Invites' }"
        >
          Bachelor & Bachelorette
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Bridal Shower Invites' }"
        >
          Bridal Shower
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Engagement Invites' }"
        >
          Engagement
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Rehearsal Dinner Invites' }"
        >
          Rehearsal Dinner
        </router-link>
      </div>

      <div id="dayOfMenu" v-if="this.isDayOfMenuOpen" @mouseleave="toggleDayOf">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Favor Tags' }"
        >
          Favor Tags
        </router-link>
        &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'Menus' }">
          Menus
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Placecards' }"
        >
          Place Cards
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Programs' }"
        >
          Programs
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Table Numbers' }"
        >
          Table Numbers
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'Welcome Signs' }"
        >
          Welcome Signs
        </router-link>
      </div>
    </div>


    </div>
    <router-view />
    </div>

    <footer id="hiddenNav">
          <router-link class="navlink" to="/admin">Site Maintenance</router-link>
    </footer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isWeddingMenuOpen: false,
      isAddOnMenuOpen: false,
      isPartyMenuOpen: false,
      isDayOfMenuOpen: false,
      isAdmin: false
    };
  },
  methods: {
    toggleWedding() {
      if (this.isWeddingMenuOpen == false) {
        this.isWeddingMenuOpen = true;
        this.isPartyMenuOpen = false;
        this.isDayOfMenuOpen = false;
      } else {
        this.isWeddingMenuOpen = false;
        this.isAddOnMenuOpen = false;
      }
    },
    toggleAddOns() {
      if (this.isAddOnMenuOpen == false) {
        this.isAddOnMenuOpen = true;
      } else {
        this.isAddOnMenuOpen = false;
      }
    },
    toggleParty() {
      if (this.isPartyMenuOpen == false) {
        this.isPartyMenuOpen = true;
        this.isWeddingMenuOpen = false;
        this.isDayOfMenuOpen = false;
      } else {
        this.isPartyMenuOpen = false;
      }
    },
    toggleDayOf() {
      if (this.isDayOfMenuOpen == false) {
        this.isDayOfMenuOpen = true;
        this.isPartyMenuOpen = false;
        this.isWeddingMenuOpen = false;
      } else {
        this.isDayOfMenuOpen = false;
      }
    },
    toggleAllOff(){
      this.isWeddingMenuOpen = false;
      this.isAddOnMenuOpen = false;
      this.isPartyMenuOpen = false;
      this.isDayOfMenuOpen = false;
    }
  },
  computed: {
    cartCount(){
      return this.$store.getters.getCartSize;
    }
  },
};
</script>


<style>


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


/*  NAVIGATION BAR  */

#nav{
  /* display: flex;
  flex-direction: row; */
  width: 100%;
  background-color: rgba(255, 215, 0, 0.1);
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
  background-color: #FFD700;
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
  color: black;
}


#primaryNav span, #secondaryNav span, .navlink{
  text-decoration: none;
}

#primaryNav span:hover{
  border-bottom: 2px, solid, black; /*not working */
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
   width: 100%;
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
    width: 100%;
   border-radius: 5px;
   border: none;
}

.removeBtn{
background-color: rgba(255, 0, 0, 0.2);
   width: 100%;
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