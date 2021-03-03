<template>
  <div id="cardContainer"> <!-- add on click to create pop out -->
    <img v-bind:src="this.stationary.imgURL" alt="error"/>
    <h2>{{this.stationary.title}}</h2>
   <span v-if="this.isCart" id="RemoveBtn" @click="removeFromCart()">Remove from Cart</span>
    <span v-else id="AddBtn" @click="addToCart()">Add to Cart</span>
  </div>
</template>

<script>
import StationaryService from "../services/StationaryService.js";

export default {
  data() {
    return {
      stationary: [],
    };
  },
  computed: {},
  methods: {
      addToCart(){
        this.$store.dispatch('addStationaryToCart', this.stationary);
        console.log(this.$store.getters.getCartSize);
      },
      removeFromCart(){
          this.$store.dispatch('removeStationaryFromCart', this.stationary);
      }
  },
  props: ["id", "isCart"],

  created() {
    StationaryService.getStationaryById(this.id).then((response) => {
      this.stationary = response.data;
    });
  },
};
</script>

<style scoped>

#cardContainer{
    display:flex;
    flex-direction: column;
    height: 200px;
    width: 200px;
    border-radius: 10px;
    padding: 5px;
}

#cardContainer:hover{
     /* border: 1px solid #FFD700; */
     background-color:snow;
}

#cardContainer img{
    height: 120px;
    margin: 5px;
}
#cardContainer h2{
    margin: 5px;
    font-size: 15px;
}

#cardContainer span{
   width: 100%;
   border-radius: 5px;
}

#AddBtn{
background-color: rgba(255, 215, 0, 0.2);
}

#AddBtn:hover{
    background-color: rgba(255, 215, 0, 0.6);
}
#RemoveBtn{
background-color: rgba(255, 0, 0, 0.2);
}

#RemoveBtn:hover{
background-color: rgba(255, 0, 0, 0.6);
}
</style>