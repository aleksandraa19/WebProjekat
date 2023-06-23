<template>
  <div class="gr">
    <form @submit.prevent="handleSubmit">
      <label for="ime">Ime:</label>
      <input type="text" id="ime" v-model="autor.ime" /><br>

      <label for="prezime">Prezime:</label>
      <input type="text" id="prezime" v-model="autor.prezime" /><br>

      <label for="biografija">Biografija:</label>
      <textarea id="biografija" v-model="autor.biografija"></textarea><br>

      <button type="submit">Azuriraj</button>
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
      autor: {
        ime: '',
        prezime: '',
        biografija: ''
      },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    handleSubmit() {
      axios.post('http://localhost:9090/api/azurirajAutora', this.autor)
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
    
    /*async handleSubmit(e) {
      e.preventDefault();

      try {
        const response = await this.$axios.put('http://localhost:9090/api/azurirajAutora', this.autor);
        console.log(response.data);

        if (response.status === 200) {
          alert('Autor je uspešno ažuriran!');
          this.$router.push('/autor-home');
        }
      } catch (error) {
        console.error(error.response.data);

        if (error.response.status === 401) {
          alert('Nema sesije. Ulogujte se!');
          this.$router.push('/login');
        } else if (error.response.status === 400) {
          alert('Došlo je do greške. Proverite unesene podatke!');
        }
      }
    }*/
  }
};
</script>

<style>
</style>
