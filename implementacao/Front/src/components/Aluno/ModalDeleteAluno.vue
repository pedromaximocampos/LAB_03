<template>
  <v-card class="modal-dialog">
    <v-card-title>
      <v-icon class="mr-2">mdi-delete</v-icon>
      Tem certeza que quer deletar o aluno {{ nome }}?
    </v-card-title>
    <v-divider></v-divider>

    <div class="car-details mx-2 my-2">
      <v-card class="modal-dialog">
        <v-card-title>
          <h2>Detalhes do Aluno</h2>
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
            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item mr-2">
                  <strong>CPF:</strong> {{ cpf }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item">
                  <strong>Email:</strong> {{ email }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item">
                  <strong>RG:</strong> {{ rg }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item">
                  <strong>CEP:</strong> {{ cep }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item">
                  <strong>Número:</strong> {{ numero }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-item class="py-2">
              <v-list-item-content>
                <v-list-item-title class="list-item">
                  <strong>complemento:</strong> {{ complemento }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card-text>
      </v-card>
    </div>

    <template v-slot:actions>
      <div class="d-flex space-around">
        <v-btn
          outlined
          class="ma-2 text-capitalize cancelBtn"
          @click="ToggleDelete"
          prepend-icon="mdi-cancel"
        >
          Cancelar
        </v-btn>

        <v-btn
          elevated
          class="ma-2 text-capitalize deleteBtn"
          prepend-icon="mdi-delete"
          @click="deleteAluno"
        >
          Deletar
        </v-btn>
      </div>
    </template>
  </v-card>
</template>

<script setup>
import { ref } from "vue";
import { defineProps } from "vue";
import { defineEmits } from "vue";

const props = defineProps({
  alunoToDelete: {
    type: Object,
    required: true,
  },
});
const emit = defineEmits(["toggle-delete", "delete"]);
const id = ref(props.alunoToDelete.id);
const nome = ref(props.alunoToDelete.nome);
const email = ref(props.alunoToDelete.email);
const cpf = ref(props.alunoToDelete.cpf);
const rg = ref(props.alunoToDelete.rg);
const cep = ref(props.alunoToDelete.endereco.cep);
const numero = ref(props.alunoToDelete.endereco.numero);
const complemento = ref(props.alunoToDelete.endereco.complemento);

function ToggleDelete() {
  emit("toggle-delete");
}

function deleteAluno() {
  console.log(id.value);
  emit("delete", id.value);
}
</script>

<style setup>
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
