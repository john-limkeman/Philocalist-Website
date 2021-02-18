import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import WeddingInvites from '../views/WeddingInviteMenu/WeddingInvites.vue'
import SaveTheDates from '../views/WeddingInviteMenu/SaveTheDates.vue'
import AddressLabels from '../views/WeddingInviteMenu/Add-Ons/AddressLabels.vue'
import DirectionsCards from '../views/WeddingInviteMenu/Add-Ons/DirectionsCards.vue'
import Envelopes from '../views/WeddingInviteMenu/Add-Ons/Envelopes.vue'
import EventsCards from '../views/WeddingInviteMenu/Add-Ons/EventsCards.vue'
import BachelorInvites from '../views/PartyInviteMenu/BachelorInvites.vue'
import BridalShowerInvites from '../views/PartyInviteMenu/BridalShowerInvites.vue'
import EngagementInvites from '../views/PartyInviteMenu/EngagementInvites.vue'
import RehearsalDinnerInvites from '../views/PartyInviteMenu/RehearsalDinnerInvites.vue'
import FavorTags from '../views/DayOfMenu/FavorTags.vue'
import Menus from '../views/DayOfMenu/Menus.vue'
import Placecards from '../views/DayOfMenu/Placecards.vue'
import Programs from '../views/DayOfMenu/Programs.vue'
import TableNumbers from '../views/DayOfMenu/TableNumbers.vue'
import WelcomeSigns from '../views/DayOfMenu/WelcomeSigns.vue'
import ThankYouCards from '../views/ThankYouCards.vue'


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
    path: '/wedding',
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
},
{
  path: '/address-labels',
  name: 'AddressLabels',
  component: AddressLabels,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/directions',
  name: 'DirectionsCards',
  component: DirectionsCards,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/envelopes',
  name: 'Envelopes',
  component: Envelopes,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/events-cards',
  name: 'EventsCards',
  component: EventsCards,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/bachelor',
  name: 'BachelorInvites',
  component: BachelorInvites,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/bridal-shower',
  name: 'BridalShowerInvites',
  component: BridalShowerInvites,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/engagement',
  name: 'EngagementInvites',
  component: EngagementInvites,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/rehearsal-dinner',
  name: 'RehearsalDinnerInvites',
  component: RehearsalDinnerInvites,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/favor-tags',
  name: 'FavorTags',
  component: FavorTags,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/menus',
  name: 'Menus',
  component: Menus,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/placecards',
  name: 'Placecards',
  component: Placecards,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/programs',
  name: 'Programs',
  component: Programs,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/table-numbers',
  name: 'TableNumbers',
  component: TableNumbers,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/welcome-signs',
  name: 'WelcomeSigns',
  component: WelcomeSigns,
  meta: {
      requiresAuth: false
  }
},
{
  path: '/thank-you',
  name: 'ThankYouCards',
  component: ThankYouCards,
  meta: {
      requiresAuth: false
  }
},
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
