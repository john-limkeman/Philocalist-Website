import Vue from 'vue'
import Router from 'vue-router'
import Home from '../Views/Home.vue'
import StationaryListing from '../Views/StationaryListing.vue'
import StationaryDetails from '../Views/StationaryDetails.vue'


Vue.use(Router)

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home,
            meta: {
                requiresAuth: false
              }

        },
        {
            path: '/Stationary',
            name: 'StationaryListing',
            component: StationaryListing,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/Details',
            name: 'StationaryDetails',
            component: StationaryDetails,
            meta: {
                requiresAuth: false
            }
        }

    ]
})

//used for AUTH once we get that up and running

// router.beforeEach((to, from, next) => {
//     // Determine if the route requires Authentication
//     const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

//     // If it does and they are not logged in, send the user to "/login"
//     if (requiresAuth && store.state.token === '') {
//       next("/login");
//     } else {
//       // Else let them go to their next destination
//       next();
//     }
//   });

  export default router;