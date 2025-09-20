# Sprint 3 - Challenge: Arquitetura Orientada a Serviços e Web Services

---
## Integrantes

- Aline Fernandes Zeppelini - RM97966
- Camilly Breitbach Ishida - RM551474
- Julia Leite Galvão - RM550201
- Jessica Costacurta - RM99068

---
## Descrição do Projeto

Este projeto é uma aplicação Java 17 desenvolvida com Spring Boot 3 e gerenciada pelo Maven, que implementa um sistema de cadastro de clientes e funcionários, além da emissão e gerenciamento de alertas. O sistema segue a arquitetura em camadas e utiliza o padrão RESTful para exposição de endpoints CRUD.

O objetivo principal é disponibilizar uma plataforma que permita:
- Cadastro e autenticação de clientes e funcionários
- Emissão de alertas conforme o perfil de investidor do cliente
- Armazenamento persistente dessas informações em um banco de dados relacional

---
## Configuração e execução

1. Rodar o projeto a partir da classe Main em alguma IDE de sua escolha
2. Acessar os endpoints pelo navegador ou Postman em `http://localhost:8080`

### Ou

1. Acessar o terminal
2. Entrar na pasta do projeto
3. Rodar com `mvn spring-boot:run`
4. Acessar os endpoints pelo navegador ou Postman em `http://localhost:8080`

---
## Exemplos de requisições e respostas

### 1. Cadastro de Clientes
- **URL:** `POST http://localhost:8080/clientes/cadastro`
- **Body (JSON): Exemplo**
```json
{
"nome": "João Souza",
"email": "joao@email.com",
"senha": "123456",
"perfilInvestidor": "ARROJADO"
}
```

<img width="536" height="461" alt="image" src="https://github.com/user-attachments/assets/e44b9ea1-1b5b-47c0-9d23-8e6b7323f61d" />


### 2. Login de Clientes
- **URL:** `POST http://localhost:8080/clientes/login?email=maria@email.com&senha=123456`
- É preciso colocar o email e a senha que foram cadastradas

<img width="542" height="369" alt="image" src="https://github.com/user-attachments/assets/7c701ef8-7f25-4a72-a466-658e0e7704e8" />

- Caso a senha ou email estejam incorretos, a requisição não retornará uma resposta:
<img width="539" height="358" alt="image" src="https://github.com/user-attachments/assets/1123e8ac-1955-42f8-b894-e1ef29d1b3f9" />


### 3. Listar todos os Clientes
- **URL:** `GET http://localhost:8080/clientes`

<img width="592" height="542" alt="image" src="https://github.com/user-attachments/assets/f6828cc6-f794-4ab8-828b-b537a21c5917" />

- Importante notar que essa reposta não retorna a senha dos clientes, a fim de proteger seus dados


### 4. Enviar um alerta para todos os clientes que tenham determinado perfil
- **URL:** `POST http://localhost:8080/alertas/enviar/MODERADO?funcionarioEmail=func@email.com&mensagem=Oportunidade+de+investimento`

<img width="582" height="366" alt="image" src="https://github.com/user-attachments/assets/897680e9-b468-4470-bcc3-8bc7c8c97d46" />

- Nesse exemplo, um alerta foi enviado para todos os clientes que tenham o perfil MODERADO


### 5. Listar alertas
- **URL:** `GET http://localhost:8080/alertas`

<img width="557" height="482" alt="image" src="https://github.com/user-attachments/assets/3c7b58d4-f708-453d-aaf7-4fb46abe5cf1" />

- Também é possível listar alertas por perfil com: `GET http://localhost:8080/alertas/perfil/{perfil}` ou por email com: `GET http://localhost:8080/alertas/cliente/{email}`


### 6. Cadastro de Funcionários
- **URL:** `POST http://localhost:8080/funcionarios/cadastro`
- **Body (JSON): Exemplo**
```json
{
"nome": "Jessica Costacurta",
"email": "jessica@email.com",
"senha": "98765"
}
```

<img width="550" height="458" alt="image" src="https://github.com/user-attachments/assets/103f3459-1fb3-4956-bb2d-3880b8766de4" />


### 6. Deletar alertas
- **URL:** `DELETE http://localhost:8080/alertas/{id}`

<img width="656" height="453" alt="image" src="https://github.com/user-attachments/assets/67c888ae-a364-4299-9886-75dd542b653f" />

---
## Tecnologias utilizadas

- Java 17

- Maven

- Spring Boot

- Spring MVC (Spring Web)

- Spring WebFlux

- Spring Data JPA

- H2 Database

- Oracle JDBC (ojdbc8)

- Lombok

---
## Diagrama de Arquitetura

<img width="1127" height="526" alt="image" src="https://github.com/user-attachments/assets/254ce937-690d-41bb-8dcf-f1c837d18bc7" />

---
## Diagrama de Entidades

<img width="477" height="370" alt="image" src="https://github.com/user-attachments/assets/02a2cd56-a62d-49f9-8e77-41015b634390" />





