import { useEmpresaStore } from "@/stores/empresa";
import { useDefaultStore } from "@/stores/default.js";
import axios from "axios";
import { de } from "vuetify/locale";

export function useEmpresaView() {
  const empresaStore = useEmpresaStore();
  const isLoading = ref(false);
  const defaultStore = useDefaultStore();

  const dataTableHeaders = [
    { title: "", key: "update", sortable: false, align: "start" },
    { title: "Nome", align: "center", key: "nome" },
    { title: "", key: "delete", sortable: false, align: "end" },
  ];

  async function createNewEmpresa(empresa) {
    isLoading.value = true;
    console.log(defaultStore.apiUrl.value);
    axios
      .post(`${defaultStore.apiUrl}/empresas`, empresa, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        getAllEmpresas();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally((isLoading.value = false));
  }

  async function getAllEmpresas() {
    isLoading.value = true;
    axios
      .get(`${defaultStore.apiUrl}/empresas`)
      .then((response) => {
        empresaStore.empresas = response.data.map((empresa) => {
          return {
            id: empresa.id,
            nome: empresa.nome,
          };
        });
        console.log(empresaStore.empresas);
      })
      .catch((error) => {
        console.log(error);
      })
      .finally((isLoading.value = false));
  }

  async function updateEmpresa(empresa, empresa_id) {
    const int_id = parseFloat(empresa_id);

    isLoading.value = true;
    axios
      .put(`${defaultStore.apiUrl}/empresas/${int_id}`, empresa, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        getAllEmpresas();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally((isLoading.value = false));
  }

  async function deleteEmpresa(empresa_id) {
    const int_id = parseFloat(empresa_id);
    console.log(defaultStore.apiUrl);
    isLoading.value = true;
    axios
      .delete(`${defaultStore.apiUrl}/empresas/${int_id}`, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        getAllEmpresas();
      })
      .catch((error) => {
        console.log(error);
      })
      .finally((isLoading.value = false));
  }

  return {
    empresaStore,
    createNewEmpresa,
    dataTableHeaders,
    isLoading,
    updateEmpresa,
    deleteEmpresa,
    getAllEmpresas,
  };
}
