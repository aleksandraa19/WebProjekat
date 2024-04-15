<template>
  <div>
    <h2>Recenzije</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>KORISNIK</th>
          <th>OCENA</th>
          <th>TEXT</th>
          <th>DATUM RECENZIJE</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="recenzija in recenzije" :key="recenzija.id">
          <td>{{ recenzija.id }}</td>
          <td>{{ recenzija.korisnik.korisnickoIme }}</td>
          <td>{{ recenzija.ocena }}</td>
          <td>{{ recenzija.text }}</td>
          <td>{{ recenzija.datumRecenzije }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
    recenzije  : [],
    };
  },
  mounted() {
    this.fetchRecenzije();
  },
  methods: {
    fetchRecenzije() {
      axios
        .get('http://localhost:9090/api/recenzije')
        .then(response => {
          this.recenzije = response.data;
        })
        .catch(error => {
          console.error('Error:', error);
        });
    },
  },
};
</script>

<style>
</style>