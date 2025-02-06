# Meli Desafio Backend IT ARC

## Visão Geral

Este projeto é orquestrado usando Docker Compose. Ele possui quatro subprojetos: um banco de dados Postgres, uma API Java Spring, um Worker Java Spring e uma aplicação mock em GO.

## Serviços

### PostgreSQL
- **Imagem**: `postgres:15`
- **Descrição**: Este serviço executa um banco de dados PostgreSQL para armazenar dados de notificações e usuários.

### API
- **Build**: `./desafio-backend-it-arc-api`
- **Descrição**: Este serviço executa a API principal do projeto, que interage com o banco de dados PostgreSQL e a API externa CPTEC.

### Worker
- **Build**: `./desafio-backend-it-arc-worker`
- **Descrição**: Este serviço executa um scheduler que consulta o banco de dados para verificar se há notificações pendentes que devem ser enviadas, chamando a API via HTTP quando necessário.

### Mock
- **Build**: `./desafio-backend-it-arc-mock`
- **Descrição**: Este serviço executa uma aplicação mínima em GO que retorna OK quando recebe um POST, sua funcionalidade é somente mocar uma resposta no fluxo.

## Executando o Projeto

1. **Clone o repositório**:
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Inicie os serviços**:
    ```sh
    docker-compose up -d
    ```

3. **Verifique o status dos serviços**:
    ```sh
    docker-compose ps
    ```

## Inicialização do Banco de Dados

O banco de dados PostgreSQL é inicializado com os seguintes scripts localizados no diretório `./db`:

- `01-create-tables.sql`: Cria as tabelas `notifications` e `users`.
- `02-insert-data.sql`: Insere dados de seed nas tabelas `notifications` e `users`.

## Health Checks

O serviço `postgres` inclui uma verificação de saúde para garantir que o banco de dados esteja pronto antes que outros serviços iniciem.

## Documentação

### API

A API possui uma documentação de endpoints via swagger acessível por: http://localhost:8080/swagger-ui/index.html

### Fluxos

![Fluxos](./imgs/fluxos.png)

## Conclusão

Este projeto demonstra uma arquitetura de múltiplos serviços usando Docker Compose, com foco em interações com banco de dados, processamento em segundo plano e integração com API externa.