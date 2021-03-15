<template>
  <div id="container">
      <!-- 
        Lists StationaryCards based on category prop passed to it from views
        NOT USED FOR CART, as it sets that parameter to false (use CartListing for that)
      -->
  <div v-for="item in stationaries" v-bind:key="item.id" >
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
        <StationaryDetails v-bind:modalContent="modalContent"/> 
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
    props: ["StationaryType"],
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
        },
        addBtnMethod(){
          if (this.isInCart == "Added to Cart"){
            return "addedBtn"
          } else {
            return "addBtn"
          }
        },
      addToCart(){
        if(this.isInCart == "Add to Cart"){
          this.$store.dispatch('addStationaryToCart', this.modalContent);
        }
      }
      },
    components: {
      StationaryCard,
      StationaryDetails
    },
      created() {
    StationaryService.getAllStationaryByCategory(this.pageCategory).then((response) => {
      this.stationaries = response.data;
    });
  },
}
</script>

<style scoped>

/* Modal Styling */
.modalOverlay{
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 98;
  background-color: rgba(255,255,255,0.8);
}
.modal{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;

  width: 50%;
  max-width: 400px;
  height: 60%;
  padding: 15px;

  background-color: white;
  border: 3px solid #FFD700;
  border-radius: 10px;

}
.modal img{
  max-height: 70%;
  max-width: 70%;
}

#modalCartBtn{
  padding-left: 30px;
  padding-right: 30px;
}

#container{
  height: 100%;
  width: 100%;
}
</style>