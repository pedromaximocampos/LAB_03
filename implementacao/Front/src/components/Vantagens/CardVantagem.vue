<template>
  <v-card variant="tonal" class="mt-3">
    <v-row class="mecanico px-5 py-2">
      <v-col cols="4" class="d-flex justify-center align-center">
        <v-img
          :src="props.vantagem.foto"
          :width="200"
          :height="200"
          fit
        ></v-img>
      </v-col>
      <v-col cols="8">
        <h3 class="my-2"><strong>Nome:</strong></h3>
        <p>{{ props.vantagem.nome }}</p>
        <h4 class="my-2">
          <strong>Descricao:</strong>
        </h4>
        <p>{{ props.vantagem.descricao }}</p>
        <h4 class="my-2">
          <strong>Custo Moedas:</strong> {{ props.vantagem.moedas }}
        </h4>
        <v-btn color="primary" class="mt-2" @click="toggleResgate"
          >Resgatar</v-btn
        >
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
                    <h3>Email aluno</h3>
                    <v-text-field
                      class="mt-2"
                      v-model="email"
                      :counter="20"
                      label="Email aluno"
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
                  @click="toggleResgate"
                >
                  Cancelar
                </v-btn>

                <v-btn
                  elevated
                  class="ma-2 text-capitalize submitBtn"
                  prepend-icon="mdi-plus"
                  @click="resgatar"
                >
                  Resgatar Vantagem
                </v-btn>
              </div>
            </template>
          </v-card>
        </v-dialog>
      </v-col>
    </v-row>
  </v-card>
</template>

<script setup>
import { defineProps } from "vue";
import { useVantagemView } from "@/views/vantagensView";

const { resgatarVantagem } = useVantagemView();

const dialog = ref(false);

const props = defineProps({
  vantagem: {
    type: Object,
    required: true,
  },
});

function toggleResgate() {
  dialog.value = !dialog.value;
}
const email = ref("");

function resgatar() {
  console.log(email.value);
  console.log(props.vantagem.id);

  resgatarVantagem(email.value, props.vantagem.id);
  dialog.value = false;
}

console.log(props.vantagem);
</script>

<style scoped>
.mecanico {
  height: 250px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
