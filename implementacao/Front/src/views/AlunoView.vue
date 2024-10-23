<template>
  <v-container fluid class="main pt-10">
    <v-row class="caixa-titulo">
      <v-col cols="8">
        <h1 class="title pl-3">Alunos</h1>
      </v-col>
      <v-col cols="4">
        <ModalCadastro />
      </v-col>
    </v-row>
    <v-divider :thickness="4"></v-divider>
    <v-row class="mt-4">
      <v-col>
        <AlunosDataTable
          :headers="dataTableHeaders"
          :isLoading="isLoading"
          :alunos="alunoStore.alunos"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { useAlunoView } from "./alunoView.js";
import ModalCadastro from "@/components/Aluno/ModalCadastroAluno.vue";
import AlunosDataTable from "@/components/Aluno/AlunosDataTable.vue";
import { onBeforeMount } from "vue";

const { dataTableHeaders, isLoading, alunoStore, getAllAlunos } =
  useAlunoView();

onBeforeMount(() => {
  getAllAlunos();
});
</script>

<style scoped>
.container {
  padding: 10px;
}
</style>
