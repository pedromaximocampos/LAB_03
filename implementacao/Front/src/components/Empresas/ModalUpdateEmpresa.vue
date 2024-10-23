<template>
  <v-card
    prepend-icon="mdi-pencil-box-outline"
    title="Atualizar Empresa"
    class="modal-dialog"
  >
    <v-divider></v-divider>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col>
            <h3>Nome</h3>
            <v-text-field
              class="mt-2"
              v-model="nome"
              :counter="10"
              :rules="regrasNome"
              label="Nova Razão Social"
              required
            ></v-text-field>
          </v-col>
        </v-row>
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
          class="ma-2 text-capitalize UpdateBtn"
          prepend-icon="mdi-update"
          @click="submitUpdate"
        >
          Atualizar Empresa
        </v-btn>
      </div>
    </template>
  </v-card>
</template>

<script setup>
import { ref } from "vue";

import { defineProps } from "vue";

const props = defineProps({
  empresaToUpdate: {
    type: Object,
    required: true,
  },
});

const nome = ref(props.empresaToUpdate.nome);
const id = ref(props.empresaToUpdate.id);
console.log(id.value);

const emit = defineEmits(["closeModal", "updateEmpresa"]);

function toggleModal() {
  emit("closeModal");
}

function submitUpdate() {
  if (valid.value) {
    console.log(id.value);
    console.log(nome.value);
    const updatedEmpresa = {
      nome: nome.value,
    };
    emit("updateEmpresa", updatedEmpresa, id.value);
  } else {
    alert("Preencha todos os campos corretamente");
  }
}

const valid = ref(false);

const regrasNome = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) =>
    (value && value.length <= 10) || "Nome deve ter no máximo 10 caracteres",
];
</script>

<style scoped>
.cancelBtn {
  background-color: red;
  color: white;
}

.UpdateBtn {
  background-color: purple;
  color: white;
  max-width: 200px;
  min-width: 50px;
}
.modal-dialog {
  background-color: #212121;
  color: #eeeeee;
}
</style>
