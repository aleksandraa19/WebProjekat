<template>
 <div>
    <h1>Welcome to the Home Page!</h1>
    <div class="top-right">
    <router-link to="/registration">Go to Registration</router-link>
    </div>
    <br><br>
  <div class="container">  
    <div class="sidebar">
    <router-link to="/zanrovi">Zanrovi</router-link>
    </div>
  </div>  
    <router-view></router-view>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default { 
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
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

</style>

