<template>
  <div>
    <form @submit.prevent="login">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" required>
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <br>
      <button type="submit">Login</button>
    </form>
    <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      errorMessage: ''
    };
  },
  methods: {
    login() {
      if (this.username && this.password) {
        const credentials = {
          korisnickoIme: this.username,
          lozinka: this.password
        };

        // Slanje POST zahteva na server
        axios.post('/api/login', credentials)
          .then(response => {
            // Uspešno prijavljivanje korisnika
            // Možete implementirati preusmeravanje na drugu stranicu
            console.log('Successfully logged in:', response.data);
          })
          .catch(error => {
            // Greška pri prijavljivanju korisnika
            this.errorMessage = 'Failed to login. Please check your credentials.';
            console.error('Login failed:', error);
          });
      } else {
        this.errorMessage = 'Please enter username and password.';
      }
    }
  }
};
</script>

<style>
.error-message {
  color: red;
  margin-top: 10px;
}
</style>
