<template>
  <div>
    <h2>POŠALJI ZAHTEV</h2>
    <form @submit.prevent="submitZahtev">
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="zahtev.email" required>
      </div>
      <div>
        <label for="telefon">Telefon:</label>
        <input type="text" id="telefon" v-model="zahtev.telefon" required>
      </div>
      <div>
        <label for="poruka">Poruka:</label>
        <textarea id="poruka" v-model="zahtev.poruka" required></textarea>
      </div>
      <button type="submit">Pošalji</button>
    </form>
    <p v-if="successMessage" class="success">{{ successMessage }}</p>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      zahtev: {
        email: '',
        telefon: '',
        poruka: ''
      },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    submitZahtev() {
      axios.post('http://localhost:9090/api/zahtev/posalji', this.zahtev)
        .then(response => {
          console.log('Success:', response.data);
          this.successMessage = 'Zahtev je uspešno poslat!';
          this.errorMessage = '';
        })
        .catch(error => {
          console.error('Error:', error);
          this.successMessage = '';
          this.errorMessage = 'Došlo je do greške prilikom slanja zahteva.';
        });
    }
  }
};
</script>

<style>
.success {
  color: green;
}

.error {
  color: red;
}
</style>
