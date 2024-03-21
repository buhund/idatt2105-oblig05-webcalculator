// src/composables/useAuth.js
import { ref, readonly } from 'vue';

const token = ref(localStorage.getItem('userToken'));
const username = ref(localStorage.getItem('username')); // Store the username
const isLoggedIn = ref(!!token.value);

export function useAuth() {
  const login = (tokenValue, usernameValue) => {
    token.value = tokenValue;
    username.value = usernameValue;
    isLoggedIn.value = true;
    localStorage.setItem('userToken', tokenValue);
    localStorage.setItem('username', usernameValue); // Save the username
  };

  const logout = () => {
    token.value = null;
    username.value = null; // Clear the username
    isLoggedIn.value = false;
    localStorage.removeItem('userToken');
    localStorage.removeItem('username');
  };

  return {
    isLoggedIn: readonly(isLoggedIn),
    username: readonly(username), // Expose the username
    login,
    logout,
  };
}
