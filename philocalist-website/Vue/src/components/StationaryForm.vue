<template>
    <div>
        <form>
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
            <input type="number" name="Price" v-model="stationary.price"/>
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
            <label for="imgURL">Image URL: </label>
            <input type="text" name="imgURL" v-model="stationary.imgURL"/>
         <br/>
            <label for="isActive">Active?: </label>
            <input type="checkbox" name="isActive" v-model="stationary.isActive"/>
        <br/>
            <!-- Buttons use the prop's id value to determine if the prop being passed is an existing product -->
            <button type="submit" v-on:click="updateStationary(stationary)" v-if="this.selected.id > 0">Update Stationary</button>
            <button type="submit" v-on:click="createStationary(stationary)" v-else >Create Stationary</button>

        </form>
    </div>
</template>

<script>
import StationaryService from '../services/StationaryService';
export default {
data() {
    return {
        stationary: []
    }
},
props: ["selected"],
methods: {
    updateStationary(stationary){
        StationaryService.updateStationary(stationary);
        this.$emit("submitted");
    },
    createStationary(stationary){
        StationaryService.createStationary(stationary);
        this.$emit("submitted");
    },

},
created(){
    if(this.selected != null){
        this.stationary = this.selected;
    }

    console.log(this.selected);
}
}
</script>

<style>

</style>