<template>
  <div id="container">
      <!-- 
        Lists StationaryCards based on category prop passed to it from views
        NOT USED FOR CART, as it sets that parameter to false (use CartListing for that)
      -->
  <div v-for="item in stationaries" v-bind:key="item.id" >
      <StationaryCard  v-bind:id="item.id" v-bind:isCart="false" v-on:details="toggleModal(item)"/>
    </div>

    <transition>
      <div class="modal-overlay" v-if="showModal" @click="toggleModal()"></div>
    </transition>
    <transition>
      <div class="modal" v-if="showModal">
        <h2 class="modalTitle">{{modalContent.title}}</h2>
        <img v-bind:src="modalContent.imgURL" alt="error displaying image" class="modalImage">
        <p>Price: ${{modalContent.price}} <br/>
          Theme: {{modalContent.theme}} <br/>
          Print Type: {{modalContent.printType}} <br/>
          <button class="modalAddBtn"></button>
          <button class="modalExitBtn" v-on:click="toggleModal()">X</button>
        </p>

      </div>
    </transition>
  </div>
</template>

<script>
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
        }
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
      StationaryCard
    },
      created() {
    StationaryService.getAllStationaryByCategory(this.pageCategory).then((response) => {
      this.stationaries = response.data;
    });
  },
}
</script>

<style>

</style>