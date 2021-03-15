<template>
  <div>
      <h1>YOUR CART</h1>
      <div id="cartContainer">
        <div id="listingContainer" >
      <CartListing />
        </div>
        <div id="paymentContainer">
              <h3>Total Price: ${{cartTotalPrice}}</h3>
    <!-- add payment, etc-->
    <Payment />
  
        </div>

      </div>
  </div>
</template>

<script>
import Payment from '../components/Payment.vue'
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
  CartListing,
  Payment
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