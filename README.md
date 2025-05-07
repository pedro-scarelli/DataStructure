# Estrutura de Dados

Este repositório contém uma implementação de diversas estruturas de dados e algoritmos em Java. O objetivo é reproduzir e entender as funcionalidades das classes nativas do Java com implementações próprias. Implementando também testes unitários com JUnit para todas as classes.

---
## Requisitos

- Java 17
- Maven ( ou Graddle, porém o tutorial a seguir é com Maven)

---

## Conteúdo:

- **Listas**:

  - Lista Encadeada
  - Lista Duplamente Encadeada

- **Pilhas**:

  - Pilha com Lista
  - Pilha com Vetor

- **Filas**:

  - Fila com Lista
  - Fila com Vetor

- **Árvores**:

  - Árvores N-árias
  - Árvores Binárias
  - Busca em Árvores Binárias

- **Tabela de Dispersão (Hash Table)**

- **Algoritmos de Ordenação**:
  - Merge Sort
  - Bubble Sort
  - Quick Sort
---

## Como Visualizar e Testar

Para visualizar e testar as implementações, siga os passos abaixo:

1. **Clone o Repositório**

   Abra um terminal, navegue até a pasta que deseja clonar o projeto, e execute os comandos abaixo para clonar e navegar até o repositório:

   ```bash
   git clone https://github.com/pedro-scarelli/DataStructure.git
   cd DataStructure
   ```

   Agora basta digitar o comando para abrir a pasta atual, que é a raiz do projeto na sua IDE.

2. **Visualize as classes**

   As implementações das classes estão localizadas na pasta "src".

3. **Instalando as dependências**

   Na root do projeto rode o seguinte comando:
   ```bash
   mvn compile
   ```

4. **Testando as classes**

   Implementei bastante testes unitários, e você pode visualizar eles na pasta "tests", lá você pode visualizar e testar os testes um por um e executá-los todos de uma vez rodando o comando:

    ```bash
    mvn test
    ```
