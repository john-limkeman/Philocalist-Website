<template>
  <div>
   
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