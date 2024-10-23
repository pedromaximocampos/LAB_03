<template>
  <div class="text-center">
    <v-btn
      @click="ToggleCadastro"
      outlined
      color="green"
      class="text-capitalize"
      width="150"
      prepend-icon="mdi-plus"
    >
      Cadastrar
    </v-btn>

    <v-dialog v-model="dialog" max-width="1000" max-height="1000">
      <v-card
        prepend-icon="mdi-plus"
        title="Adicionar nova Empresa"
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
                  label="Razão Social"
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
              @click="ToggleCadastro"
            >
              Cancelar
            </v-btn>

            <v-btn
              elevated
              class="ma-2 text-capitalize submitBtn"
              prepend-icon="mdi-plus"
              @click="submitForm"
            >
              Criar Empresa
            </v-btn>
          </div>
        </template>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useEmpresaView } from "@/views/empresaView";

const { createNewEmpresa } = useEmpresaView();

const dialog = ref(false);

function ToggleCadastro() {
  dialog.value = !dialog.value;
}
const nome = ref("");

function submitForm() {
  if (valid.value) {
    const newEmpresa = {
      nome: nome.value,
    };
    console.log(newEmpresa);
    createNewEmpresa(newEmpresa);
    dialog.value = false;
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
<style>
.cancelBtn {
  background-color: grey;
  color: white;
  max-width: 150px;
  min-width: 50px;
}
.submitBtn {
  background-color: green;

  color: white;
}
.modal-dialog {
  background-color: #212121;
  color: #eeeeee;
}
</style>
