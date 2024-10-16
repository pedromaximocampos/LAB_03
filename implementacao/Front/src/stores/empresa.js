import { defineStore } from "pinia";

export const useEmpresaStore = defineStore("empresa", () => {
  const empresas = ref([]);
  const empresa = ref({});

  return {
    empresas,
    empresa,
  };
});
