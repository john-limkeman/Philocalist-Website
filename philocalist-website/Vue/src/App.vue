<template>
  <div id="app">
    <div id="nav">
      <button>Home</button>
      <button>About</button>
      <button v-on:click=toggleWedding()>Wedding Invitations</button>
      <div v-if=weddingStatus()>
      <router-link class="navlink" v-bind:to= "{ name: 'WeddingInvites'}"> Wedding Invites </router-link> &nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to= "{ name: 'SaveTheDates'}"> Save the Dates</router-link> &nbsp;|&nbsp;
      </div>
      <button>Party Invitations</button>
      <button>Day Of Materials</button>
      <button>Thank You Cards</button>
      <router-link class="navlink" to="/"> Home </router-link> &nbsp;|&nbsp;
      <router-link class="navlink" to="/about">About</router-link> &nbsp;|&nbsp;

    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
    data() {
        return{
          openWeddingMenu: false,
          
    }
  },
  Methods: {
    toggleWedding(){
      if(this.openWeddingMenu == false){
        this.openWeddingMenu = true;
      } else {
        this.openWeddingMenu = false;
      }
    },
    Computed: {
      weddingStatus(){
        return this.openWeddingMenu;
      }
    }
  }
}
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


</style>
