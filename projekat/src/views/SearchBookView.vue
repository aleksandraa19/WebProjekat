<template>
  <div>
    <h1>Rezultati pretrage</h1>
    <ul>
      <li v-for="book in books" :key="book.naslov">
        {{ book.naslov }}
        <p>{{ book.naslovnaFotografija }}</p>
        <p>ISBN: {{ book.ISBN }}</p>
        <p>DATUM: {{ book.datumObjavljivanja }}</p>
        <p>BROJ STRANA: {{ book.brStrana }}</p>
        <p>OPIS: {{ book.opis }}</p>
        <p>ZANR: {{ book.zanr }}</p>
        <p>OCENA: {{ book.ocena }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      books: [],
    };
  },
  created() {
    const searchTerm = this.$route.query.searchTerm;
    if (searchTerm) {
      axios.get(`http://localhost:9090/api/knjige/${searchTerm}`)
        .then(response => {
          this.books = [response.data];
        })
        .catch(error => {
          console.error('Error:', error);
        });
    }
  },
};
</script>

