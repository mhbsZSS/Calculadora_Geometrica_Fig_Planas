import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraVisualCompleta {

    public static void main(String[] args) {
        // Boas práticas Swing: Rodar na thread de eventos
        SwingUtilities.invokeLater(() -> criarMenuPrincipal());
    }

    // --- 1. O MENU PRINCIPAL ---
    public static void criarMenuPrincipal() {
        JFrame menu = new JFrame("Calculadora Geométrica - Menu");
        menu.setSize(400, 500);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLayout(new GridLayout(8, 1, 10, 10)); // Layout de Grade (8 linhas, 1 coluna)
        
        // Adicionando um título no topo
        JLabel titulo = new JLabel("Escolha uma forma geométrica:", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        menu.add(titulo);

        // Criando os botões
        adicionarBotao(menu, "1. Triângulo", e -> abrirJanela2Campos("Triângulo", "Base", "Altura", (a, b) -> (a * b) / 2.0));
        adicionarBotao(menu, "2. Quadrado", e -> abrirJanela1Campo("Quadrado", "Lado", (a) -> Math.pow(a, 2)));
        adicionarBotao(menu, "3. Retângulo", e -> abrirJanela2Campos("Retângulo", "Base", "Altura", (a, b) -> a * b));
        adicionarBotao(menu, "4. Paralelogramo", e -> abrirJanela2Campos("Paralelogramo", "Base", "Altura", (a, b) -> a * b));
        adicionarBotao(menu, "5. Losango", e -> abrirJanela2Campos("Losango", "Diag. Maior", "Diag. Menor", (a, b) -> (a * b) / 2.0));
        adicionarBotao(menu, "6. Trapézio", e -> abrirJanelaTrapezio());
        adicionarBotao(menu, "7. Círculo", e -> abrirJanelaCirculo());

        menu.setLocationRelativeTo(null); // Centraliza na tela
        menu.setVisible(true);
    }

    // Método auxiliar para criar botões no menu (reduz repetição)
    private static void adicionarBotao(JFrame frame, String texto, ActionListener acao) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 14));
        botao.addActionListener(acao);
        frame.add(botao);
    }

    // --- 2. JANELA GENÉRICA PARA 1 CAMPO (Ex: Quadrado) ---
    private static void abrirJanela1Campo(String titulo, String label1, Operacao1Campo calculo) {
        JFrame janela = configurarJanela(titulo, 300, 250);

        JTextField campo1 = adicionarCampo(janela, label1, 30);
        JLabel labelResultado = adicionarLabelResultado(janela, 150);

        adicionarBotaoCalcular(janela, 100, e -> {
            try {
                double val1 = lerCampo(campo1);
                double area = calculo.calcular(val1);
                labelResultado.setText(String.format("Área: %.2f", area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Digite apenas números válidos.");
            }
        });
        janela.setVisible(true);
    }

    // --- 3. JANELA GENÉRICA PARA 2 CAMPOS (Ex: Retângulo, Triângulo) ---
    private static void abrirJanela2Campos(String titulo, String label1, String label2, Operacao2Campos calculo) {
        JFrame janela = configurarJanela(titulo, 350, 300);

        JTextField campo1 = adicionarCampo(janela, label1, 30);
        JTextField campo2 = adicionarCampo(janela, label2, 70);
        JLabel labelResultado = adicionarLabelResultado(janela, 180);

        adicionarBotaoCalcular(janela, 130, e -> {
            try {
                double val1 = lerCampo(campo1);
                double val2 = lerCampo(campo2);
                double area = calculo.calcular(val1, val2);
                labelResultado.setText(String.format("Área: %.2f", area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Digite apenas números válidos.");
            }
        });
        janela.setVisible(true);
    }

    // --- 4. JANELA ESPECÍFICA PARA O TRAPÉZIO (3 Campos) ---
    private static void abrirJanelaTrapezio() {
        JFrame janela = configurarJanela("Área do Trapézio", 350, 350);

        JTextField campoBaseMaior = adicionarCampo(janela, "Base Maior", 30);
        JTextField campoBaseMenor = adicionarCampo(janela, "Base Menor", 70);
        JTextField campoAltura = adicionarCampo(janela, "Altura", 110);
        JLabel labelResultado = adicionarLabelResultado(janela, 220);

        adicionarBotaoCalcular(janela, 170, e -> {
            try {
                double B = lerCampo(campoBaseMaior);
                double b = lerCampo(campoBaseMenor);
                double h = lerCampo(campoAltura);
                double area = ((B + b) * h) / 2.0;
                labelResultado.setText(String.format("Área: %.2f", area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Números inválidos.");
            }
        });
        janela.setVisible(true);
    }

    // --- 5. JANELA ESPECÍFICA PARA O CÍRCULO (Com Radio Button) ---
    private static void abrirJanelaCirculo() {
        JFrame janela = configurarJanela("Área do Círculo", 350, 300);

        // Radio Buttons para escolher Raio ou Diâmetro
        JRadioButton rdbRaio = new JRadioButton("Raio", true);
        rdbRaio.setBounds(30, 20, 80, 25);
        JRadioButton rdbDiametro = new JRadioButton("Diâmetro", false);
        rdbDiametro.setBounds(120, 20, 100, 25);
        
        // Agrupar para que apenas um seja selecionado por vez
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbRaio);
        grupo.add(rdbDiametro);

        janela.add(rdbRaio);
        janela.add(rdbDiametro);

        JTextField campoValor = adicionarCampo(janela, "Valor", 60);
        JLabel labelResultado = adicionarLabelResultado(janela, 160);

        adicionarBotaoCalcular(janela, 110, e -> {
            try {
                double valor = lerCampo(campoValor);
                double raio = rdbRaio.isSelected() ? valor : valor / 2.0;
                double area = Math.PI * Math.pow(raio, 2);
                labelResultado.setText(String.format("Área: %.2f", area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Número inválido.");
            }
        });
        janela.setVisible(true);
    }

    // --- MÉTODOS AUXILIARES (A Mágica da Reutilização) ---
    
    // Configura a base da janela (pop-up)
    private static JFrame configurarJanela(String titulo, int w, int h) {
        JFrame janela = new JFrame(titulo);
        janela.setSize(w, h);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null); // Centraliza
        // Não fecha o programa todo, apenas a janelinha (DISPOSE)
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        return janela;
    }

    // Adiciona um campo de texto com rótulo
    private static JTextField adicionarCampo(JFrame frame, String label, int y) {
        JLabel lbl = new JLabel(label + ":");
        lbl.setBounds(30, y, 100, 25);
        frame.add(lbl);

        JTextField txt = new JTextField();
        txt.setBounds(140, y, 150, 25);
        frame.add(txt);
        return txt;
    }

    // Adiciona o botão de calcular
    private static void adicionarBotaoCalcular(JFrame frame, int y, ActionListener acao) {
        JButton btn = new JButton("Calcular");
        btn.setBounds(100, y, 140, 30);
        btn.setBackground(new Color(70, 130, 180)); // Um azul bonito
        btn.setForeground(Color.WHITE);
        btn.addActionListener(acao);
        frame.add(btn);
    }

    // Adiciona o label onde aparece o resultado
    private static JLabel adicionarLabelResultado(JFrame frame, int y) {
        JLabel lbl = new JLabel("Resultado: Aguardando...");
        lbl.setBounds(30, y, 300, 25);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setForeground(new Color(0, 100, 0)); // Verde escuro
        frame.add(lbl);
        return lbl;
    }

    // Lê e trata o texto (troca vírgula por ponto)
    private static double lerCampo(JTextField campo) {
        return Double.parseDouble(campo.getText().replace(",", "."));
    }

    // --- INTERFACES FUNCIONAIS (Para passar a fórmula como parâmetro) ---
    interface Operacao1Campo { double calcular(double a); }
    interface Operacao2Campos { double calcular(double a, double b); }
}
