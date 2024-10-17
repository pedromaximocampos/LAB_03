<template>
<div class="container">
    <h1>Empresas</h1>
    <h3>Cadastro Empresas</h3>
    <v-sheet class="mx-auto" max-width="300">
    <v-form  v-model="valid">
      <v-text-field
        v-model="userName"
        :rules="rules"
        label="User name"
      ></v-text-field>

      <v-btn
        :loading="loading"
        class="mt-2"
        @click="SubmitForms"
        text="Submit"
        block
      ></v-btn>
      
    </v-form>

    <v-row v-if="!isLoading"></v-row>
    <v-row v-else></v-row>
  </v-sheet>
</div>
</template>

<script setup>
import { useEmpresaView } from './empresaView';
const userName = ref('')
const valid = ref(false)
const loading = ref(false)

const { createNewEmpresa, isLoading } = useEmpresaView()
const rules = [
    (value) => !!value || "preenchimento obrigatorio",
]

function SubmitForms(){
    if(valid.value){
        const newUser = {
            name: userName.value
        }
        createNewEmpresa(newUser)
    }else{
        window.alert("campos invalidos")
    }
}
</script>

<style scoped>
.container{
    padding: 10px;
}
</style>
