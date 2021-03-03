<template>
  <div>
<h2>cart items</h2>  
<div v-for="item in retrieveStationaryFromCart" v-bind:key="item.id">
<StationaryCard v-bind:isCart="true" v-bind:id="item.id"/>
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
    retrieveStationaryFromCart(){
        let stationaries= [];
        let cartArray = this.$store.getters.getCart;
        cartArray.forEach((item) => {
            stationaries.push(item.product)
        });
        return stationaries;
    }
}
}
</script>

<style>

</style>
