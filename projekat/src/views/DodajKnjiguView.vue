<template>
  <div>
    <h1>Dodaj Knjigu</h1>
    <DodajKnjiguComponent />
  </div>
</template>

<script>
import DodajKnjiguComponent from '@/components/DodajKnjiguComponent.vue';

export default {
  components: {
    DodajKnjiguComponent,
  },
};
</script>

<style scoped>
.background{
    color: #a2a8d3;
}
</style>