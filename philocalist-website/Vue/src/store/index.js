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
      adminChoice: {},
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
      /* checks to ensure item does not already exist in cart before adding it */
      if(!foundItem){ 
        stationary.quantity = 1
        console.log("quantity: " + stationary.quantity)
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

      /* This will remove item and push it with new quantity (pushing to store causes store components to re-render) */
      UPDATE_CART_QUANTITY(state, payload){
          let foundItem = state.cart.find(item => {
            return item.id == payload.id; })

            if(foundItem){ 

              state.cart = state.cart.filter(item => {
              return item.id !== payload.id; })

            foundItem.quantity = payload.quantity;

            state.cart.push(foundItem);
            console.log("quantity updated to " + foundItem.quantity + " on: " + foundItem.title)
          } else {
            console.log("ERROR - add item to cart before changing quantity")
          }
      },
      SET_ADMIN_CHOICE(state, stationary){
        state.adminChoice = stationary;
        console.log(state.adminChoice);
      },
      EMPTY_ADMIN_CHOICE(state){
        state.adminChoice = {};
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
          commit('UPDATE_CART_QUANTITY', payload);
        },
        setAdminChoice({commit}, stationary){
          commit('SET_ADMIN_CHOICE', stationary);
        },
        emptyAdminChoice({commit}){
          commit('EMPTY_ADMIN_CHOICE')
        }
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
            
            total += item.price * item.quantity
          })
          return total;
        }
    }
  })