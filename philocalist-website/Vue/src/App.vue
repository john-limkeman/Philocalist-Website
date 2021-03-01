<template>
  <div id="app">
    <div id="primaryNav">
      <span v-on:click="toggleAllOff">
      <router-link class="navlink" to="/" v-on:click="toggleAllOff"> Home </router-link>
      &nbsp;|&nbsp;
      <router-link class="navlink" to="/about" v-on:click="toggleAllOff">About</router-link>
      &nbsp;|&nbsp;
      </span>
      <span v-on:click="toggleWedding" class="navlink" id="weddingMenuName">Weddings</span>
      &nbsp;|&nbsp;
      <span v-on:click="toggleParty" class="navlink">Parties</span> &nbsp;|&nbsp;
      <span v-on:click="toggleDayOf" class="navlink">Day Of</span> &nbsp;|&nbsp;
      <span v-on:click="toggleAllOff">
      <router-link class="navlink" to="/thank-you">
        Thank You
      </router-link>
      </span>
    </div>

    <div id="secondaryNav">
      <div  v-if="this.isWeddingMenuOpen">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'WeddingInvites' }"
        >
          Wedding Invites
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'SaveTheDates' }"
        >
          Save the Dates</router-link
        >
        &nbsp;|&nbsp;
        <span v-on:click="toggleAddOns">Add Ons</span>
        <div id="addOnMenu" v-if="this.isAddOnMenuOpen">
          <router-link
            class="navlink"
            v-bind:to="{ name: 'AddressLabels' }"
          >
            Address Labels
          </router-link>
          &nbsp;|&nbsp;
          <router-link
            class="navlink"
            v-bind:to="{ name: 'DirectionsCards' }"
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
            v-bind:to="{ name: 'EventsCards' }"
          >
            Events Cards
          </router-link>
        </div>
      </div>

      <div id="partyMenu" v-if="this.isPartyMenuOpen">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'BachelorInvites' }"
        >
          Bachelor & Bachelorette
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'BridalShowerInvites' }"
        >
          Bridal Shower
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'EngagementInvites' }"
        >
          Engagement
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'RehearsalDinnerInvites' }"
        >
          Rehearsal Dinner
        </router-link>
      </div>

      <div id="dayOfMenu" v-if="this.isDayOfMenuOpen">
        <router-link
          class="navlink"
          v-bind:to="{ name: 'FavorTags' }"
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
          v-bind:to="{ name: 'TableNumbers' }"
        >
          Table Numbers
        </router-link>
        &nbsp;|&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'WelcomeSigns' }"
        >
          Welcome Signs
        </router-link>
      </div>
    </div>
    <router-view />
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
    };
  },
  methods: {
    toggleWedding() {
      if (this.isWeddingMenuOpen == false) {
        this.isWeddingMenuOpen = true;
        this.isPartyMenuOpen = false;
        this.isDayOfMenuOpen = false;

        Document.getElementById('weddingMenuName').style.color = '#42b983';
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
  Computed: {},
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

/* Navigation Bar */

#primaryNav {
  padding: 10px;
  font-size: 20px;
}
#secondaryNav{
  padding: 10px;
  font-size:18px;
  background-color: #6AB155;
  color: white;
}

#primaryNav a, #primaryNav span, #primaryNav a:visited {
  font-weight: bold;
  color: #2c3e50;
}
#secondaryNav a, #secondaryNav span, #secondaryNav a:visited{
  font-weight: bold;
  color: white;
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


/*Second/Third Level Navigation Bar */

</style>