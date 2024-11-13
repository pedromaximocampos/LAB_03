import { useAlunoStore } from "@/stores/aluno";
import { useDefaultStore } from "@/stores/default";
import axios from "axios";

export function useVantagemView() {
  const vantagemStore = useAlunoStore();
  const isLoading = ref(false);
  const defaultStore = useDefaultStore();

  async function getAllVantagens() {
    axios
      .get(`${defaultStore.apiUrl}/vatangens`)
      .then((response) => {
        vantagemStore.vantagens = response.data;
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  async function createNewVantagem(vantagem) {
    isLoading.value = true;
    axios
      .post(`${defaultStore.apiUrl}/vatangens`, vantagem, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        getAllVantagens();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        isLoading.value = false;
      });
  }

  return {
    vantagemStore,
    isLoading,
    getAllVantagens,
    createNewVantagem,
  };
}
