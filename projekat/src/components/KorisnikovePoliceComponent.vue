<template>
  <div>
    <h2>Korisnikove Police</h2>
    <ul>
      <li v-for="polica in police" :key="polica.name">{{ polica.name }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      police: [],
    };
  },
  mounted() {
    this.fetchKorisnikovePolice();
  },
  methods: {
    fetchKorisnikovePolice() {
      const korisnik = 1;
      axios
        .get(`http://localhost:9090/api/getpolice/${korisnikId}`)
        .then(response => {
          this.police = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch korisnikove police:', error);
        });
    },
  },
};
</script>

<style>

</style>
