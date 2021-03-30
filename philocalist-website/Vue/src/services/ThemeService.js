
import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default {

    getAllThemes() {
        return http.get('/themes');
    },
    getThemeById(id){
        return http.get(`/themes/${id}`);
    },
    getFeaturedTheme(){
        return http.get('/themes/featured');
    },
    updateTheme(theme){
        return http.put(`/themes/${theme.id}`, theme);
    },
    createTheme(theme){
        return http.post(`/themes`, theme);
    },
    deleteTheme(id){
        return http.delete(`/themes/${id}`);
    }
}