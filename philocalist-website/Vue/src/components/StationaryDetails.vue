<template>
  <div class="modal">
    <button class="exitBtn" v-on:click="closeModal()">X</button>

    <h2 class="modalTitle">{{ modalContent.title }}</h2>

      <div class="photoSlide" v-for="index in [sliderIndex]" v-bind:key="index">
        <img v-bind:src="currentPhoto.url" alt="error" />
        <p class="caption">{{ currentPhoto.title }}</p>
      </div>
      
      <div class="sliderNav">
        <span class="sliderBtn" v-on:click="decreaseIndex()">&#10094;</span>
        <span v-for="photo in photos" v-bind:key="photo.id">
          <img class="navImg" v-bind:src="photo.url" alt="error" v-on:click="sliderIndex = photos.indexOf(photo)"/>
        </span>
        <span class="sliderBtn" v-on:click="increaseIndex()">&#10095;</span>
      </div>

    <!-- <img v-bind:src="modalContent.imgURL" alt="error displaying image" class="modalImage"> -->
    <p class="detailsText">
      Price: ${{ modalContent.price }} <br />
      Theme: {{ modalContent.theme }} <br />
      Print Type: {{ modalContent.printType }} <br />
      <span
        id="modalCartBtn"
        v-bind:class="addBtnMethod()"
        v-on:click="addToCart()"
        >{{ isInCart }}</span
      >
    </p>
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

    console.log(this.photos);
  },
};
</script>

<style scoped>
.modal{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;

  width: 70%;
  height: 70%;
  padding: 15px;

  background-color: white;
  border: 3px solid #FFD700;
  border-radius: 10px;

  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-areas:
  "photo exit"
  "photo title"
  "photo text"
  "slider text";
  grid-gap: 5px;
}

.modalTitle{
  grid-area: "title";
}

.exitBtn{
  grid-area: "exit";
}
/* Current Image */
.photoSlide{
  grid-area: "photo";
}
.photoSlide img{
  width: 60%
}
/* Slider Nav */

.sliderNav {
  grid-area: "slider";
  display: flex;
  flex-direction: row;
  align-items: center;
}
.sliderNav img{
  width: 30%;
  height: auto;
}
.active {
  opacity: 50%;
}
/* Details Text */ 
.detailsText{
  grid-area: "text";
}
#modalCartBtn {
  padding-left: 30px;
  padding-right: 30px;
}


</style>