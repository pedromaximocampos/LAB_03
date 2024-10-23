<template>
  <v-card
    prepend-icon="mdi-delete"
    title="Deletar Material"
    class="modal-dialog"
  >
    <v-divider></v-divider>
    <v-form v-model="valid">
      <v-container>
        <v-card-title>
          <h2>Detalhes da Empresa</h2>
        </v-card-title>
        <v-card-text>
          <v-list class="modal-dialog">
            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item mr-2">
                  <strong>Nome:</strong> {{ nome }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card-text>
      </v-container>
    </v-form>
    <template v-slot:actions>
      <div class="d-flex justify-end">
        <v-btn
          elevated
          class="ma-2 text-capitalize cancelBtn"
          prepend-icon="mdi-cancel"
          @click="toggleModal"
        >
          Cancelar
        </v-btn>

        <v-btn
          elevated
          class="ma-2 text-capitalize deleteBtn"
          prepend-icon="mdi-delete"
          @click="submitDelete"
        >
          Deletar Empresa
        </v-btn>
      </div>
    </template>
  </v-card>
</template>
<script setup>
import { ref, defineProps, defineEmits } from "vue";

const props = defineProps({
  empresaToDelete: {
    type: Object,
    required: true,
  },
});

const emit = defineEmits(["closeModal", "deleteEmpresa"]);

const id = ref(props.empresaToDelete.id);
const nome = ref(props.empresaToDelete.nome);

function toggleModal() {
  emit("closeModal");
}

function submitDelete() {
  emit("deleteEmpresa", id.value);
}
</script>

<style scoped>
.deleteBtn {
  background-color: red;
  color: white;
  max-width: 150px;
  min-width: 50px;
}
.cancelBtn {
  background-color: grey;
  color: white;
  max-width: 150px;
  min-width: 50px;
}
.modal-dialog {
  background-color: #212121;
  color: #eeeeee;
}
.list-item {
  font-size: 18px;
}
</style>
