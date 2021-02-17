<template>
  <div id="app">
      <div id="nav">
        <router-link class="navlink" v-bind:to= "{ name: 'home'}"> Home </router-link> &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to= "{ name: 'wedding-invites'}"> Wedding Invites </router-link> &nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to= "{ name: 'save-the-dates'}"> Save the Dates</router-link> &nbsp;|&nbsp;
        </div>
        <router-view />
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>