<template>
  <div>
      <h1>YOUR CART</h1>
      <div id="cartContainer">
        <div id="listingContainer" >
      <CartListing v-on:refresh="refresh()" v-bind:key="renderKey"/>
        </div>
        <div id="paymentContainer">
    <!-- add payment, etc-->
    <Payment v-bind:key="renderKey"/>
  
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
      renderKey: 0,
  }
},
methods: {
  refresh(){
        this.renderKey ++;
    }
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