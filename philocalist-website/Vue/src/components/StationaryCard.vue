<template>

<!-- Visual display of each product when listed on pages. Will add pop out for details of each product-->
  <div id="cardContainer"> <!-- add on click to create pop out -->
    <img v-bind:src="this.stationary.imgURL" alt="error" v-on:click="seeDetails()"/>
    <h2>{{this.stationary.title}}</h2>
   <span v-if="this.isCart" class="removeBtn" @click="removeFromCart()">Remove from Cart</span>
    <span v-else v-bind:class="addBtnMethod()" @click="addToCart()">{{isInCart}}</span>
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
  computed: {

    //Determines if button should reflect that item in is cart
    isInCart(){
        let foundItem = this.$store.state.cart.find(item => {
          return item.id == this.stationary.id
          })
          if(foundItem){
            return "Added to Cart"
          }
          return "Add to Cart";
    }
  },
  methods: {
      addToCart(){
        this.$store.dispatch('addStationaryToCart', this.stationary);
      },
      removeFromCart(){
          this.$store.dispatch('removeStationaryFromCart', this.stationary);
      },
      seeDetails(){
          this.$emit("details");
      },
      //changes button class is item is in cart
      addBtnMethod(){
        if (this.isInCart == "Added to Cart"){
            return "addedBtn"
          } else {
            return "addBtn"
          }
      },
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
    height: 300px;
    width: 300px;
    border-radius: 10px;
    padding: 5px;
    
}

#cardContainer:hover{
     /* border: 1px solid #FFD700; */
     background-color:snow;
}

#cardContainer img{
    height: 260px;
    width: auto;
    margin: 5px;
    cursor: pointer;
}
#cardContainer h2{
    margin: 5px;
    font-size: 15px;
}

</style>