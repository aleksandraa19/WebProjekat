<template>
  <form @submit.prevent="login">
    <label for="username">Username:</label>
    <input type="text" id="username" v-model="username">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" v-model="password">
    <br>
    <button type="submit">Login</button>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    login() {
      const loginData = {
        korisnickoIme: this.username,
        lozinka: this.password,
      };
      axios.post('http://localhost:9090/api/login', loginData)
        .then(response => {
          // Handle successful login
          const user = response.data;
          //localStorage.setItem('user', JSON.stringify(user));
          this.$emit('login-success');
        })
        .catch(error => {
          console.error('Error:', error);
          alert("greska");
          // Handle login error
        });
    },
  },
};
</script>
