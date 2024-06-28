
/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import { createRouter, createWebHistory } from 'vue-router'
const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/pages/indexPage.vue'),
      
    
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/pages/loginPage.vue'),
  },
  {
    path: '/horarios',
    name: 'horarios',
    component: () => import('@/pages/horariosPage.vue'),
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('@/pages/profilePage.vue'),
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('@/pages/testPage.vue'),
  },
  {
    path: '/adminProfile',
    name: 'adminProfile',
    component: () => import('@/pages/profilePageAdmin.vue'),
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
