import { useClienteStore } from "@/stores/cliente";
import axios from "axios";

export function useClienteView() {
  const clienteStore = useClienteStore();
  const isLoading = ref(false);
}
