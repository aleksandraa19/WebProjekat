<template>
  <div>
    <h1>Pregled zahteva</h1>
    <ul>
      <li v-for="zahtev in zahtevi" :key="zahtev.email">
        <h3>Email: {{ zahtev.email }}</h3>
        <p>Telefon: {{ zahtev.telefon }}</p>
        <p>Poruka: {{ zahtev.poruka }}</p>
        <p>Datum:{{ zahtev.datum }}</p>
        <p>Status: {{ zahtev.status }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      zahtevi: [],
    };
  },
  mounted() {
    this.fetchZahtevi();
  },
  methods: {
    fetchZahtevi() {
      axios.get('http://localhost:9090/api/zahtev/getZahtevi')
        .then((response) => {
          this.zahtevi = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>

</style>
