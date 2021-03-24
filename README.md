## SISTEMA DE GERENCIAMENO DE PAUTAS COOPERATIVAS


Uma solução criada, utilizando a tecnologia Java em formato de API REST. Voltada para atender as demandas as sessões de votação em cooperativas, desde o processo de criação de pautas e votação destas.

**Visão Geral
**: A aplicaçao tem como objetivo disponibilizar endpoints para consulta de informações e operações à respeito de:

- Votos de associados em cooperativas, onde cada associado possui um voto e as decisões são tomadas em assembleias, por votação. 
- Gerenciar as sessões de votação de acordo com os respectivos requisitos:

- Cadastrar uma nova pauta;
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default);

- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);

- Contabilizar os votos e dar o resultado da votação na pauta.

**Tecnologias utilizadas:**
- Java 8 
- Spring WebFlux
- Springboot
- MongoDB
- Boas práticas de programação, utilizando Design Patterns (Builder);
- Testes unitários (junit, mockito, webclient test);
- Gradle como gerenciador de dependências

Como testar?
- Aplicação no heroku, para testar só clicar [aqui](https://pauta-votacao.herokuapp.com/ "aqui");
