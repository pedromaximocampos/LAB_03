<template>
  <v-container fluid class="main pt-10">
    <v-row class="caixa-titulo">
      <v-col cols="8">
        <h1 class="title pl-3">Empresas</h1>
      </v-col>
      <v-col cols="4">
        <ModalCadastro />
      </v-col>
    </v-row>
    <v-divider :thickness="4"></v-divider>
    <v-row class="mt-4">
      <v-col>
        <EmpresaDataTable
          :headers="dataTableHeaders"
          :empresas="empresaStore.empresas"
          :is-loading="isLoading"
        ></EmpresaDataTable>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { useEmpresaView } from "./empresaView";
import ModalCadastro from "@/components/Empresas/ModalCadastroEmpresa.vue";
import EmpresaDataTable from "@/components/Empresas/EmpresaDataTable.vue";
import { onBeforeMount } from "vue";

const { dataTableHeaders, isLoading, empresaStore, getAllEmpresas } =
  useEmpresaView();

onBeforeMount(() => {
  getAllEmpresas();
});
</script>

<style scoped>
.container {
  padding: 10px;
}
</style>
