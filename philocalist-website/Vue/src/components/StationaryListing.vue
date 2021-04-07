   <!-- 
    Lists StationaryCards based on category prop passed to it from views
    NOT USED FOR CART, as it sets that parameter to false (use CartListing.vue)
    -->
<template>
  <div id="container">
  <div v-for="item in stationaries" v-bind:key="item.id"  class="cardContainer">
      <StationaryCard  v-bind:id="item.id" v-bind:isCart="false" v-on:details="toggleModal(item)"/>
    </div>

<!-- 
Modal + Overlay shows more details for each stationary item when clicked 
-->
    <transition>
      <div class="modalOverlay" v-if="showModal" @click="toggleModal()"></div>
    </transition>
    <transition>
      <div class="modal" v-if="showModal">
        <StationaryDetails v-bind:modalContent="modalContent" v-on:close="toggleModal()"/> 
      </div>
    </transition>
  </div>
</template>

<script>
import StationaryDetails from '../components/StationaryDetails.vue'
import StationaryService from '../services/StationaryService.js';
import StationaryCard from '../components/StationaryCard.vue'; //why this error?
export default {
    data(){
        return{
            stationaries: [],
            showModal: false,
            modalContent: {},
        }
    },
    props: ["StationaryType", "StationaryTheme"],
    computed: {
        pageCategory(){
            return this.StationaryType;
        },
        isInCart(){
          let foundItem = this.$store.state.cart.find(item => {
            return item.id == this.modalContent.id
          })
          if(foundItem){
            return "Added to Cart"
          }
          return "Add to Cart";
        },
    },
      methods: {
        toggleModal(item){
          if(item){
            this.modalContent = item;
          }
          this.showModal = !this.showModal;
        }
      },
    components: {
      StationaryCard,
      StationaryDetails
    },
      created() {
        if(this.StationaryType != null){
          StationaryService.getAllStationaryByCategory(this.pageCategory).then((response) => {
            this.stationaries = response.data;
          });
        } else {
           StationaryService.getStationaryByTheme(this.StationaryTheme).then((response) => {
            this.stationaries = response.data;
          });
        }
  },
}
</script>

<style scoped>

/* Overlay Styling */
.modalOverlay{
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 98;
  background-color: rgba(255,255,255,0.8);
}


#container{
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
}
/* .cardContainer{
  margin: 30px;
  height: 300px;
  width: 300px;
  display: flex;
  justify-content:center;
  align-items: center;
} */
</style>