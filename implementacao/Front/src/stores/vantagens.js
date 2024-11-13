import { defineStore } from "pinia";

export const useVantagenStore = defineStore("vantagem", () => {
  const vantagens = ref([]);
  const vantagem = ref({});

  return {
    vantagens,
    vantagem,
  };
});
