<template>
  <div>
<h2>cart items</h2>  
<div v-for="item in Cart" v-bind:key="item.id">
<StationaryCard v-bind:isCart="true" v-bind:id="item.id"/>
<label for="itemQuantity">Count: </label>
<input v-bind:value="changeNum.quantity" name="itemQuantity" type="number" min="0" max="1000" id="quantityInput">
<button v-on:click="updateQuantity(item.id)">Update</button>
</div>
</div>
</template>

<script>
import StationaryCard from '../components/StationaryCard.vue'
export default {
data(){
    return{
        changeNum: {
            id: 0,
            quantity: 0
        }
    }
},
components: {
    StationaryCard,
},
computed: {
    Cart(){
    
        return this.$store.state.cart;
    }
},
methods : {
    updateQuantity(id){
        let quantityPayload = {
            id: id,
            quantity: this.changeNum
        }
        this.$store.dispatch('updateQuantity', {quantityPayload})
    }
}
}
</script>

<style>

</style>
