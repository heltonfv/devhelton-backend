# Backend of devhelton.com

Este projeto está usando Spring Boot 3.3.2 com Java 17.

1. Antes de iniciar o projeto, execute os testes para confirmar se tudo está certo. Execute `./gradlew test`

2. Se os testes executarem com sucesso, execute `./gradlew build` para buildar o projeto.

3. Copie o arquivo `docker-compose.development.yml` para `docker-compose.yml`.

3. A aplicação está rodando em containeres do Docker, portanto para iniciar a aplicação basta rodar `docker compose up` que as imagens serão baixadas e executadas.

4. Se tudo estiver certo, a aplicação estará disponível em *http://localhost:8080*