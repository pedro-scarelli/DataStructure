# Estrutura de Dados

Este repositório contém uma implementação de diversas estruturas de dados e algoritmos em Java, que fiz na matéria de Estrutura de Dados na faculdade. O objetivo é reproduzir e entender as funcionalidades das classes nativas do Java com implementações próprias. Implementando também testes unitários com JUnit para todas as classes.

## Requisitos
- Java 17

## Estruturas de Dados e Algoritmos Implementados

- **Listas**:
  - Lista Encadeada
  - Lista Dupla

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

## Como Visualizar e Testar

Para visualizar e testar as implementações, siga os passos abaixo:

1. **Clone o Repositório**

   Abra um terminal, navegue até a pasta que deseja clonar o projeto, e execute os comandos abaixo para clonar e navegar até o repositório:

   ```bash
   git clone https://github.com/pvscarelli/EstruturaDeDados.git
   cd EstruturaDeDados
   ```

2. **Visualize as classes**
   
   As implementações das classes estão localizadas na pasta src. Você pode explorar as classes e verificar o código.

3. **Testando as classes**

   Os testes unitários estão na pasta tests, lá você pode visualizar e testar os testes um por um e executá-los todos de uma vez rodando o comando:

```bash
javac -d bin src/tests/*.java
```
