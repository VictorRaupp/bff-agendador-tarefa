# 🚀 BFF - Agendador de Tarefas

Backend for Frontend (BFF) responsável por centralizar as requisições da aplicação e realizar a comunicação entre o cliente e os microsserviços que compõem o sistema de agendamento de tarefas.

O BFF atua como uma camada intermediária entre o cliente e os demais serviços, facilitando o acesso às funcionalidades de usuários e tarefas e centralizando a comunicação e autenticação da aplicação.

---

## 📌 Sobre o projeto

Este projeto faz parte de uma arquitetura de microsserviços desenvolvida para um sistema de gerenciamento e agendamento de tarefas.

A aplicação é dividida em serviços independentes, cada um responsável por uma parte específica do sistema.

O BFF funciona como ponto de entrada para o cliente, recebendo as requisições e realizando a comunicação necessária com os microsserviços.

### Arquitetura

```text
                         ┌─────────────────┐
                         │     Cliente     │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │       BFF       │
                         │      :8084      │
                         └────────┬────────┘
                                  │
                    ┌─────────────┴─────────────┐
                    │                           │
                    ▼                           ▼
             ┌──────────────┐           ┌──────────────┐
             │    Usuário   │           │   Tarefas    │
             │     :8080    │           │     :8081    │
             └──────────────┘           └──────────────┘
                    │                           │
                    ▼                           ▼
               PostgreSQL                    MongoDB
```

O serviço de notificação também faz parte da arquitetura geral do sistema e é responsável pelo envio das notificações relacionadas às tarefas.

---

## 🎯 Responsabilidade do BFF

O BFF foi desenvolvido para:

- Centralizar as requisições realizadas pelo cliente.
- Servir como ponto de entrada da aplicação.
- Realizar a comunicação com os microsserviços.
- Encaminhar requisições para o serviço de usuários.
- Encaminhar requisições para o serviço de tarefas.
- Trabalhar com autenticação baseada em JWT.
- Facilitar a comunicação entre o cliente e os serviços internos.
- Abstrair do cliente a comunicação direta com cada microsserviço.

---

## 🔐 Autenticação

A aplicação utiliza **JWT (JSON Web Token)** para autenticação.

O fluxo básico de autenticação ocorre da seguinte forma:

```text
Cliente
   │
   │ Login
   ▼
 BFF
   │
   │ Requisição de autenticação
   ▼
Usuário
   │
   │ JWT
   ▼
 BFF
   │
   │ Requisição autenticada
   ▼
Microsserviço de Tarefas
```

Nas requisições autenticadas, o token é enviado através do cabeçalho HTTP:

```http
Authorization: Bearer <token>
```

O BFF utiliza o token para realizar as requisições autenticadas aos serviços que fazem parte da arquitetura.

---

## 🔄 Comunicação entre microsserviços

O BFF utiliza comunicação através de APIs REST para realizar as operações necessárias nos serviços internos.

A integração entre os serviços utiliza **OpenFeign**, facilitando a realização das chamadas HTTP.

Fluxo simplificado:

```text
Cliente
   │
   ▼
 BFF
   │
   ├──────────────► Usuário
   │
   └──────────────► Tarefas
```

Dessa forma, o cliente não precisa conhecer diretamente os endereços e detalhes de implementação dos microsserviços internos.

---

## 🧩 Microsserviços relacionados

### 👤 Microsserviço de Usuários

Responsável pelo gerenciamento dos usuários e pela autenticação da aplicação.

**Porta:** `8080`

Principais responsabilidades:

- Cadastro de usuários
- Login
- Autenticação
- Geração de JWT
- Gerenciamento de usuários

---

### 📋 Microsserviço de Tarefas

Responsável pelo gerenciamento e agendamento das tarefas.

**Porta:** `8081`

Principais responsabilidades:

- Criação de tarefas
- Consulta de tarefas
- Alteração de tarefas
- Exclusão de tarefas
- Gerenciamento do status das tarefas
- Agendamento de tarefas

---

### 📧 Microsserviço de Notificação

Responsável pelo processamento e envio das notificações relacionadas às tarefas.

**Porta:** `8082`

Principais responsabilidades:

- Receber informações relacionadas às tarefas
- Processar notificações
- Enviar notificações por e-mail

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Security
- JWT
- OpenFeign
- APIs REST
- Gradle
- Arquitetura de Microsserviços

---

## ⚙️ Configuração

As configurações da aplicação devem ser definidas através de variáveis de ambiente.

Exemplo:

