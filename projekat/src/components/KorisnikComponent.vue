<template>
  <div>
    <h2>KORISNICI</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>IME</th>
          <th>PREZIME</th>
          <th>KORISNICKO IME</th>
          <th>DATUM RODJENJA</th>
          <th>OPIS</th>
          <th>ULOGA</th>
          <th>Akcije</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="korisnik in korisnici" :key="korisnik.id">
          <td>{{ korisnik.id }}</td>
          <td>{{ korisnik.ime }}</td>
          <td>{{ korisnik.prezime }}</td>
          <td>{{ korisnik.korisnickoIme }}</td>
          <td>{{ korisnik.datumRodjenja }}</td>
          <td>{{ korisnik.opis }}</td>
          <td>{{ korisnik.uloga }}</td>
          <td>
            <router-link :to="`/police/korisnik`">Korisnikove Police</router-link>
          </td>
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
      korisnici: []
    };
  },
  mounted() {
    this.fetchKorisnici();
  },
  methods: {
    fetchKorisnici() {
      axios
        .get('http://localhost:9090/api/korisnici')
        .then(response => {
          this.korisnici = response.data;
        })
        .catch(error => {
          console.error('Error:', error);
        });
    },
    /*openUserPolice(korisnik) {
      window.open(`/police/korisnik`, '_blank');
    }*/
    openUserPolice(korisnik){
        this.$router.push("/korisnik?id=" + this.korisnik.id);
    }
  }
};
</script>

<style>
/*.table {

  justify-content: right;
  color: #00008B;
}*/
</style>
