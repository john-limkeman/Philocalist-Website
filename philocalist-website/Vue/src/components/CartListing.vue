<template>
  <div>
<h2>cart items</h2>  
<div v-for="(item, index) in retrieveStationaryFromCart" v-bind:key="index">
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
        stationaries = this.$store.getters.getCart;
        return stationaries;
    }
}
}
</script>

<style>

</style>
