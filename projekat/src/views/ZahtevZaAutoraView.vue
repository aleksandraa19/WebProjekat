<template>
  <div>
    <h1>Zahtev</h1>
    <ZahtevZaAutoraComponent />
  </div>
</template>

<script>
import ZahtevZaAutoraComponent from '@/components/ZahtevZaAutoraComponent.vue';

export default {
  components: {
    ZahtevZaAutoraComponent,
  },
};
</script>

<style scoped>
.background{
    color: #a2a8d3;
}
</style>