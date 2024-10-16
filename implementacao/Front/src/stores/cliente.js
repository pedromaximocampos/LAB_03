import { defineStore } from "pinia";

export const useClienteStore = defineStore("cliente", () => {
  const clientes = ref([]);
  const cliente = ref({});

  return {
    clientes,
    cliente,
  };
});
