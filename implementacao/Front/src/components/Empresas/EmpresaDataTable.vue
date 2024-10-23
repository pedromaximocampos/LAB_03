<template>
  <v-data-table
    class="mt-4 py-3 px-4 table-background"
    fixed-header
    :items-per-page="-1"
    :headers="props.headers"
    :items="props.empresas"
    no-data-text="Sem Dados"
    loading-text="Carregando dados..."
    hide-default-footer
    :loading="props.isLoading"
  >
    <template v-slot:[`item.update`]="{ item }">
      <v-icon
        icon="mdi-pencil-box-outline"
        @Click="toggleUpdate('update', item)"
        :disabled="props.isLoading"
      >
      </v-icon>
    </template>
    <template v-slot:[`item.nome`]="{ item }">
      <span class="uppercase">{{ item.nome }}</span>
    </template>

    <template v-slot:[`item.delete`]="{ item }">
      <v-icon
        icon="mdi-delete"
        @click="toggleDelete('delete', item)"
        :disabled="props.isLoading"
      >
      </v-icon>
    </template>
  </v-data-table>

  <v-dialog v-model="updateDialog" max-width="1000" max-height="1000">
    <ModalUpdateEmpresa
      :empresaToUpdate="selectedEmpresa"
      @closeModal="toggleUpdate"
      @updateEmpresa="handleUpdateEmpresa"
    ></ModalUpdateEmpresa>
  </v-dialog>

  <v-dialog v-model="deleteDialog" max-width="700" max-height="800">
    <ModalDeleteEmpresa
      :empresaToDelete="selectedEmpresa"
      @closeModal="toggleDelete"
      @deleteEmpresa="handleDeleteEmpresa"
    ></ModalDeleteEmpresa>
  </v-dialog>
</template>

<script setup>
import { ref } from "vue";
import { useEmpresaView } from "@/views/empresaView";
import ModalDeleteEmpresa from "./ModalDeleteEmpresa.vue";
import ModalUpdateEmpresa from "./ModalUpdateEmpresa.vue";

const { deleteEmpresa, updateEmpresa } = useEmpresaView();

const selectedEmpresa = ref(null);
const props = defineProps({
  headers: {
    type: Array,
    required: true,
  },
  empresas: {
    type: Array,
    required: true,
  },
  isLoading: {
    type: Boolean,
    required: true,
  },
});

const updateDialog = ref(false);
const deleteDialog = ref(false);

function toggleUpdate(action, item) {
  if (action === "update") {
    selectedEmpresa.value = item;
    updateDialog.value = true;
  } else {
    updateDialog.value = false;
  }
}

function toggleDelete(action, item) {
  if (action === "delete") {
    selectedEmpresa.value = item;
    deleteDialog.value = true;
  } else {
    deleteDialog.value = false;
  }
}
function handleDeleteEmpresa(id) {
  console.log(id);
  deleteEmpresa(id);
  deleteDialog.value = false;
}

function handleUpdateEmpresa(updatedEmpresa, id) {
  console.log(updatedEmpresa);
  updateEmpresa(updatedEmpresa, id);
  updateDialog.value = false;
}
</script>

<style scoped>
:deep(.v-table__wrapper > table > tbody > tr > td) {
  max-width: 207px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 15px;
}
.uppercase {
  text-transform: uppercase;
}
.elipses {
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
