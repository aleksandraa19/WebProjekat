<template>
  <div >
    <h1>Welcome Autor!</h1>
   


<div class="container">   
    <div class="sidebar">

    <router-link to="/zanrovi">Zanrovi</router-link>
    <br><br>
    <router-link to="/recenzije">Recenzije</router-link>
    <br><br>
    <router-link to="/korisnici">Korisnici</router-link>
    <br><br>
    <router-link to="/zanrovi">Zanrovi</router-link>
    <br><br>
    <router-link to="/knjige">Knjige</router-link>

    </div>
</div> 
    <div class = "funkc">
      <router-link to="/dodajKnjigu">Dodaj knjigu</router-link>
      <router-link to="/azurirajAutora">Azuriraj profil</router-link>
    </div>

    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: '',
    };
  },
  methods: {
    search() {
      if (this.searchTerm) {
        this.$router.push({ path: '/search', query: { searchTerm: this.searchTerm } });
      }
    },
  },
};
</script>

<style>

.funkc{
  position: centar;
}

.top-right{
  position:absolute;
  top: 0;
  right: 0;
}

body{
  background-color: rgb(235, 218, 213);
}

.container{
  display: flex;
}

.sidebar{
  width: 200px;
  background-color: rgb(197, 233, 232);
}

.search-bar {
  position:absolute;
  top: 10px;
  left: 10px;
  background-color: rgba(202, 140, 184, 0.41);
}
</style>