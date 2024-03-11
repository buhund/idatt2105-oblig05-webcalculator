// src/composables/useAuth.js
import { ref } from 'vue';

const isAuthenticated = ref(false);

// Assume there's logic here to update isAuthenticated based on login/logout actions

export function useAuth() {
  return { isAuthenticated };
}
