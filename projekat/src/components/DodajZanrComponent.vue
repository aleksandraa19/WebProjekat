<template>
  <div>
    <h1>Dodaj žanr</h1>
    <form @submit.prevent="submitForm">
      <label for="naziv">Naziv:</label>
      <input type="text" id="naziv" v-model="zanr.naziv" required>
      <br><br>
      <button type="submit">Dodaj žanr</button>
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
        zanr:{
            naziv: ''
        },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    submitForm() {
     
      axios.post('http://localhost:9090/api/dodajZanr', this.zanr)
        .then(response => {
          console.log(response.data);
          this.successMessage = 'Zanr je uspešno dodat!';
          this.errorMessage = '';
        })
        .catch(error => {
          console.error(error);
          this.successMessage = '';
          this.errorMessage = 'Došlo je do greške';
        });
    }
  }
};
</script>

<style scoped>
.success {
  color: green;
}

.error {
  color: red;
}
</style>
