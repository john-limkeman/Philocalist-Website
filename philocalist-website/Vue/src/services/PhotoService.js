import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default {
    getAllPhotos(){
        return http.get('/photos');
    },
    getPhotosByStationaryId(id){
        return http.get(`/photos/stationary/${id}`)
    },
    getPhotoById(id){
        return http.get(`/photos/${id}`);
    },
    addPhoto(photo){
        return http.post('/photos', photo);
    },
    updatePhoto(photo, id){
        return http.put(`/photos/${id}`, photo);
    },
    deletePhoto(id){
        return http.delete(`/photos/${id}`);
    }
}