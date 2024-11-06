<template>
    <div class="container">
      <h2>Enviar Moedas</h2>
      <form @submit.prevent="submitForm">
        <div>
          <label for="idAluno">ID do Aluno:</label>
          <input type="number" v-model="transacao.idAluno" required />
        </div>
        <div>
          <label for="moedas">Quantidade de Moedas:</label>
          <input type="number" v-model="transacao.moedas" min="1" required />
        </div>
        <div>
          <label for="descricao">Descrição:</label>
          <input type="text" v-model="transacao.descricao" required />
        </div>
        <button type="submit">Enviar</button>
      </form>
  
      <button @click="fetchExtrato" class="view-extrato-btn">Visualizar Extrato</button>
  
      <div v-if="extrato" class="extrato-section">
        <h3>Extrato</h3>
        <p>Moedas disponíveis: {{ extrato.moedas }}</p>
        <ul>
          <li v-for="transacao in extrato.transacao" :key="transacao.id">
            <p><strong>ID Transação:</strong> {{ transacao.id }}</p>
            <p><strong>ID Aluno:</strong> {{ transacao.idAluno }}</p>
            <p><strong>Moedas:</strong> {{ transacao.moedas }}</p>
            <p><strong>Descrição:</strong> {{ transacao.descricao }}</p>
            <p><strong>Data:</strong> {{ new Date(transacao.data).toLocaleString() }}</p>
            <hr />
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    props: {
      idProfessor: {
        type: Number,
        required: true
      }
    },
    data() {
      return {
        transacao: {
          idAluno: null,
          moedas: 0,
          descricao: ''
        },
        extrato: null 
      };
    },
    methods: {
      async submitForm() {
        try {
          await axios.post('http://localhost:8080/professores/1/enviar-moedas', this.transacao);
          alert("Transação enviada com sucesso!");
        } catch (error) {
          console.error("Erro ao enviar transação:", error);
          alert("Erro ao enviar transação.");
        }
      },
      async fetchExtrato() {
        try {
          const response = await axios.get(`http://localhost:8080/professores/1/extrato`);
          this.extrato = response.data;
        } catch (error) {
          console.error("Erro ao buscar extrato:", error);
          alert("Erro ao buscar extrato.");
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    text-align: center;
  }
  
  form {
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
  
  button {
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #45a049;
  }
  
  .view-extrato-btn {
    margin-top: 20px;
    padding: 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    cursor: pointer;
  }
  
  .view-extrato-btn:hover {
    background-color: #0056b3;
  }
  
  .extrato-section {
    margin-top: 20px;
    width: 80%;
    max-width: 600px;
    text-align: left;
  }
  
  .extrato-section ul {
    list-style-type: none;
    padding: 0;
  }
  
  .extrato-section li {
    background-color: #f9f9f9;
    padding: 15px;
    margin-bottom: 10px;
    border-radius: 5px;
    border: 1px solid #ddd;
  }
  </style>
  