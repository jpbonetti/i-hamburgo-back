###IHamburgo-Back

Este projeto consiste em, permitir que uma pessoa, possa efetuar pedidos de lanches e ou customizá-los à sua maneira, ou seja, um cardápio inteligente.

###Regras

O projeto possui todos os serviços, que consultam e gravam no banco de dados.

###Versões

Spring-boot: 2.1.6
Swagger: 2.9.2

###SetUp

Java 8
Gradle
MongoDB

###Comandos necessários

**gradle build install:** Compila o projeto e instala as dependências
**gradle bootrun:** Comando necessário para subir o projeto. O projeto irá subir na porta **3000**, a **URL de acesso é http://localhost:3000**.

###Swagger

O swagger pode ser acessado pela URL **http://localhost:3000/swagger-ui.html#**, ele contém o mapeamento de todos os serviços disponíveis na aplicação.
