
import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default {

    getAllStationary() {
        return http.get('/allStationary');
    },
    getAllStationaryByCategory(category){
        return http.get(`/allStationary/${category}`)
    },
    getStationaryById(id){
        return http.get(`/stationary/${id}`)
    }
}