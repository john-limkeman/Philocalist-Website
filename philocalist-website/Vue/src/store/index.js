import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
    axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
  }

  export default new Vuex.Store({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      logIn: false,
      cart: [

      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
        state.logIn = true;
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
        state.logIn = false;
      },
      ADD_TO_CART(state, stationary){
        state.cart.push(stationary);
      },
      REMOVE_FROM_CART(state, stationary){
        let index = state.cart.push(stationary);
        state.cart.splice(index, 1); //this is currently removing the last item, not the selected one
      }
      // ADD_NEW_STATIONARY(state, stationary){
      //   state.
      // }
    },
    actions: {
        // addNewStationary({commit}, stationary){
        //   commit('ADD_NEW_STATIONARY', stationary)
        // },
        addStationaryToCart({commit}, stationary){
          commit('ADD_TO_CART', stationary);
        },
        removeStationaryFromCart({commit}, stationary){
          commit('REMOVE_FROM_CART', stationary);
        }
    },
    getters: {
        getCartSize(state){
          return state.cart.length;
        },
        getCart(state){
          return state.cart;
        }
    }
  })