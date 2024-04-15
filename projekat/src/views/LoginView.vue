<template>
  <div>
    <h1>Login</h1>
    <login-component @login-success="handleLoginSuccess"></login-component>
  </div>
</template>

<script>
import LoginComponent from '@/components/LoginComponent.vue';

export default {
  components: {
    LoginComponent,
  },
  methods: {
    handleLoginSuccess() {
      const userRole = JSON.parse(localStorage.getItem('user')).uloga;
      switch (userRole) {
        case 'CITALAC':
          this.$router.push('/citalac-home');
          break;
        case 'AUTOR':
          this.$router.push('/autor-home');
          break;
        case 'ADMINISTRATOR':
          this.$router.push('/admin-home');
          break;
        default:
          break;
      }
    },
  },
};
</script>
