import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegistrationView from '../views/RegistrationView.vue'
import ZanrView from '../views/ZanrView.vue'

import RecenzijaView from '../views/RecenzijaView.vue'
import KorisnikView from '../views/KorisnikView.vue'
import LoginView from '../views/LoginView.vue'

import KnjigaView from '../views/KnjigaView.vue'
import SearchBookView from '../views/SearchBookView.vue'

import ZahtevZaAutoraView from '../views/ZahtevZaAutoraView.vue'
import CitalacHomeView from '../views/CitalacHomeView.vue'
import AdminHomeView from '../views/AdminHomeView.vue'
import AutorHomeView from '../views/AutorHomeView.vue'
import PolicaView from '../views/PolicaView.vue'

import DodajKnjiguView from '../views/DodajKnjiguView.vue'
import AzurirajAutoraView from '../views/AzurirajAutoraView'
import PregledZahtevaView from '../views/PregledZahtevaView'
import DodajZanrView from '../views/DodajZanrView'

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
    path: '/login',
    name: 'Login',
    component: LoginView
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
  },
  {
    path: '/knjige',
    name: 'Knjige',
    component: KnjigaView

  },
  {
    path: '/zahtev/posalji',
    name: 'ZahtevZaAutora',
    component: ZahtevZaAutoraView

  },
  {
    path: '/search',
    name: 'PretragaKnjige',
    component: SearchBookView


  },
  {
    path: '/citalac-home',
    name: 'CitalacHomeView',
    component: CitalacHomeView
  },
  {
    path: '/autor-home',
    name: 'AutorHomeView',
    component: AutorHomeView
  },
  {
    path: '/admin-home',
    name: 'AdminHomeView',
    component: AdminHomeView
  },
  {
    path: '/police-nazivi',
    name: 'PolicaView',
    component: PolicaView
  },
  {
    path: '/dodajKnjigu',
    name: 'DodajKnjiguView',
    component: DodajKnjiguView
  },
  {
    path: '/azurirajAutora',
    name: 'AzurirajAutoraView',
    component: AzurirajAutoraView
  },
  {
    path: '/pregledZahteva',
    name: 'PregledZahtevaView',
    component: PregledZahtevaView
  },
  {
    path: '/dodajZanr',
    name: 'DodajZanrView',
    component: DodajZanrView
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
