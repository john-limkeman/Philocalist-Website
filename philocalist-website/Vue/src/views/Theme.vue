<template>
  <div>
      {{theme.name}}
  </div>
</template>

<script>
import ThemeService from '../services/ThemeService'
export default {
    data(){
        return{
            theme: {},
        }
    },
    created(){
        ThemeService.getThemeById(this.$route.params.id).then(response =>{
            this.theme = response.data;
        })
    }
}
</script>

<style>

</style>