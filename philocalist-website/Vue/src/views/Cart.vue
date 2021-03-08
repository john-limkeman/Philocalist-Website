<template>
  <div>
      <h1>YOUR CART</h1>
      <div id="cartContainer">
        <div id="listingContainer" >
      <CartListing />
        </div>
        <div id="paymentContainer">
    <!-- add payment, etc-->
    <h3>Total Price: ${{cartTotalPrice}}</h3>
        </div>

      </div>
  </div>
</template>

<script>
import CartListing from '../components/CartListing.vue'
export default {


data() {
  return{

  }
},
methods: {

},
computed: {
  cartTotalPrice(){
    return this.$store.getters.cartTotal;
  }
},
components: {
  CartListing
},
 created() {

   
 }
}
</script>

<style scoped>
#cartContainer{
  display: grid;
  grid-template-columns: 
  1fr 1fr;
  grid-template-areas: 
  "listing payment";
}

#listingContainer{
  grid-area: listing;
}
#paymentContainer{
  grid-area: payment;
}

</style>