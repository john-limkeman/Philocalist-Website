<template>
    <div class="stationaryForm">
        <form>
            <h3>Stationary Details: </h3>
            <label for="Title">Title: </label>
            <input type="text" name="Title" v-model="stationary.title">
        <br/>
            <label for="Category">Category: </label>
            <select name="Category" v-model="stationary.category">
                <option value="weddingInvite">Wedding Invitation</option>
                <option value="saveTheDate">Save the Date</option>
                <option value="thankYou">Thank You Card</option>
                <option value="engageInvite">Engagement Invitation</option>
                <option value="showerInvite">Bridal Shower Invitation</option>
                <option value="bachInvite">Bachelor/Bachelorette Invitation</option>
                <option value="rehearsalInvite">Rehearsal Dinner Invitation</option>
                <option value="eventCard">Event Card</option>
                <option value="envelope">Envelope</option>
                <option value="directionCard">Direction Card</option>
                <option value="addressLabel">Address Label</option>
                <option value="program">Program</option>
                <option value="menu">Menu</option>
                <option value="placeCard">Place Card</option>
                <option value="tableNumber">Table Number</option>
                <option value="welcomeSign">Welcome Sign</option>
                <option value="favor">Favor Tag/Sticker</option>
            </select>
        <br/>
            <label for="Price">Price: </label>
            <input type="number" name="Price" step="0.01" min="0" v-model="stationary.price"/>
        <br/>
            <label for="Theme">Theme: </label>
            <input type="text" name="Theme" v-model="stationary.theme"/>
        <br/>
            <label for="Color">Color: </label>
            <input type="text" name="Color" v-model="stationary.color"/>
         <br/>
            <label for="PrintType">Print Type: </label>
            <select name="PrintType" v-model="stationary.printType">
                <option value="digital">Digital</option>
                <option value="foilPress">Foil Press</option>
                <option value="letterPress">Letter Press</option>
            </select>
         <br/>
            <label for="imgURL">Hero Image URL: </label>
            <input type="text" name="imgURL" v-model="stationary.imgURL"/>
         <br/>
            <label for="isActive">Active?: </label>
            <input type="checkbox" name="isActive" v-model="stationary.isActive"/>
        <br/>
             <div class="photoFormContainer" v-if="this.stationary.id > 0">
                 <h3>Additional Photos: </h3>
                 <div class="photoForm" v-for="photo in photos" v-bind:key="photo.url" >
                     <label for="photoURL">URL: </label>
                     <input type="text" name="photoURL" class="photoURL" v-model="photo.url">
                     <label for="photoTitle">Title: </label>
                     <input type="text" name="photoTitle" class="photoTitle" v-model=photo.title>
                     <button @click.prevent="removePhotoForm(photo)" id="photoBtn" class="removeBtn">-</button>
                </div>
                <button @click.prevent="addPhotoForm()" id="photoBtn" class="addBtn">+</button>
             </div>
        <br/>
            <!-- Buttons use the prop's id value to determine if the prop being passed is an existing product -->
            <button type="submit" v-on:click="updateStationary()" v-if="this.selected.id > 0">Update Stationary</button>
            <button type="submit" v-on:click="createStationary()" v-else >Create Stationary</button>

        </form>
    </div>
</template>

<script>
import PhotoService from '../services/PhotoService';
import StationaryService from '../services/StationaryService';
export default {
data() {
    return {
        stationary: {},
        photos: [],
    }
},
props: ["selected"],
computed: {
    getid(){
        return this.selected.id
    },
},
methods: {
    updateStationary(){
        console.log(this.photos);
        
        PhotoService.deletePhotosByStationary(this.stationary.id);
        this.photos.forEach(photo => {
            if((photo.url != null) && (photo.title != null)){
                PhotoService.addPhoto(photo);
            }
        });
        StationaryService.updateStationary(this.stationary);
        this.$emit("submitted");
    },
    createStationary(){
        console.log(this.stationary);
        StationaryService.createStationary(this.stationary);
        this.$emit("submitted");
    },
    addPhotoForm(){
        this.photos.push({
             url: null,
            stationary_id: this.stationary.id,
            title: null,
        })
    }, 
    removePhotoForm(photo){
        let index = this.photos.indexOf(photo);
      this.photos.splice(index, 1);
    }
},
created(){
    if(this.selected != null){
        this.stationary = this.selected;
        
        PhotoService.getPhotosByStationaryId(this.selected.id).then(response => {
            this.photos = response.data;
                    })
    }
}

}
</script>

<style scoped>

#photoBtn{
    font-weight: bold;
    font-size: 15px;
    width: 30px;
    height: 20px;
    text-align: center;
}

.stationaryForm{
    text-align: left;
}

</style>