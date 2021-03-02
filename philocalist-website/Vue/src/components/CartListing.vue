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
import StationaryService from '../services/StationaryService.js'
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
        let ids;
        ids = this.$store.state.cart;
        console.log(this.$store.state.cart);
       ids.forEach((num) => { //data not being processed correctly? Cart grows, data hard to understand
           StationaryService.getStationaryById(num.id).then((response) => {
               stationaries.push(response.data);
           }
           )
       })

        return stationaries;
    }
}
}
</script>

<style>

</style>
Use this file to list isCart = true StationaryCards