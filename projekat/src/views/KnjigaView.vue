<template>
  <div>
    <h1>Knjiga List</h1>
    <table>
      <thead>
        <tr>
          <th>Naslov</th>
          <th>Naslovna Fotografija</th>
          <th>ISBN</th>
          <th>Datum Objavljivanja</th>
          <th>Broj Strana</th>
          <th>Opis</th>
          <th>Zanr</th>
          <th>Ocena</th>
        </tr>
      </thead>
      <tbody>
        <KnjigaComponent
          v-for="knjiga in knjige"
          :key="knjiga.ISBN"
          :knjiga="knjiga"
        ></KnjigaComponent>
      </tbody>
    </table>
  </div>
</template>

<script>
import KnjigaComponent from '@/components/KnjigaComponent.vue';
import axios from 'axios';

export default {
  components: {
    KnjigaComponent,
  },
  data() {
    return {
      knjige: [],
    };
  },
  mounted() {
    this.fetchKnjige();
  },
  methods: {
    fetchKnjige() {
      axios.get('http://localhost:9090/api/knjige')
        .then(response => {
          this.knjige = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
  },
};
</script>
