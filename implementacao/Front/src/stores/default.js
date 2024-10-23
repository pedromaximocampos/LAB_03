import { defineStore } from "pinia";

export const useDefaultStore = defineStore("default", () => {
  const apiUrl = ref("http://localhost:8080");

  return {
    apiUrl,
  };
});
