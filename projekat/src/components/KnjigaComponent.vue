<template>
  <tr>
    <td>{{ knjiga.naslov }}</td>
    <td>{{ knjiga.naslovnaFotografija }}</td>
    <td>{{ knjiga.ISBN }}</td>
    <td>{{ knjiga.datumObjavljivanja }}</td>
    <td>{{ knjiga.brStrana }}</td>
    <td>{{ knjiga.opis }}</td>
    <td>{{ knjiga.zanr }}</td>
    <td>{{ knjiga.ocena }}</td>
  </tr>
</template>

<script>
export default {
  props: ['knjiga'],
};
</script>