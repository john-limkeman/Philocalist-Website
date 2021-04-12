<!-- MODAL activated for each stationary selected -->

<template>
<div class="container">
  <div class="modal">

    <button class="exitBtn" v-on:click="closeModal()">X</button>

    <h2 class="modalTitle">{{ modalContent.title }}</h2>

      <div class=photoContainer>

      <div class="photoSlide" v-for="index in [sliderIndex]" v-bind:key="index">
        <img v-bind:src="currentPhoto.url" alt="error" />
        <p class="caption">{{ currentPhoto.title }}</p>
      </div>

      <div class="sliderNav">
        <span class="sliderBtn" v-on:click="decreaseIndex()">&#10094;</span>
        <div v-for="photo in photos" v-bind:key="photo.id">
          <img class="navImg" v-bind:src="photo.url" alt="error" v-on:click="changeIndex(photos.indexOf(photo))"/>
        </div>
        <span class="sliderBtn" v-on:click="increaseIndex()">&#10095;</span>
      </div>

      </div>

    <!-- <img v-bind:src="modalContent.imgURL" alt="error displaying image" class="modalImage"> -->
   <div class="detailsText">
    <h4>{{modalContent.description}}</h4>
    <p>
      <b>Price: </b>${{ modalContent.price }} <br />
      <b>Theme: </b>{{ modalContent.theme }} <br />
      <b>Print Type: </b>{{ modalContent.printType }} <br />
      <b>Dimensions: </b>{{ modalContent.width }} x {{ modalContent.height }} (inches)<br />
    </p>
   </div>
  <div class="modalCart">
      <div v-if="isBundle">
      <h4>Add-ons available for this bundle</h4>
      <label for="directionsCard">Directions Card ($0.35 / invitation) </label>
      <input type="checkbox" v-model="directionsChosen" name="directionsCard"> <br />
      <label for="eventsCard">Weekend Events Card ($0.35 / invitation) </label>
      <input type="checkbox" v-model="eventsChosen" name="eventsCard"> <br />

      <label for="rsvpPrint">Print RSVPs ($0.35 / invitation) </label>
      <input type="radio" value="print" v-model="rsvp" name="rsvpPrint"> <br /> 
      <label for="rsvpOnline">Online RSVPs ($0.00 / invitation) </label>
      <input type="radio" value="online" v-model="rsvp" name="rsvpOnline">


      </div>

      <div
        id="modalCartBtn"
        v-bind:class="addBtnMethod()"
        v-on:click="addToCart(modalContent)"
        >{{ isInCart }}</div>
        </div>
  </div>
  </div>


</template>

