import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default {

    getInformation(){
        return http.get('/websiteInfo')
    },
    updateInformation(info){
        return http.put('/websiteInfo', info)

    }

}