```env
SERVER_PORT=8084
USUARIO_URL=http://localhost:8080
TAREFAS_URL=http://localhost:8081
NOTIFICACAO_URL=http://localhost:8082
JWT_SECRET=sua_chave_jwt_aqui
```

> ⚠️ Nunca coloque senhas, tokens ou outras credenciais reais diretamente no código ou no repositório.

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/VictorRaupp/bff-agendador-tarefa.git
```

### 2. Acesse o projeto

```bash
cd bff-agendador-tarefa
```

### 3. Configure as variáveis de ambiente

Configure as variáveis necessárias para que o BFF consiga se comunicar com os microsserviços.

Exemplo:

```env
SERVER_PORT=8084
USUARIO_URL=http://localhost:8080
TAREFAS_URL=http://localhost:8081
NOTIFICACAO_URL=http://localhost:8082
JWT_SECRET=sua_chave_jwt_aqui
```

### 4. Execute a aplicação

No Windows:

```powershell
.\gradlew bootRun
```

Ou compile o projeto:

```powershell
.\gradlew build
```

Depois execute o arquivo JAR:

```powershell
java -jar build/libs/*.jar
```

---

## 🌐 Porta da aplicação

O BFF utiliza a porta:

```text
8084
```

URL local:

```text
http://localhost:8084
```

---

## 🧪 Testes

Para executar os testes automatizados:

```powershell
.\gradlew test
```

Para executar uma compilação completa:

```powershell
.\gradlew clean build
```

---

## 📚 Objetivos do projeto

O projeto foi desenvolvido com o objetivo de praticar e demonstrar conhecimentos em desenvolvimento Backend e arquitetura de microsserviços.

Entre os principais conceitos utilizados estão:

- Desenvolvimento Backend com Java
- Programação Orientada a Objetos
- Spring Boot
- APIs REST
- Spring Security
- Autenticação com JWT
- Comunicação entre microsserviços
- OpenFeign
- Integração de sistemas
- Gradle
- Testes automatizados
- Git e GitHub

---

## 🏗️ Arquitetura completa do sistema

O BFF faz parte do sistema **Agendador de Tarefas - Arquitetura de Microsserviços**.

A estrutura geral do projeto é composta pelos seguintes serviços:

```text
                         ┌─────────────────┐
                         │     Cliente     │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │       BFF       │
                         │      :8084      │
                         └────────┬────────┘
                                  │
                  ┌───────────────┼───────────────┐
                  │               │               │
                  ▼               ▼               ▼
           ┌────────────┐  ┌────────────┐  ┌──────────────┐
           │   Usuário  │  │  Tarefas   │  │ Notificação  │
           │    :8080   │  │    :8081   │  │    :8082     │
           └──────┬─────┘  └──────┬─────┘  └──────────────┘
                  │               │               │
                  ▼               ▼               ▼
             PostgreSQL        MongoDB         E-mail
```

### Fluxo principal

```text
1. Cliente realiza login
        ↓
2. BFF encaminha a requisição para o serviço de Usuário
        ↓
3. Serviço de Usuário autentica o usuário
        ↓
4. JWT é retornado
        ↓
5. Cliente realiza uma requisição autenticada
        ↓
6. BFF recebe a requisição
        ↓
7. BFF encaminha a operação para o serviço responsável
        ↓
8. Microsserviço de Tarefas processa o agendamento
        ↓
9. Microsserviço de Notificação realiza o envio da notificação
```

---

## 🔗 Repositórios do projeto

O BFF faz parte de um projeto maior desenvolvido utilizando arquitetura de microsserviços.

### BFF

```text
https://github.com/VictorRaupp/bff-agendador-tarefa
```

Responsável por centralizar as requisições do cliente e realizar a integração com os microsserviços.

### Usuário

```text
https://github.com/VictorRaupp/usuario
```

Responsável pelo gerenciamento dos usuários e autenticação.

### Tarefas

```text
https://github.com/VictorRaupp/agendador-tarefas
```

Responsável pelo gerenciamento e agendamento das tarefas.

### Notificação

```text
https://github.com/VictorRaupp/notificacao
```

Responsável pelo envio das notificações relacionadas às tarefas.

---

## 👨‍💻 Autor

**Victor Raupp**

Estudante de Engenharia de Software e desenvolvedor em formação com foco em Backend.

### Conhecimentos

- Java
- Spring Boot
- Spring Security
- JWT
- APIs REST
- OpenFeign
- SQL
- Banco de dados
- Microsserviços
- Desenvolvimento Backend
- Git e GitHub
