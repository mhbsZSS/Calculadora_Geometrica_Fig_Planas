import java.util.Scanner;
import java.lang.Math;
import java.util.Locale;

public class CalcAreaFigPlana {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(java.util.Locale.US);
    int opcao = 0;

    while (opcao != 8) {
      exibirMenu();
      opcao = scanner.nextInt();
    
      switch (opcao) {
        case 1:
          calculadoraAreaTriangulo(scanner);
          break;
        case 2:
          calculadoraAreaQuadrado(scanner);
          break;
        case 3:
          calculadoraAreaRetangulo(scanner);
          break;
        case 4:
          calculadoraAreaParalelogramo(scanner);
          break;
        case 5:
          calculadoraAreaLosango(scanner);
          break;
        case 6:
          calculadoraAreaTrapezio(scanner);
          break;
        case 7:
          calculadoraAreaCirculo(scanner);
          break;
        case 8:
          System.out.println("Encerrando o programa.");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
      System.out.println("-------------------------------");
    }
    scanner.close();
  }

  public static void exibirMenu() {
    System.out.println("Calculadora de Área de Figuras Planas");
    System.out.println("Escolha uma forma para calcular a área:");
    System.out.println("1. Triângulo");
    System.out.println("2. Quadrado");
    System.out.println("3. Retângulo");
    System.out.println("4. Paralelogramo");
    System.out.println("5. Losango");
    System.out.println("6. Trapézio");
    System.out.println("7. Círculo");
    System.out.println("8. Sair");
    System.out.println("Digite a opção desejada (1 - 8): ");
  }
  public static void calculadoraAreaTriangulo(Scanner scanner) {
    // 1. Pedir e ler o primeiro dado (Base)
    System.out.print("Digite o valor da base: ");
    double base = scanner.nextDouble();

    // 2. Pedir e ler o segundo dado (Altura)
    System.out.print("Digite o valor da altura: ");
    double altura = scanner.nextDouble();

    // 3. Processar (Cálculo)
    double area = (base * altura)/2.0;

    // 4. Saída
    System.out.printf("A área do triângulo (base %.2f x altura %.2f) é: %.2f \n", base, altura, area);
}

public static void calculadoraAreaQuadrado(Scanner scanner) {
    // 1. Pedir e ler a medida do lado
    System.out.print("Digite o valor do lado do quadrado: ");
    double lado = scanner.nextDouble();

    // 3. Processar (Cálculo)
    double area = lado * lado;

    // 4. Saída
    System.out.printf("A área do quadrado (lado %.2f x lado %.2f) é: %.2f \n", lado, lado, area);
}

public static void calculadoraAreaRetangulo(Scanner scanner) {
    // 1. Pedir e ler o primeiro dado (Base)
    System.out.print("Digite o valor da base: ");
    double base = scanner.nextDouble();

    // 2. Pedir e ler o segundo dado (Altura)
    System.out.print("Digite o valor da altura: ");
    double altura = scanner.nextDouble();

    // 3. Processar (Cálculo)
    double area = base * altura;

    // 4. Saída
    System.out.printf("A área do retângulo (base %.2f x altura %.2f) é: %.2f \n", base, altura, area);
}
  
public static void calculadoraAreaParalelogramo(Scanner scanner) {
    // 1. Pedir e ler o primeiro dado (Base)
    System.out.print("Digite o valor da base: ");
    double base = scanner.nextDouble();

    // 2. Pedir e ler o segundo dado (Altura)
    System.out.print("Digite o valor da altura: ");
    double altura = scanner.nextDouble();

    // 3. Processar (Cálculo)
    double area = base * altura;

    // 4. Saída
    System.out.printf("A área do Paralelogramo (base %.2f x altura %.2f) é: %.2f \n", base, altura, area);
}

public static void calculadoraAreaLosango(Scanner scanner) {
    // 1. Pedir para ler a diagonal maior
    System.out.print("Digite o valor da diagonal maior: ");
    double diagonalMaior = scanner.nextDouble();

    // 2. Pedir para ler a diagonal menor
    System.out.print("Digite o valor da diagonal menor: ");
    double diagonalMenor = scanner.nextDouble();

    // 3. Cálculo da área
    double area = (diagonalMaior * diagonalMenor) / 2.0;

    // 4. Saída
    System.out.printf("A área do Losango (diagonal maior %.2f x diagonal menor %.2f) é: %.2f \n", diagonalMaior, diagonalMenor, area);
}

public static void calculadoraAreaTrapezio(Scanner scanner) {
    //1. Pedir para ler a base maior
    System.out.print("Digite o valor da base maior: ");
    double baseMaior = scanner.nextDouble();

    //2. Pedir para ler a base menor
    System.out.print("Digite o valor da base menor: ");
    double baseMenor = scanner.nextDouble();

    //3. Pedir para ler a altura
    System.out.print("Digite o valor da altura: ");
    double altura = scanner.nextDouble();

    //4. Cálculo da área
    double area = ((baseMaior + baseMenor) * altura) / 2.0;

    //Saída
    System.out.printf("A área do Trapézio (base maior %.2f + base menor %.2f) x altura %.2f é: %.2f \n", baseMaior, baseMenor, altura, area);
}

public static void calculadoraAreaCirculo(Scanner scanner) {
    // 1. Pedir para escolher entre raio ou diâmetro
    System.out.print("Você deseja calcular a área usando o raio (r) ou o diâmetro (d)? ");
    String escolha = scanner.next();
    double raio = 0.0;
    double diametro = 0.0;
    if (escolha.equalsIgnoreCase("r")) {
        // 2. Pedir para ler o raio
        System.out.print("Digite o valor do raio: ");
        raio = scanner.nextDouble();
    } else if (escolha.equalsIgnoreCase("d")) {
        // 2. Pedir para ler o diâmetro
        System.out.print("Digite o valor do diâmetro: ");
        diametro = scanner.nextDouble();
        raio = diametro / 2.0;
    } else {
        System.out.println("Opção inválida. Use 'r' para raio ou 'd' para diâmetro.");
        return;
    }

    // 2. Cálculo da área
    double area = Math.PI * raio * raio;

    // 3. Saída
    System.out.printf("A área do Círculo (raio %.2f) é: %.2f \n", raio, area);
}
}