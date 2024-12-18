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
    ,
    {
      path: "/professores",
      name: "Professores",
      component: () => import("../views/ProfessorView.vue"),
      meta: {
        layout: "Default",
      },
    },
    {
      path: "/vantagens",
      name: "Vantagens",
      component: () => import("../views/VantagemView.vue"),
      meta: {
        layout: "Default",
      },
    },
  ],
});

export default router;
