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
        title="Adicionar novo Aluno"
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
                  label="Seu nome"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3>Cpf</h3>
                <v-text-field
                  class="mt-2"
                  v-model="cpf"
                  :rules="regrasCpf"
                  label="CPF (Ex: 123.456.789-10)"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <h3>Email</h3>
                <v-text-field
                  class="mt-2"
                  v-model="email"
                  :rules="regrasEmail"
                  label="Email"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3>RG</h3>
                <v-text-field
                  class="mt-2"
                  v-model="rg"
                  :counter="10"
                  label="RG (Ex: 12.345.678)"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row class="my-3">
              <v-divider></v-divider>
              <v-col>
                <h2 class="my-2">Endereço</h2>
              </v-col>
            </v-row>

            <v-row>
              <v-col>
                <h3 class="my-2">CEP</h3>
                <v-text-field
                  v-model="cep"
                  :count="10"
                  label="CEP (Ex: 12345-678)"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3 class="my-2">Número</h3>
                <v-text-field
                  v-model="numero"
                  :rules="regrasNumero"
                  :counter="5"
                  label="Numero"
                  required
                ></v-text-field>
              </v-col>
              <v-col>
                <h3 class="my-2">Complemento</h3>
                <v-text-field
                  v-model="complemento"
                  :rules="regrasNome"
                  label="Complemento"
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
              Criar Novo Aluno
            </v-btn>
          </div>
        </template>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useAlunoView } from "@/views/alunoView";

const { createNewAluno } = useAlunoView();

const dialog = ref(false);

function ToggleCadastro() {
  dialog.value = !dialog.value;
}
const nome = ref("");
const cpf = ref("");
const rg = ref("");
const email = ref("");

const cep = ref("");
const numero = ref();
const complemento = ref("");

function submitForm() {
  if (valid.value) {
    const newAluno = {
      nome: nome.value,
      cpf: cpf.value,
      rg: rg.value,
      email: email.value,
      idCurso: 1,
      endereco: {
        cep: cep.value,
        numero: parseInt(numero.value),
        complemento: complemento.value,
      },
    };
    console.log(newAluno);
    createNewAluno(newAluno);
    dialog.value = false;
  } else {
    alert("Preencha todos os campos corretamente");
  }
}

const valid = ref(false);

const regrasCpf = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) => {
    const pattern = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    return pattern.test(value) || "CPF inválido. Ex: 123.456.789-10";
  },
];

const regrasNome = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) =>
    (value && value.length <= 10) || "Nome deve ter no máximo 10 caracteres",
];
const regrasNumero = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) =>
    (value && value.length <= 5) || "Numero deve ter no máximo 5 digitos",
];

const regrasEmail = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) => {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return pattern.test(value) || "Email inválido. Ex: exemplo@email.com";
  },
];
</script>

<style setup>
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
