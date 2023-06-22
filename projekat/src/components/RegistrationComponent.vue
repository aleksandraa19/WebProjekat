<template>
  <div>
    <h1>Registration</h1>
    <form @submit="registerUser">
      <label for="ime">First Name:</label>
      <input type="text" id="ime" v-model="registerData.ime" required>

      <label for="prezime">Last Name:</label>
      <input type="text" id="prezime" v-model="registerData.prezime" required>

      <label for="korisnickoIme">Username:</label>
      <input type="text" id="korisnickoIme" v-model="registerData.korisnickoIme" required>

      <label for="mejlAdresa">Email:</label>
      <input type="email" id="mejlAdresa" v-model="registerData.mejlAdresa" required>

      <label for="lozinka1">Password:</label>
      <input type="password" id="lozinka1" v-model="registerData.lozinka1" required>

      <label for="lozinka2">Confirm Password:</label>
      <input type="password" id="lozinka2" v-model="registerData.lozinka2" required>

      <label for="datumRodjenja">Date of Birth:</label>
      <input type="date" id="datumRodjenja" v-model="registerData.datumRodjenja" required>

      <button type="submit">Register</button>
    </form>
    <p>{{ registrationStatus }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data: function() {
    return {
      registerData: {
        ime: '',
        prezime: '',
        korisnickoIme: '',
        mejlAdresa: '',
        lozinka1: '',
        lozinka2: '',
        datumRodjenja: '',
      },
      registrationStatus: '',
    };
  },
  methods: {
    registerUser(event) {
      event.preventDefault();

      axios.post('http://localhost:9090/api/registracija', this.registerData)
        .then(response => {
          // Registration successful
          this.registrationStatus = response.data;
          alert("Registrovani ste");
        })
        .catch(error => {
          if (error.response && error.response.data) {
            this.registrationStatus = error.response.data;
           } else {
            this.registrationStatus = 'An error occurred during registration.';
            alert("greska");
          }
        });
    },
  },
};
</script>

