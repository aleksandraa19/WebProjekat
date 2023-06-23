<template>
 <div>
   
   <h1>WELCOME to READER</h1>
    <div class="top-right">
    <router-link to="/registration">Go to Registration</router-link><br>
    <router-link to="/login">Go to Login</router-link><br>
    <router-link to="/zahtev/posalji">Posalji zahtev</router-link>
    </div>
    <div class="search-bar">
    <h3>Pretrazite knjigu</h3>
    <input type="text" v-model="searchTerm" placeholder="Ime knjige">
    <button @click="search">Pretrazi</button>
    </div>
    
    <br><br>
     
  <div class="container">   
    <div class="sidebar">

    <router-link to="/zanrovi">Zanrovi</router-link><br>
    <router-link to="/recenzije">Recenzije</router-link><br>
    <router-link to="/korisnici">Korisnici</router-link><br>

    <router-link to="/zanrovi">Zanrovi</router-link>
    <br><br>
    <router-link to="/knjige">Knjige</router-link>

    </div>
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

