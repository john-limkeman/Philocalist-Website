<template>
  <div> 
<div v-for="item in Cart" v-bind:key="item.id" class="cartItemContainer">
    <StationaryCard v-bind:isCart="true" v-bind:id="item.id" />
    <span>Price: ${{item.price}} x </span>
    <input v-bind:value="item.quantity" class="quantityInput" name="itemQuantity" type="number" min="0" max="1000" v-bind:id='item.id'>
    <button class="updateButton" v-on:click="updateQuantity(item.id)">Update</button>
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
      cartTotalPrice(){
    return this.$store.getters.cartTotal;
  },

},
methods : {
    updateQuantity(id){
        let quantityPayload = {
            id: id,
            quantity: document.getElementById(id).value
        }
        this.$store.dispatch('updateQuantity', quantityPayload);
        this.$emit("refresh");
    },
    ItemQuantity(id){
        let returnedPayload = this.$store.getters.getQuantities.filter(item => {
            return item.id === id;
        });
        if (returnedPayload){
            return returnedPayload.quantity;
        } else {
            console.log("Could not find id in quanities")
        }
    },
},
// watch: {
//     cartTotalPrice(oldVal, newVal){
//         this.renderKey ++;
//         console.log("total price was" + oldVal + ". New total is " + newVal);
//     }
// }
}
</script>

<style>

.cartItemContainer{
    display: flex;
    flex-direction: row;
    align-items: center;

}

.updateButton{
    height: 15px;
}

.quantityInput{
    width: 50px;
    height: 15px;
}
</style>
