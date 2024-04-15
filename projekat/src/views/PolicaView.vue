<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Naziv</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="polica in policeList" :key="polica.naziv">
          <td>{{ polica.naziv }}</td>
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
      policeList: [],
    };
  },
  mounted() {
    axios
      .get('http://localhost:9090/api/getpolice/' + this.$route.query.id, { withCredentials: true })
      .then(response => {
        this.policeList = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },
};
</script>
