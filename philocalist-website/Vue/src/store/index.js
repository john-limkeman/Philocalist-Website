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
      ADD_TO_CART(state, {stationary, quantity}){
        let foundItem = state.cart.find(item => {
          return item.product.id === stationary.id;
      });

      if (foundItem) {
        foundItem.quantity += quantity;
        return;
    }
        state.cart.push({
          stationary,
          quantity
        });
      },
      REMOVE_FROM_CART(state, stationary){
      state.cart = state.cart.filter(item => {
        console.log(stationary.id);
        return item.id !== stationary.id;
      })
      }
    },
    actions: {
        addStationaryToCart({commit}, {stationary, quantity}){
          commit('ADD_TO_CART', {stationary, quantity});
        },
        removeStationaryFromCart({commit}, {stationary, quantity}){
          commit('REMOVE_FROM_CART', {stationary, quantity});
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