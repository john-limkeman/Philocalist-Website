<template>
  <div v-if="isRendered">
     <h2> {{theme.name}} </h2>
     <p>{{theme.description}}</p>
     
     <StationaryListing v-bind:StationaryTheme="theme.id"/>
  </div>
</template>

<script>
import StationaryListing from '../components/StationaryListing'
import ThemeService from '../services/ThemeService'
export default {
  components: { StationaryListing },
    data(){
        return{
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
            this.rerender();
        })
        },
        rerender(){
            this.isRendered = false;
            this.$nextTick(() => {
                this.isRendered = true;
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