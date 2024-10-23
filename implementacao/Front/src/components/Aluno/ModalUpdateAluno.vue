<template>
  <v-card
    prepend-icon="mdi-plus"
    title="Atualizar novo Aluno"
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
              :counter="20"
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
              :rules="regrasCep"
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
          @click="toggleModal"
        >
          Cancelar
        </v-btn>

        <v-btn
          elevated
          class="ma-2 text-capitalize UpdateBtn"
          prepend-icon="mdi-plus"
          @click="submitForm"
        >
          Atualizar Aluno
        </v-btn>
      </div>
    </template>
  </v-card>
</template>

<script setup>
import { ref } from "vue";

const props = defineProps({
  alunoToUpdate: {
    type: Object,
    required: true,
  },
});

const valid = ref(false);
const nome = ref(props.alunoToUpdate.nome);
const cpf = ref(props.alunoToUpdate.cpf);
const rg = ref(props.alunoToUpdate.rg);
const email = ref(props.alunoToUpdate.email);
const id = ref(props.alunoToUpdate.id);
const cep = ref(props.alunoToUpdate.endereco.cep);
const numero = ref(props.alunoToUpdate.endereco.numero.toString());
const complemento = ref(props.alunoToUpdate.endereco.complemento);

const emit = defineEmits(["closeModal", "updateAluno"]);

function submitForm() {
  if (valid.value) {
    const updatedAluno = {
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
    emit("updateAluno", updatedAluno, id.value);
  } else {
    alert("Preencha todos os campos corretamente");
  }
}

function toggleModal() {
  emit("closeModal");
}

const regrasCpf = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) => {
    const pattern = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    return pattern.test(value) || "CPF inválido. Ex: 123.456.789-10";
  },
];

const regrasCep = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) => {
    const pattern = /^\d{5}-\d{3}$/;
    return pattern.test(value) || "CEP inválido. Ex: 12345-678";
  },
];

const regrasNome = [
  (value) => !!value || "Preenchimento obrigatório.",
  (value) =>
    (value && value.length <= 20) || "Nome deve ter no máximo 10 caracteres",
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
