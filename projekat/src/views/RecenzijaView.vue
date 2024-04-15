<template>
  <div>
    <h1>Recenzije View</h1>
    <RecenzijaComponent />
  </div>
</template>

<script>
import RecenzijaComponent from '@/components/RecenzijaComponent.vue';

export default {
  components: {
    RecenzijaComponent,
  },
};
</script>

<style scoped>
.background{
    color: #a2a8d3;
}
</style>