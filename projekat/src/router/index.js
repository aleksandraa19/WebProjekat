import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegistrationView from '../views/RegistrationView.vue'
import ZanrView from '../views/ZanrView.vue'
import RecenzijaView from '../views/RecenzijaView.vue'
import KorisnikView from '../views/KorisnikView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/registration',
    name: 'Registracija',
    component: RegistrationView
  },
  {
    path: '/zanrovi',
    name: 'Zanrovi',
    component: ZanrView
  },
  {
    path: '/recenzije',
    name: 'Recenzije',
    component: RecenzijaView
  },
  {
    path: '/korisnici',
    name: 'Korisnici',
    component: KorisnikView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
