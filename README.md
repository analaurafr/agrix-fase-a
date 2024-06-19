# Agrix - Fase A

Este projeto, desenvolvido como parte dos estudos do módulo _Java_ da escola de tecnologia [Trybe](https://www.betrybe.com/), é o ponto de partida para a criação do *sistema Agrix*, um produto da empresa fictícia AgroTech, especializada em tecnologias para melhorar a eficiência no cultivo de plantações. 

## Objetivos do Projeto

1.  **Estruturação de um Projeto em Camadas:** Definir a arquitetura do projeto, organizando-o em camadas bem definidas.
2.  **Implementação de uma API:** Desenvolver uma API RESTful com endpoints para gerenciar e monitorar dados agrícolas.
3.  **Persistência de Dados:** Implementar a persistência de dados utilizando Spring Data.
4.  **Testes Unitários:** Garantir a qualidade do código através de testes unitários.
5.  **Dockerização da Aplicação:** Preparar a aplicação para ser executada em contêineres Docker.

## Funcionalidades da API

A API fornecerá endpoints para gerenciar os seguintes recursos:

-   **Fazendas:** Cadastro, consulta, atualização e remoção de fazendas.
-   **Cultivos:** Cadastro, consulta, atualização e remoção de cultivos associados às fazendas.
-   **Monitoramento:** Registro e consulta de dados de monitoramento das fazendas.

## Tecnologias Utilizadas

1.  **Java 11+**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
2.  **Spring Boot**: Framework para simplificar o desenvolvimento de aplicações Java.
    -   **Spring Data JPA**: Subprojeto do Spring utilizado para a persistência de dados.
    -   **Spring Web**: Módulo do Spring para a criação de APIs RESTful.
3.  **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
4.  **JUnit**: Framework de testes unitários para Java.
5.  **Mockito**: Biblioteca de testes para a criação de mocks em Java.
6.  **Docker**: Plataforma de contêineres utilizada para a dockerização da aplicação.
7.  **MySQL**: Banco de dados utilizado para armazenar os dados persistidos.
8.  **Checkstyle**: Ferramentas de análise estática de código para garantir a qualidade do código.
