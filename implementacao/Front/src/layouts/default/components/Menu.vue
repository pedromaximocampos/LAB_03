<template>
  <v-navigation-drawer permanent :rail="fechado" width="300" class="background">
    <v-list>
      <v-list-item class="d-flex justify-end">
        <v-btn
          :icon="fechado ? 'mdi-chevron-right' : 'mdi-chevron-left'"
          variant="text"
          @click.stop="fechado = !fechado"
          color="#bdbdbd"
        ></v-btn>
      </v-list-item>
    </v-list>

    <v-divider :thickness="5" color="#bdbdbd"></v-divider>

    <v-list density="compact" nav>
      <v-list-item
        v-for="(item, idx) in menuGeral"
        :key="idx"
        class="rotas-das-paginas"
        :prepend-icon="item.icon"
        :title="item.title"
        :value="item.title"
        @click="irPara(item)"
      ></v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
import { useRouter } from "vue-router";
import { computed } from "vue";
import { ref } from "vue";

const router = useRouter();
const fechado = ref(false);

const menuGeral = ref([
  { icon: "mdi-account", title: "Alunos", link: "/" },
  { icon: "mdi-office-building", title: "Empresas", link: "/empresas" },
]);

function irPara(item) {
  router.push(item.link);
}
</script>

<style scoped>
.caixa-logo {
  margin-top: 20px;
  margin-bottom: 20px;
}

.background {
  background-color: #212121;
  overflow-y: hidden;
}

.rotas-das-paginas {
  color: #bdbdbd;
  font-size: 25px;
  font-weight: bolder;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
