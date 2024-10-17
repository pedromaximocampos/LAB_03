import { useEmpresaStore } from "@/stores/empresa"
import { useDefaultStore } from "@/stores/default";
import axios from "axios";
import { tr } from "vuetify/locale";

export function useEmpresaView() {
  const empresaStore = useEmpresaStore();
  const isLoading = ref(false);
  const defaultStore = useDefaultStore()


  async function createNewEmpresa(empresa) {
    isLoading.value = true
    axios.post(defaultStore.apiUrl, empresa, {
      headers: {
        "Content-Type": "application/json"
      }
  
    })
    .then((response) => {
      getAllEmpresas()
    })
    .catch((error)=>{
      console.log(error)
    })
    .finally(
      isLoading.value = false
    )
    
  }


  return{
    empresaStore,
    createNewEmpresa
  }
}
