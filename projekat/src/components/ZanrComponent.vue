<template>
  <div>
    <h2>Genre</h2>
    <table>
      <thead>
        <tr>
          <th>Genre Name</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="zanr in zanrovi" :key="zanr.naziv">
          <td>{{ zanr.naziv }}</td>
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
      zanrovi: [],
    };
  },
  mounted() {
    this.fetchZanrovi();
  },
  methods: {
    fetchZanrovi() {
      axios
        .get('http://localhost:9090/api/zanrovi')
        .then(response => {
          this.zanrovi = response.data;
        })
        .catch(error => {
          console.error('Error:', error);
        });
    },
  },
};
</script>

<style scoped>
.background{
    color: #a2a8d3;
}
</style>
