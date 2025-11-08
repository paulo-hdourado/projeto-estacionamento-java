# 🚗 Sistema de Pátio de Estacionamento (Java)

Aplicação de console em Java para gerenciar a entrada e saída de veículos de um pátio de estacionamento, com cálculo de preço baseado no tempo de permanência.

Este projeto foi desenvolvido para praticar a manipulação de dados em memória e o uso de APIs fundamentais do Java.

## 🏛️ Arquitetura e Lógica

O coração do sistema é a classe `Patio`, que atua como um serviço de gerenciamento. Ela utiliza um **`HashMap`** para controlar as vagas ocupadas, onde a **placa do veículo** é a chave e o objeto **`Ticket`** é o valor.

Essa estrutura permite um acesso O(1) (tempo constante) para registrar saídas e verificar duplicatas na entrada, sendo a estrutura de dados ideal para este problema.

## ✨ Funcionalidades (Features)

* **Registrar Entrada:**
    * Cria um novo `Ticket` para um `Veiculo`.
    * Valida se o veículo (placa) já está no pátio para evitar duplicatas.
    * Armazena o `Ticket` no `Map` de vagas ocupadas.
* **Registrar Saída:**
    * Localiza o `Ticket` no `Map` pela placa.
    * Calcula o tempo total de permanência usando `LocalDateTime` e `Duration`.
    * **Regra de Negócio:** O cálculo do preço é feito arredondando as horas *para cima* (`Math.ceil`), como em estacionamentos reais (ex: 1 hora e 15 minutos = 2 horas pagas).
    * Remove o `Ticket` do `Map`, liberando a vaga.

## 🚀 Tecnologias e Conceitos Aplicados

* **Java (JDK 21)**
* **Programação Orientada a Objetos (OOP)**
    * **Composição:** `Patio` gerencia `Ticket`, que "tem-um" `Veiculo`.
    * **Encapsulamento:** A lógica de cálculo e gerenciamento está protegida dentro da classe `Patio`.
* **Collections Framework:**
    * Uso de `HashMap` para gerenciamento de "sessões" ativas com acesso rápido por chave.
* **API de Data/Hora (java.time):**
    * `LocalDateTime` para registrar com precisão a entrada e saída.
    * `Duration` para calcular o tempo exato de permanência.
