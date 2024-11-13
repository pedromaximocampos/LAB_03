<template>
  <v-container fluid class="main pt-10">
    <v-row class="caixa-titulo">
      <v-col cols="8">
        <h1 class="title pl-3">Vantagens</h1>
      </v-col>
      <v-col cols="4">
        <ModalCadastroVantagens />
      </v-col>
    </v-row>
    <v-divider :thickness="4"></v-divider>
    <v-row class="mt-4">
      <v-col
        v-for="vantagem in vantagemStore.vantagens"
        :key="vantagem.id"
        cols="12"
        lg="4"
      >
        <CardVantagem :vantagem="vantagem"></CardVantagem>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import ModalCadastroVantagens from "@/components/Vantagens/ModalCadastroVantagens.vue";
import CardVantagem from "@/components/Vantagens/CardVantagem.vue";
import { onBeforeMount } from "vue";

import { useVantagemView } from "@/views/vantagensView.js";

const { getAllVantagens, vantagemStore } = useVantagemView();

onBeforeMount(() => {
  getAllVantagens();
});
</script>

<style scoped>
.container {
  padding: 10px;
}
</style>
