<template>
 <div>
    <h1>Welcome to the Home Page!</h1>
    <router-link to="/registration">Go to Registration</router-link>
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
