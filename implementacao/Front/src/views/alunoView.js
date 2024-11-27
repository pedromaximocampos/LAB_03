import { useAlunoStore } from "@/stores/aluno";
import { useDefaultStore } from "@/stores/default";
import axios from "axios";

export function useAlunoView() {
  const alunoStore = useAlunoStore();
  const defaultStore = useDefaultStore();
  const isLoading = ref(false);

  const dataTableHeaders = [
    { title: "Nome", align: "start", key: "nome" },
    { title: "Email", align: "center", key: "email" },
    { title: "CPF", align: "center", key: "cpf" },
    { title: "RG", align: "center", key: "rg" },
    { title: "CEP", align: "center", key: "cep" },
    { title: "Numero", align: "center", key: "numero" },
    { title: "Complemento", align: "center", key: "complemento" },
    { title: "Extrato", key: "extrato", sortable: false, align: "center" },
    { title: "", key: "update", sortable: false, align: "center" },
    { title: "", key: "delete", sortable: false, align: "end" },
  ];

  

  async function createNewAluno(aluno) {
    isLoading.value = true;
    console.log(aluno);

    axios
      .post(`${defaultStore.apiUrl}/alunos`, aluno)
      .then((response) => {
        getAllAlunos();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  async function getAllAlunos() {
    isLoading.value = true;

    axios
      .get(`${defaultStore.apiUrl}/alunos`)
      .then((response) => {
        alunoStore.alunos = response.data;
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  async function updateAluno(aluno, aluno_id) {
    const int_id = parseFloat(aluno_id);

    isLoading.value = true;

    axios
      .put(`${defaultStore.apiUrl}/alunos/${int_id}`, aluno)
      .then((response) => {
        getAllAlunos();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  async function deleteAluno(aluno_id) {
    const int_id = parseFloat(aluno_id);

    isLoading.value = true;

    axios
      .delete(`${defaultStore.apiUrl}/alunos/${int_id}`)
      .then((response) => {
        getAllAlunos();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  return {
    alunoStore,
    isLoading,
    dataTableHeaders,
    createNewAluno,
    getAllAlunos,
    deleteAluno,
    updateAluno,
  };
}
