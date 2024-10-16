import { useEmpresaStore } from "@/stores/empresa";
import axios from "axios";

export function useEmpresaView() {
  const empresaStore = useEmpresaStore();
  const isLoading = ref(false);
}
