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
      cart: [],
      quantities: [],
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
        let foundItem = state.cart.find((item) => {
          return item.id === stationary.id;
      });
      if(!foundItem){ /* check to ensure item does not already exist in cart before adding it */
        state.cart.push(stationary)
        console.log("cart size: " + state.cart.length);
      }else{
        console.log("Avoiding multiple entries into cart");
      }
      },
      REMOVE_FROM_CART(state, stationary){
      state.cart = state.cart.filter(item => {
        console.log(stationary.id);
        return item.id !== stationary.id;
      })
      },
      UPDATE_CART_QUANTITY(state, payload){
          let foundItem = state.quantities.find(item => {
            return item.id == payload.id;
          })

          if(foundItem){
            foundItem.quantity = payload.quantity;
          } else {
            state.quantities.push(payload
            )
          }
          console.log(state.quantities);
      }
    },
    actions: {
        addStationaryToCart({commit}, stationary){
          commit('ADD_TO_CART', stationary);
        },
        removeStationaryFromCart({commit}, stationary){
          commit('REMOVE_FROM_CART', stationary);
        },
        updateQuantity({commit}, payload){
          commit('UPDATE_CART_QUANTITY', payload)
        },
    },
    getters: {
        getCartSize(state){
          return state.cart.length;
        },
        getCart(state){
          return state.cart;
        },
        getQuantities(state){
        return state.quantities
        },
        cartTotal(state){
          let total = 0;

          state.cart.forEach(item => {
            let quan = state.quantities.filter(q => {
              return q.id === item.id});
              console.log(quan.quantity);
            total += item.price * quan.quantity
          })
          return total;
        }
    }
  })