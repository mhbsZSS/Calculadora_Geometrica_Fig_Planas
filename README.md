# 📐 Calculadora Geométrica (Java)

> Um projeto evolutivo explorando Lógica de Programação, Estruturas de Controle e Interface Gráfica com Java Swing.

![Status do Projeto](https://img.shields.io/badge/Status-Concluído-brightgreen) ![Java](https://img.shields.io/badge/Java-21%2B-orange)

## 💻 Sobre o Projeto

Este projeto foi desenvolvido como parte dos meus estudos no curso de **Tecnologia em Sistemas Inteligentes (FATEC)**. 

Unindo minha experiência de 14 anos como **Professor de Matemática** com o aprendizado de programação, desenvolvi uma aplicação para cálculos de áreas de figuras planas. O objetivo foi criar uma ferramenta precisa matematicamente e explorar a evolução da interface do usuário, partindo do terminal (CLI) até uma interface gráfica funcional (GUI).

O projeto é dividido em duas versões:
1.  **Versão CLI:** Foco na lógica pura, entrada de dados e estruturas condicionais.
2.  **Versão GUI:** Foco em Experiência do Usuário (UX), Orientação a Objetos e Reutilização de Código.

---

## 🚀 Funcionalidades

A calculadora realiza o cálculo da área das seguintes figuras planas:
* Triângulo
* Quadrado
* Retângulo
* Paralelogramo
* Losango
* Trapézio
* Círculo (Com opção de entrada via Raio ou Diâmetro)

---

## 🛠️ Tecnologias e Conceitos Aplicados

### Versão 1: Terminal (`CalcAreaFigPlana.java`)
* **Scanner & Locale:** Tratamento de entrada de dados e padronização de separadores decimais (ponto flutuante).
* **Estruturas de Controle:** Uso extensivo de `switch/case` para menus e `if/else` para validações.
* **Modularização:** Separação da lógica de cada figura em métodos estáticos (`static void`).

### Versão 2: Interface Gráfica (`CalculadoraVisualCompleta.java`)
* **Java Swing:** Criação de janelas (`JFrame`), painéis, rótulos e botões.
* **Event Listeners:** Programação orientada a eventos (cliques de botão).
* **Interfaces Funcionais & Lambdas:** Uso de expressões lambda para passar fórmulas matemáticas como parâmetro, reduzindo drasticamente a repetição de código.
* **UX (User Experience):**
    * Uso de `JRadioButton` para opções mutuamente exclusivas.
    * Validação de erros (`try-catch`) com janelas de alerta (`JOptionPane`) caso o usuário digite letras em vez de números.
    * Navegação intuitiva com menu principal e janelas independentes (`DISPOSE_ON_CLOSE`).

---

## 📸 Screenshots

![alt text](/CalculadorCLI/img/imageCLI.png)
![alt text](/CalculadorCLI/img/imageGUI.png)
![alt text](/CalculadorCLI/img/areaCirculo.png)
---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos
* Java Development Kit (JDK) instalado (versão 8 ou superior).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/mhbsZSS/Calculadora_Geometrica_Fig_Planas.git
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd Calculadora_Geometrica_Fig_Planas
    ```

3.  **Para rodar a versão Visual (Recomendada):**
    Compile e execute o arquivo da interface completa.
    ```bash
    javac CalculadoraVisualCompleta.java
    java CalculadoraVisualCompleta
    ```

4.  **Para rodar a versão Terminal:**
    ```bash
    javac CalcAreaFigPlana.java
    java CalcAreaFigPlana
    ```

---

## 👨‍🏫 Autor

**Marcio Hernani**
* Professor de Matemática & Estudante de Sistemas Inteligentes
* [[LinkedIn](https://www.linkedin.com/in/marcio-hernani-barbosa-da-silva/)]
* [[GitHub](https://github.com/mhbsZSS/Calculadora_Geometrica_Fig_Planas)]

---

*Desenvolvido com ☕ e lógica matemática.*
