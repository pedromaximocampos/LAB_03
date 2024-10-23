import { createRouter, createWebHistory } from "vue-router/auto";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Alunos",
      component: () => import("../views/AlunoView.vue"),
      meta: {
        layout: "Default",
      },
    },
    {
      path: "/empresas",
      name: "Empresas",
      component: () => import("../views/EmpresaView.vue"),
      meta: {
        layout: "Default",
      },
    },
  ],
});

export default router;
