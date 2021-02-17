<template>
  <div id="app">
    <div id="nav">
   
      <router-link tag="button" class="navlink" to="/"> Home </router-link> &nbsp;|&nbsp;
      <router-link tag="button" class="navlink" to="/about">About</router-link> &nbsp;|&nbsp;

      <button v-on:click="toggleWedding" >Wedding Invitations </button>
      <div id="weddingMenu" v-if="this.isWeddingMenuOpen">
        <router-link tag="button" class="navlink" v-bind:to="{ name: 'WeddingInvites' }">
          Wedding Invites
        </router-link>
        &nbsp;|&nbsp;
        <router-link tag="button" class="navlink" v-bind:to="{ name: 'SaveTheDates' }">
          Save the Dates</router-link>
        &nbsp;|&nbsp;
        <button v-on:click="toggleAddOns" >Add Ons</button>
        <div id="addOnMenu" v-if="this.isAddOnMenuOpen">
          <router-link tag="button" class="navlink" v-bind:to="{ name: 'AddressLabels' }"> Address Labels </router-link>    &nbsp;|&nbsp;
          <router-link tag="button" class="navlink" v-bind:to="{ name: 'DirectionsCards' }"> Directions Cards </router-link>    &nbsp;|&nbsp;
          <router-link tag="button" class="navlink" v-bind:to="{ name: 'Envelopes' }"> Envelopes </router-link>    &nbsp;|&nbsp;
          <router-link  tag="button" class="navlink" v-bind:to="{ name: 'EventsCards' }"> Events Cards </router-link>  
        </div>
      </div>

      <button v-on:click="toggleParty">Party Invitations</button>
        <div id="partyMenu" v-if="this.isPartyMenuOpen">
          <router-link  tag="button" class="navlink" v-bind:to="{ name: 'BachelorInvites' }"> Bachelor & Bachelorette </router-link>  &nbsp;|&nbsp;
          <router-link  tag="button" class="navlink" v-bind:to="{ name: 'BridalShowerInvites' }"> Bridal Shower </router-link>  &nbsp;|&nbsp;
          <router-link  tag="button" class="navlink" v-bind:to="{ name: 'EngagementInvites' }"> Engagement </router-link>  &nbsp;|&nbsp;
          <router-link  tag="button" class="navlink" v-bind:to="{ name: 'RehearsalDinnerInvites' }"> Rehearsal Dinner </router-link>  
        </div>
      <button>Day Of Materials</button>
      <button>Thank You Cards</button>
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
    };
  },
  methods: {
    toggleWedding() {
      if (this.isWeddingMenuOpen == false) {
        this.isWeddingMenuOpen = true;
        this.isPartyMenuOpen = false;
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
      } else {
        this.isPartyMenuOpen = false;
      }
    },
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

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#weddingMenu {
  position: absolute;
  top: 100px;
}
</style>
