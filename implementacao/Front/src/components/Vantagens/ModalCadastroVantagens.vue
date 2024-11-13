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
                <h3>Nome Vantagem</h3>
                <v-text-field
                  class="mt-2"
                  v-model="nome"
                  :counter="10"
                  :rules="regrasNome"
                  label="Razão Social"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3>Descrição Vantagem</h3>
                <v-text-field
                  class="mt-2"
                  v-model="descricao"
                  :counter="20"
                  :rules="regrasNome"
                  label="Descricao"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <h3>Custo em moedas</h3>
                <v-text-field
                  class="mt-2"
                  v-model="moedas"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3>Url Foto</h3>
                <v-text-field
                  class="mt-2"
                  v-model="urlFoto"
                  label="Url da foto"
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
              Criar Vantagem
            </v-btn>
          </div>
        </template>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useVantagemView } from "@/views/vantagensView";

const { createNewVantagem } = useVantagemView();

const dialog = ref(false);

function ToggleCadastro() {
  dialog.value = !dialog.value;
}
const nome = ref("");
const descricao = ref("");
const moedas = ref();
const urlFoto = ref("");
const idEmpresa = 1;

function submitForm() {
  if (valid.value) {
    const newVantagem = {
      nome: nome.value,
      descricao: descricao.value,
      moedas: parseInt(moedas.value),
      foto: urlFoto.value,
      idEmpresa: idEmpresa,
    };
    console.log(newVantagem);
    createNewVantagem(newVantagem);
    dialog.value = false;
  } else {
    alert("Preencha todos os campos corretamente");
  }
}

const valid = ref(false);

const regrasNome = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) =>
    (value && value.length <= 30) ||
    "Nome/Descrição deve ter no máximo 30 caracteres",
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
