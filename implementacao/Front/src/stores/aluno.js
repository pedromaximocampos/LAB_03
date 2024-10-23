import { defineStore } from "pinia";

export const useAlunoStore = defineStore("aluno", () => {
  const alunos = ref([]);
  const aluno = ref({});

  return {
    alunos,
    aluno,
  };
});
