<template>
  <v-container fluid class="main pt-10">
    <v-row class="caixa-titulo">
      <v-col cols="6">
        <h1 class="title pl-3">Alunos</h1>
      </v-col>
      <v-col cols="3">
        <ModalCadastro />
      </v-col>
      <v-col cols="3">
        <v-btn @click="openExtratoModal" color="primary">Visualizar Extrato</v-btn>
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

    <!-- Modal para Exibir Extrato -->
    <v-dialog v-model="isExtratoModalOpen" max-width="600px">
      <v-card>
        <v-card-title class="headline">Extrato do Aluno</v-card-title>
        <v-card-text>
          <div v-if="extrato">
            <p><strong>Moedas disponíveis:</strong> {{ extrato.moedas }}</p>
            <v-list dense>
              <v-list-item v-for="transacao in extrato.transacao" :key="transacao.id">
                <v-list-item-content>
                  <p><strong>ID Transação:</strong> {{ transacao.id }}</p>
                  <p><strong>Aluno:</strong> {{ transacao.aluno }}</p>
                  <p><strong>Profesor:</strong> {{ transacao.aluno }}</p>
                  <p><strong>Moedas:</strong> {{ transacao.moedas }}</p>
                  <p><strong>Descrição:</strong> {{ transacao.descricao }}</p>
                  <p><strong>Data:</strong> {{ new Date(transacao.data).toLocaleString() }}</p>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </div>
          <div v-else>
            <p>Carregando extrato...</p>
          </div>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="isExtratoModalOpen = false">Fechar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script setup>
import { useAlunoView } from "./alunoView.js";
import ModalCadastro from "@/components/Aluno/ModalCadastroAluno.vue";
import AlunosDataTable from "@/components/Aluno/AlunosDataTable.vue";
import { onBeforeMount, ref } from "vue";
import axios from "axios";

const { dataTableHeaders, isLoading, alunoStore, getAllAlunos } = useAlunoView();

const isExtratoModalOpen = ref(false);
const extrato = ref(null);

const openExtratoModal = async () => {
  try {
    isExtratoModalOpen.value = true;
    const response = await axios.get(`http://localhost:8080/alunos/1/extrato`);
    extrato.value = response.data;
  } catch (error) {
    console.error("Erro ao buscar extrato:", error);
  }
};

onBeforeMount(() => {
  getAllAlunos();
});
</script>

<style scoped>
.container {
  padding: 10px;
}
</style>