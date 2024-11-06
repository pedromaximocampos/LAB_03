<template>
  <v-data-table
    class="mt-4 py-3 px-4 table-background"
    fixed-header
    :items-per-page="-1"
    :headers="props.headers"
    :items="props.alunos"
    no-data-text="Sem Dados"
    loading-text="Carregando dados..."
    hide-default-footer
    :loading="props.isLoading"
  >
  
    <template v-slot:[`item.nome`]="{ item }">
      <span class="uppercase">{{ item.nome }}</span>
    </template>
    <template v-slot:[`item.email`]="{ item }">
      <span class="uppercase">{{ item.email }}</span>
    </template>
    <template v-slot:[`item.rg`]="{ item }">
      <span class="uppercase">{{ item.rg }}</span>
    </template>
    <template v-slot:[`item.cpf`]="{ item }">
      <span class="uppercase">{{ item.cpf }}</span>
    </template>
    <template v-slot:[`item.cep`]="{ item }">
      <span>{{ item.endereco.cep }}</span>
    </template>
    <template v-slot:[`item.numero`]="{ item }">
      <span>{{ item.endereco.numero }}</span>
    </template>
    <template v-slot:[`item.complemento`]="{ item }">
      <span>{{ item.endereco.complemento }}</span>
    </template>
    <template v-slot:[`item.extrato`]="{ item }">
  <v-btn @Click="handleExtratoModal" color="primary">Extrato</v-btn>
    </template>
     <template v-slot:[`item.update`]="{ item }">
      <v-icon
        icon="mdi-pencil-box-outline"
        @Click="toggleUpdate('update', item)"
        :disabled="props.isLoading"
      >
      </v-icon>
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
    <ModalUpdateAluno
      :alunoToUpdate="selectedAluno"
      @closeModal="toggleUpdate"
      @updateAluno="handleUpdateAluno"
    ></ModalUpdateAluno>
  </v-dialog>

  <v-dialog v-model="deleteDialog" max-width="700" max-height="800">
    <ModalDeleteAluno
      :alunoToDelete="selectedAluno"
      @toggle-delete="toggleDelete"
      @delete="handleDeleteAluno"
    ></ModalDeleteAluno>
  </v-dialog>
</template>

<script setup>
import ModalUpdateAluno from "./ModalUpdateAluno.vue";
import ModalDeleteAluno from "./ModalDeleteAluno.vue";
import { ref } from "vue";
import { useAlunoView } from "@/views/alunoView";

const selectedAluno = ref(null);
const props = defineProps({
  headers: {
    type: Array,
    required: true,
  },
  alunos: {
    type: Array,
    required: true,
  },
  isLoading: {
    type: Boolean,
    required: true,
  },
});

const { deleteAluno, updateAluno, openExtratoModal } = useAlunoView();

const updateDialog = ref(false);
const deleteDialog = ref(false);

function toggleUpdate(action, item) {
  if (action === "update") {
    selectedAluno.value = item;
    updateDialog.value = true;
  } else {
    updateDialog.value = false;
  }
}

function toggleDelete(action, item) {
  if (action === "delete") {
    selectedAluno.value = item;
    console.log(selectedAluno.value);
    deleteDialog.value = true;
  } else {
    deleteDialog.value = false;
  }
}
function handleDeleteAluno(id) {
  console.log(id);
  deleteAluno(id);
  deleteDialog.value = false;
}

function handleUpdateAluno(updatedAluno, id) {
  console.log(id);
  updateAluno(updatedAluno, id);
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
