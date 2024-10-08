
# Histórias de Usuário - Sistema de Mérito Estudantil

### História de Usuário 1: Cadastro de Aluno

**Como** um aluno,  
**Eu quero** realizar o meu cadastro no sistema,  
**Para que** eu possa participar do sistema de mérito estudantil.

#### Critérios de Aceite:
- O sistema deve permitir que o aluno cadastre seu nome, email, CPF, RG, endereço, instituição e curso.
- Apenas instituições previamente cadastradas devem ser apresentadas para o aluno selecionar.
- O cadastro só deve ser concluído se todos os campos obrigatórios estiverem preenchidos.
- Após o cadastro, o aluno deve ser capaz de acessar o sistema com seu login e senha.

---

### História de Usuário 2: Cadastro de Professor

**Como** uma instituição parceira,  
**Eu quero** pré-cadastrar meus professores no sistema,  
**Para que** eles possam distribuir moedas aos alunos.

#### Critérios de Aceite:
- O sistema deve permitir que as instituições enviem uma lista com nome, CPF e departamento dos professores.
- Cada professor deve estar vinculado a uma instituição participante.
- Os professores devem receber suas credenciais de login e senha para acessar o sistema.
- Após o login, o professor deve ver seu saldo de moedas disponível e ter a capacidade de distribuir as moedas.

---

### História de Usuário 3: Distribuição de Moedas pelo Professor

**Como** um professor,  
**Eu quero** distribuir moedas aos alunos,  
**Para que** eu possa reconhecer o mérito de seus esforços.

#### Critérios de Aceite:
- O professor deve ser capaz de selecionar um aluno para receber moedas.
- O professor deve indicar o número de moedas a serem enviadas e incluir uma mensagem obrigatória.
- O sistema deve verificar se o professor tem saldo suficiente antes de permitir o envio.
- Após a distribuição, o saldo do professor deve ser atualizado.
- O aluno deve ser notificado por email após receber moedas.

---

### História de Usuário 4: Consulta de Extrato de Moedas (Aluno)

**Como** um aluno,  
**Eu quero** consultar o extrato da minha conta,  
**Para que** eu possa visualizar quantas moedas tenho e quais transações foram realizadas.

#### Critérios de Aceite:
- O sistema deve mostrar o saldo total de moedas do aluno.
- O aluno deve ser capaz de visualizar todas as transações realizadas, incluindo recebimento de moedas e trocas.
- O extrato deve exibir data, valor da transação e descrição (mensagem ou produto resgatado).

---

### História de Usuário 5: Consulta de Extrato de Moedas (Professor)

**Como** um professor,  
**Eu quero** consultar o extrato da minha conta,  
**Para que** eu possa visualizar as moedas enviadas e o saldo restante.

#### Critérios de Aceite:
- O sistema deve mostrar o saldo total de moedas do professor.
- O professor deve ser capaz de visualizar todas as transações realizadas, incluindo o envio de moedas.
- O extrato deve exibir data, valor enviado, nome do aluno e mensagem enviada.

---

### História de Usuário 6: Cadastro de Empresa Parceira

**Como** uma empresa,  
**Eu quero** me cadastrar no sistema,  
**Para que** eu possa oferecer vantagens aos alunos em troca de moedas.

#### Critérios de Aceite:
- A empresa deve fornecer seu nome, email e uma lista de vantagens que deseja oferecer.
- Cada vantagem deve incluir um nome, descrição, foto e custo em moedas.
- A empresa deve receber um login e senha para acessar o sistema.
- A empresa deve poder consultar as trocas realizadas pelos alunos.

---

### História de Usuário 7: Troca de Moedas por Vantagens

**Como** um aluno,  
**Eu quero** trocar minhas moedas por produtos ou descontos oferecidos por empresas parceiras,  
**Para que** eu possa aproveitar as recompensas do sistema.

#### Critérios de Aceite:
- O aluno deve visualizar uma lista de vantagens cadastradas por empresas parceiras, incluindo nome, descrição, foto e custo em moedas.
- O aluno deve ser capaz de selecionar uma vantagem para resgatar, desde que tenha saldo suficiente.
- Após a troca, o saldo do aluno deve ser atualizado.
- Um email de confirmação com um cupom deve ser enviado ao aluno e à empresa parceira.
- O cupom deve conter um código gerado pelo sistema para verificação da troca.

---

### História de Usuário 8: Autenticação no Sistema

**Como** um usuário (aluno, professor ou empresa),  
**Eu quero** realizar login no sistema,  
**Para que** eu possa acessar as funcionalidades de acordo com meu perfil.

#### Critérios de Aceite:
- O sistema deve exigir login e senha para todos os usuários.
- Um processo de autenticação deve validar as credenciais do usuário.
- O acesso deve ser restrito às funcionalidades de acordo com o tipo de usuário (aluno, professor, empresa).
- Após o login, o sistema deve exibir as informações personalizadas para o perfil do usuário.
