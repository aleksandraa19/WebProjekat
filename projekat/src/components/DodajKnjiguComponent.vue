<template>
  <div class="gr">
    <form @submit="handleSubmit">
      <label for="naslov">Naslov:</label>
      <input type="text" id="naslov" v-model="knjigaDto.naslov" /><br>

      <label for="brStrana">Broj strana:</label>
      <input type="text" id="brStrana" v-model="knjigaDto.brStrana" /><br>

      <label for="ISBN">ISBN:</label>
      <input type="text" id="ISBN" v-model="knjigaDto.ISBN" /><br>

      <label for="zanr">Žanr:</label>
      <input type="text" id="zanr" v-model="knjigaDto.zanr" /><br>

      <label for="datumObjavljivanja">Datum objavljivanja:</label>
      <input type="text" id="datumObjavljivanja" v-model="knjigaDto.datumObjavljivanja" /><br>

      <label for="naslovnaFotografija">Naslovna fotografija:</label>
      <input type="text" id="naslovnaFotografija" v-model="knjigaDto.naslovnaFotografija" /><br>

      <label for="opis">Opis:</label>
      <textarea id="opis" v-model="knjigaDto.opis"></textarea><br>

      <button type="submit">Dodaj</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      knjigaDto: {
        naslov: '',
        brStrana: '',
        ISBN: '',
        zanr: '',
        datumObjavljivanja: '',
        naslovnaFotografija: '',
        opis: ''
      }
    };
  },

  methods: {
    handleSubmit() {
      axios.post('http://localhost:9090/api/autor/dodajKnjige', this.knjigaDto)
        .then(response => {
          alert('Uspešno ste dodali knjigu!');
          this.$router.push('/autor-home');
        })
        .catch(error => {
          console.error('Error:', error);
          alert("greska");
    
        });
    }
    /*async handleSubmit(e) {
      e.preventDefault();

      try {
        const response = await axios.post('http://localhost:9090/api/autor/dodajKnjige', this.knjigaDto);
        console.log(response.data);

        if (response.status === 200) {
          alert('Uspešno ste dodali knjigu!');
          this.$router.push('/autor-home');
        }
      } catch (error) {
        console.error(error.response.data);

        if (error.response.status === 401) {
          alert('Nema sesije. Ulogujte se!');
          this.$router.push('/login');
        } else if (error.response.status === 400) {
          alert('Došlo je do greške. Proverite unesene podatke!');
        }
      }
    }*/
  }
};
</script>

<style scoped>
.background {
  color: #a2a8d3;
}
</style>