<script>
import PhotoService from "../services/PhotoService.js";
import StationaryService from '../services/StationaryService.js';
export default {
  data() {
    return {
      photos: [],
      sliderIndex: 0,
      directionsChosen: false,
      eventsChosen: false,
      rsvp: "online",
      stationaries: [],
    };
  },
  props: ["modalContent"],
  computed: {
    isInCart() {
      let foundItem = this.$store.state.cart.find((item) => {
        return item.id == this.modalContent.id;
      });
      if (foundItem) {
        return "Added to Cart";
      }
      return "Add to Cart";
    },
    currentPhoto() {
      return this.photos[this.sliderIndex];
    },
      isBundle(){
        if (this.modalContent.category == "weddingInvite"){
          return true;
        } else {
          return false;
        }
      },
  },
  methods: {
    addToCart(item) {
      if (this.isInCart == "Add to Cart") { //check to see if item already in cart
        if(this.isBundle == true){ //check if item is a wedding bundle
          if (this.directionsChosen == true){ //Add DIRECTIONS CARRD to cart
              this.$store.dispatch("addStationaryToCart", this.stationaries[0]);
          }
          if (this.eventsChosen == true){ //Add EVENTS CARD to cart
              this.$store.dispatch("addStationaryToCart", this.stationaries[1]);
          }
            if (this.rsvp == "print"){ // add PRINT RSVP to cart
                this.$store.dispatch("addStationaryToCart", this.stationaries[2]);
            }
          if (this.rsvp == "online"){ // add ONLINE RSVP to cart
             this.$store.dispatch("addStationaryToCart", this.stationaries[3]);
          }
        }
        this.$store.dispatch("addStationaryToCart", item);
      }
    },
    increaseIndex() {
      let images = document.getElementsByClassName('navImg');
      images[this.sliderIndex].className = "navImg";
      if (this.sliderIndex == this.photos.length - 1) {
        this.sliderIndex = 0;
      } else {
        this.sliderIndex++;
      }

      images[this.sliderIndex].className += " active";
    },
    decreaseIndex() {
      let images = document.getElementsByClassName('navImg');
      images[this.sliderIndex].className = "navImg";
      if (this.sliderIndex == 0) {
        this.sliderIndex = this.photos.length - 1;
      } else {
        this.sliderIndex--;
      }
      images[this.sliderIndex].className += " active";
    },
    changeIndex(num){
      let images = document.getElementsByClassName('navImg');
      images[this.sliderIndex].className = "navImg";

      this.sliderIndex = num;
      images[this.sliderIndex].className += " active";
    },

    addBtnMethod() {
      if (this.isInCart == "Added to Cart") {
        return "addedBtn";
      } else {
        return "addBtn";
      }
    },


    closeModal() {
      this.$emit("close");
    },
  },
  created() {
    //adds hero image from stationary object to photos array, id: 0 to ensure no conflicts
    this.photos.push({
      id: 0,
      url: this.modalContent.imgURL,
      stationary_id: this.modalContent.id,
      title: "Front",
    });

    //adds photos from Photos table that match stationary id to this.photos
    PhotoService.getPhotosByStationaryId(this.modalContent.id).then(
      (response) => {
        response.data.forEach((element) => {
          this.photos.push({
            id: element.id,
            url: element.url,
            stationary_id: element.stationary_id,
            title: element.title,
          });
        });
    let images = document.getElementsByClassName('navImg'); //doesnt work
    images[0].className += " active";

    //adds stationary objects for related add ons if item is a bundle
    if (this.modalContent.category == "weddingInvite"){
      StationaryService.getStationaryByThemeAndCategory(this.modalContent.theme_id, "directionCard").then(response => {
        this.stationaries.push(response.data);
        StationaryService.getStationaryByThemeAndCategory(this.modalContent.theme_id, "eventsCard").then(response => {
        this.stationaries.push(response.data);
        StationaryService.getStationaryByThemeAndCategory(this.modalContent.theme_id, "rsvpPrint").then(response => {
        this.stationaries.push(response.data);
        StationaryService.getStationaryByThemeAndCategory(this.modalContent.theme_id, "rsvpOnline").then(response => {
        this.stationaries.push(response.data);
        console.log(this.stationaries)
    })
        })
    })
      })
      }
      });



  },
};
</script>

<style scoped>
.container{
  height: 100%;
  width: 100%;
}
.modal{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;

  width: 70%;
  height: 70%;
  padding: 25px;

  background-color: white;
  border: 2px solid black;


  display: grid;
  grid-template-columns: 1.4fr 1fr;
  grid-template-areas:
  "photo title"
  "photo text"
  "photo cart"
  "photo cart";
}

.modalTitle{
  grid-area: title;
  font-size: 35px;
  margin-bottom:0px;
}

.exitBtn{
  position: absolute;
  right: 1%;
  top: 1%

  
}
/* Current Image */
.photoContainer{
  grid-area: photo;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.photoContainer img{
  width: 70%
}
/* Slider Nav */

.sliderNav {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  width: 70%;
}
.sliderNav img{
  width: 50px;
  height: auto;
  margin-left: 5px;
  margin-right: 5px;
  cursor: pointer;
}
.active {
  border: #FFD700 2px solid;
}
.sliderNav span{
  width: 35%;
}

.sliderBtn{
  font-size: 25px;
}
.sliderBtn:hover{
  color: gray;
  cursor: pointer;
}
/* Details Text */ 
.detailsText{
  grid-area: text;
  font-size: 20px;
  text-align: left;
  align-self: start;
  margin: 0px;
}
#modalCartBtn {
  grid-area: cart;
  font-size: 20px;
  height: 30px;
  align-self: end;
  margin: 15px;
  text-align: center;
  align-self: center;
}

.modalCart{
  text-align: left;
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-end;
}


</style>