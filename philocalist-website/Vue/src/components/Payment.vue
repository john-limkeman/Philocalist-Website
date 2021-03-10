<template>
  <div>
       <h3>Total Price: ${{cartTotalPrice}}</h3>
  </div>
</template>

<script>
export default {
data(){
    return{

    }
},
computed: {
      cartTotalPrice(){
    return this.$store.getters.cartTotal;
  }
}
}
</script>

<style>

</style>