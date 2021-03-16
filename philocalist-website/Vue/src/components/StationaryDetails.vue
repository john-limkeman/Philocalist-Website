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
    <p class="detailsText">
      <b>Price: </b>${{ modalContent.price }} <br />
      <b>Theme: </b>{{ modalContent.theme }} <br />
      <b>Print Type: </b>{{ modalContent.printType }} <br />
    </p>
      <span
        id="modalCartBtn"
        v-bind:class="addBtnMethod()"
        v-on:click="addToCart()"
        >{{ isInCart }}</span>
  </div>

</div>
</template>

<script>
import PhotoService from "../services/PhotoService.js";
export default {
  data() {
    return {
      photos: [],
      sliderIndex: 0,
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
  },
  methods: {
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
    addToCart() {
      if (this.isInCart == "Add to Cart") {
        this.$store.dispatch("addStationaryToCart", this.modalContent);
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
      }
    );

    let images = document.getElementsByClassName('navImg'); //doesnt work
    images[0].className += " active";
    console.log(this.photos);
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
  border: 3px solid #FFD700;
  border-radius: 10px;

  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-areas:
  "photo title"
  "photo text"
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
  margin-bottom: 10px;
}



</style>