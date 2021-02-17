import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import WeddingInvites from '../views/WeddingInvites.vue'
import SaveTheDates from '../views/SaveTheDates.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/wedding-invites',
    name: 'WeddingInvites',
    component: WeddingInvites,
    meta: {
        requiresAuth: false
    }
},
{
    path: '/save-the-dates',
    name: 'SaveTheDates',
    component: SaveTheDates,
    meta: {
        requiresAuth: false
    }
}
]

const router = new VueRouter({
  routes
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
export default router
