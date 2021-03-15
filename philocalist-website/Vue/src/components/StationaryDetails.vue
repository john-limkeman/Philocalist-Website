<template>
  <div>
      <button class="exitBtn" v-on:click="closeModal()">X</button>
        <h2 class="modalTitle">{{modalContent.title}}</h2>
<div class="photoContainer">

    <div class="photoSlide">


    </div>

</div>

        <!-- <img v-bind:src="modalContent.imgURL" alt="error displaying image" class="modalImage"> -->
        <p>Price: ${{modalContent.price}} <br/>
          Theme: {{modalContent.theme}} <br/>
          Print Type: {{modalContent.printType}} <br/>
          <span id="modalCartBtn" v-bind:class="addBtnMethod()" v-on:click="addToCart()">{{isInCart}}</span>
        </p>

  </div>
</template>

<script>
import PhotoService from '../services/PhotoService.js'
export default {
data(){
    return{
        photos: [],
    }
},
props: ['modalContent'],
computed: {
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
      },
      closeModal(){
          this.$emit('close');
      }
      },
created() {
    PhotoService.getPhotosByStationaryId(this.modalContent.id).then((response) => {
        this.photos = response.data;
    })
        this.photos.push({
            id: 0,
            url: this.modalContent.imgURL,
            stationary_id: this.modalContent.id,
            title: "Front"
        })
        console.log(this.photos);

}
}
</script>

<style scoped>

img{
  max-height: 70%;
  max-width: 70%;
}

#modalCartBtn{
  padding-left: 30px;
  padding-right: 30px;
}
</style>