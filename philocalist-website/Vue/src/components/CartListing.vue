<template>
  <div>
<h2>cart items</h2>  
<div v-for="item in Cart" v-bind:key="item.id">
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
    Cart(){
    
        return this.$store.state.cart;
    }
}
}
</script>

<style>

</style>
