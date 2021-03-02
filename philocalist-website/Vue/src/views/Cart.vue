<template>
  <div>
      <h1>YOUR CART</h1>
      <div v-for='item in stationaries' v-bind:key="item.id">
        {{item.title}}
      </div>
    
  </div>
</template>

<script>
export default {
//this.$store.dispatch('action name', payload)

data() {
  return{
      stationaries: []

  }
},
methods: {
  removeFromCart(){

  },
  editQuantity(){

  }
},
computed: {

},
 created() {
   this.stationaries = this.$store.state.cart;
   
 }
}
</script>

<style scoped>

</style>