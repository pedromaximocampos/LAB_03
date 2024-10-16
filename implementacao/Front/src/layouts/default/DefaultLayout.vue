<template>
  <v-layout>
    <Menu></Menu>
    <v-main>
      <slot></slot>
    </v-main>
  </v-layout>
</template>

<script setup>
import Menu from "./components/Menu.vue";
</script>

<style scoped></style>
