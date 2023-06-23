<template>
  <div>
    <h2>Login</h2>
    <form @submit="login">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" required>
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <br>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login(event) {
      event.preventDefault();

      const loginData = {
        korisnickoIme: this.username,
        lozinka: this.password
      };

      axios.post('http://localhost:9090/api/login', loginData)
        .then(response => {
          // Proveriti status odgovora
          if (response.status === 200) {
            // Uspesno logovanje
            alert('Successfully logged in!');
            // Redirekcija na drugu stranicu ili obavljanje dodatnih akcija
          } else {
            // Neuspesno logovanje
            alert('User does not exist!');
          }
        })
        .catch(error => {
          // Prikazati gresku u konzoli ili preduzeti odgovarajuce akcije
          console.error(error);
        });
    }
  }
};
</script>
