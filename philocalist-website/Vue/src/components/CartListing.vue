<template>
  <div>
<h2>cart items</h2>  
<div v-for="item in Cart" v-bind:key="item.id">
    <StationaryCard v-bind:isCart="true" v-bind:id="item.id"/>
    <span>Price: {{item.price}}  </span>
    <label for="itemQuantity">Count: </label>
    <input name="itemQuantity" type="number" min="0" max="1000" v-bind:id='item.id'>
    <button v-on:click="updateQuantity(item.id)">Update</button>
    <span v-text="QuantifiedPrice(item.id)" ></span>
</div>
</div>
</template>

<script>
import StationaryCard from '../components/StationaryCard.vue'
export default {
data(){
    return{
        
    }
},
components: {
    StationaryCard,
},
computed: {
    Cart(){
        return this.$store.state.cart;
    },
    QuantifiedPrice(id){
        let item = this.$store.getters.getCartItemById(id);
        let price = item.price;

        let quantity = this.$store.getters.getQuantityById(id);
        let total = price * quantity;
        return total;
    }

},
methods : {
    updateQuantity(id){
        let quantityPayload = {
            id: id,
            quantity: document.getElementById(id).value
        }
        this.$store.dispatch('updateQuantity', quantityPayload)
    },
            ItemQuantity(id){
                return this.$store.getters.getQuantityById(id);
            },
}
}
</script>

<style>

</style>
