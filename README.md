# Sistema de Gerenciamento de Pautas Cooperativas

Uma solução criada utilizando a tecnologia Java em formato de API REST, voltada para atender as demandas das sessões de votação em cooperativas, desde o processo de criação de pautas até a votação destas.

## Visão Geral

A aplicação tem como objetivo disponibilizar endpoints para consulta de informações e operações relacionadas a:

- **Votos de associados em cooperativas**: Cada associado possui um voto e as decisões são tomadas em assembleias por votação.
- **Gerenciamento das sessões de votação**: De acordo com os respectivos requisitos.

### Funcionalidades

1. **Cadastrar uma nova pauta**:
   - Endpoint para registrar uma nova pauta de votação.

2. **Abrir uma sessão de votação em uma pauta**:
   - A sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por padrão.

3. **Receber votos dos associados em pautas**:
   - Os votos são apenas 'Sim'/'Não'.
   - Cada associado é identificado por um ID único e pode votar apenas uma vez por pauta.

4. **Contabilizar os votos e dar o resultado da votação na pauta**:
   - Endpoint para contabilizar os votos e fornecer o resultado da votação.

## Tecnologias Utilizadas

- **Java 8**
- **Spring WebFlux**
- **Spring Boot**
- **MongoDB**
- **Boas práticas de programação utilizando Design Patterns (Builder)**
- **Testes unitários (JUnit, Mockito, WebClient Test)**
- **Gradle como gerenciador de dependências**

## Endpoints

### 1. Cadastrar uma Nova Pauta

**POST** `/pautas`

Registra uma nova pauta de votação.

#### Exemplo de Request:

```json
{
  "titulo": "Nova Pauta",
  "descricao": "Descrição da pauta"
}
```

### 2. Abrir uma Sessão de Votação

**POST** `/pautas/{id}/abrir-sessao`

Abre uma sessão de votação para uma pauta específica.

#### Exemplo de Request:

```json
{
  "duracao": 5  // Duração em minutos
}
```

### 3. Receber Votos dos Associados

**POST** `/pautas/{id}/votar`

Recebe o voto de um associado em uma pauta específica.

#### Exemplo de Request:

```json
{
  "idAssociado": "12345",
  "voto": "Sim"
}
```

### 4. Contabilizar os Votos e Dar o Resultado

**GET** `/pautas/{id}/resultado`

Fornece o resultado da votação de uma pauta específica.

#### Exemplo de Response:

```json
{
  "idPauta": "1",
  "titulo": "Nova Pauta",
  "descricao": "Descrição da pauta",
  "totalVotosSim": 10,
  "totalVotosNao": 5,
  "resultado": "Aprovada"
}
```

