import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegistrationView from '../views/RegistrationView.vue'
import ZanrView from '../views/ZanrView.vue'
import KnjigaView from '../views/KnjigaView.vue'
import SearchBookView from '../views/SearchBookView.vue'

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
    path: '/knjige',
    name: 'Knjige',
    component: KnjigaView

  },
  {
    path: '/search',
    name: 'PretragaKnjige',
    component: SearchBookView

  }


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
