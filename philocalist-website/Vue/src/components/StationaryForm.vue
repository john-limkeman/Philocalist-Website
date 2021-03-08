<template>
    <div>
        <form action="">
            <label for="Title">Title: </label>
            <input type="text" name="Title" v-model="stationary.title">

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
            <label for="Price">Price: </label>
            <input type="number" name="Price">
        </form>
    </div>
</template>

<script>
export default {
data() {
    return {
        stationary: []
    }
},
props: ["selected"],
created(){
   this.stationary = this.selected;
}
}
</script>

<style>

</style>