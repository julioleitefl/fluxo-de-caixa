# Fluxo de Caixa
Este projeto fornece um controle de fluxo de caixa com entradas (créditos) e saídas (débitos). Também gera um relatório diário consolidado em PDF.

## Estrutura do Projeto
Abaixo está a estrutura hierárquica das pastas deste projeto:

.
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ └── example
│ │ │ └── fluxocaixa
│ │ │ ├── controller
│ │ │ │ └── FluxoCaixaController.java
│ │ │ ├── model
│ │ │ │ └── Lancamento.java
│ │ │ ├── repository
│ │ │ │ └── LancamentoRepository.java
│ │ │ └── service
│ │ │ ├── FluxoCaixaService.java
│ │ │ └── RelatorioService.java
│ │ └── resources
│ │ └── application.properties
│ └── test
│ └── java
│ └── com
│ └── example
│ └── fluxocaixa
│ └── service
│ ├── FluxoCaixaServiceTest.java
│ └── RelatorioServiceTest.java
├── Dockerfile
├── pom.xml
└── README.md


## Diagrama do Sistema

+------------------+    +-------------------+    +------------------+    +------------------+
| FluxoCaixaController | <-- | FluxoCaixaService  | <-- | LancamentoRepository | <-- |  Database    |
+------------------+    +-------------------+    +------------------+    +------------------+
              |                            |
         +----------+                  +----------------+
         |  Cliente  |                  | RelatorioService |
         +----------+                  +----------------+



## Execução Local
Para rodar o projeto localmente, siga os passos a seguir:

Garanta que você tenha Java 8 e Maven instalados em sua máquina.
Navegue até a pasta raiz do projeto via terminal.
Execute mvn clean install para compilar o projeto e instalar dependências.
Execute mvn spring-boot:run para iniciar o servidor. O servidor irá iniciar na porta 8080.
Acesse http://localhost:8080 em seu navegador ou ferramenta de API.

## Execução com Docker
Para rodar o projeto em um contêiner Docker, siga os passos a seguir:

Garanta que você tenha Docker instalado em sua máquina.
Navegue até a pasta raiz do projeto via terminal.
Construa a imagem Docker com o comando docker build -t fluxocaixa ..
Rode o contêiner Docker com o comando docker run -p 8080:8080 fluxocaixa.
Acesse http://localhost:8080 em seu navegador ou ferramenta de API.

### Gitflow simplificado, apenas para efeito de demonstração 