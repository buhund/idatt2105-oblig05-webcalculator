import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('../components/Home.vue')
    },
    {
      path: '/calculator',
      name: 'Calculator',
      component: () => import('../components/Calculator.vue')
    },
    {
      path: '/login',
      name: 'LoginPage',
      component: () => import('../components/LoginPage.vue')
    },
    {
      path: '/contact',
      name: 'ContactPage',
      component: () => import('../components/ContactPage.vue')
    },
    // Add other routes here
  ]
})

export default router
