<template>
  <component :is="layout">
    <RouterView />
  </component>
</template>

<script setup>
import { RouterView } from "vue-router";
import { computed } from "vue";
import { useRoute } from "vue-router";
import DefaultLayout from "./default/DefaultLayout.vue";

const route = useRoute();
const layouts = {
  DefaultLayout,
};

const layout = computed(() => {
  const layoutDaPagina = route.meta.layout;
  return layouts[`${layoutDaPagina}Layout`];
});
</script>
