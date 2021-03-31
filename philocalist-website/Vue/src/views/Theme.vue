<template>
  <div v-if="isRendered">
     <h2> {{theme.name}} </h2>
     
  </div>
</template>

<script>
import StationaryService from '../services/StationaryService'
import ThemeService from '../services/ThemeService'
export default {
    data(){
        return{
            stationaries: [],
            theme: {},
            isRendered: true,
        }
    },
    methods: {
        render(){
            ThemeService.getThemeById(this.$route.params.id).then(response =>{
            let theme = response.data;
            this.$store.dispatch('updateSelectedTheme', theme)

            this.theme = this.$store.getters.getSelectedTheme;

            StationaryService.getStationaryByTheme(this.theme.id).then(response => {
                this.stationaries = response.data;
            })
        })
        }
    },
    created(){
        this.render();
    },
    watch: {
        // eslint-disable-next-line no-unused-vars
        $route (to, from){
            this.render();
        }
    }
}
</script>

<style>

</style>