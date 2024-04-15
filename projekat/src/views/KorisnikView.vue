<template>
  <div>
    <h1>Korisnik View</h1>
    <KorisnikComponent />
  </div>
</template>

<script>
import KorisnikComponent from '@/components/KorisnikComponent.vue';

export default {
  components: {
    KorisnikComponent,
  },
};
</script>

<style scoped>
.background{
    color: #a2a8d3;
}
</style>