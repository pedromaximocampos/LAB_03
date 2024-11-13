<template>
  <v-card variant="tonal" class="mt-3">
    <v-row class="mecanico px-5 py-2">
      <v-col cols="4" class="d-flex justify-center align-center">
        <v-img
          :src="props.vantagem.foto"
          :width="200"
          :height="200"
          fit
        ></v-img>
      </v-col>
      <v-col cols="8">
        <h3 class="my-2"><strong>Nome:</strong></h3>
        <p>{{ props.vantagem.nome }}</p>
        <h4 class="my-2">
          <strong>Descricao:</strong>
        </h4>
        <p>{{ props.vantagem.descricao }}</p>
        <h4 class="my-2">
          <strong>Custo Moedas:</strong> {{ props.vantagem.moedas }}
        </h4>
      </v-col>
    </v-row>
  </v-card>
</template>

<script setup>
import { defineProps } from "vue";

const props = defineProps({
  vantagem: {
    type: Object,
    required: true,
  },
});

console.log(props.vantagem);
</script>

<style scoped>
.mecanico {
  height: 250px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
