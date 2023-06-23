<template>
  <div>
    <h1>Pregled zahteva</h1>
    <ul>
      <li v-for="zahtev in zahtevi" :key="zahtev.id">
        <h3>Email: {{ zahtev.email }}</h3>
        <p>Telefon: {{ zahtev.telefon }}</p>
        <p>Poruka: {{ zahtev.poruka }}</p>
        <p>Status: {{ zahtev.status }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
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
      this.$axios.get('http://localhost:8080/api/zahtev/getZahtevi')
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
