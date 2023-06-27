import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogador extends Tela implements ActionListener {

    private ImageIcon fundo = new ImageIcon("Projeto de MC/src/imagens/HearthstonePlayerBackground.jpg");
    private ImageIcon imagemBotaoDeck = new ImageIcon("Projeto de MC/src/imagens/BotaoEscolher.png");
    private ImageIcon imagemBotaoFinalizarDeck = new ImageIcon("Projeto de MC/src/imagens/BotaoFinalizar.png");
    private JLayeredPane painelTela = new JLayeredPane();
    private JLabel labelBackground = new JLabel();
    private JLabel labelNomeDeck = new JLabel();
    private JTextField textNomeDeck = new JTextField(50);
    private JButton botaoDeck = new JButton(imagemBotaoDeck);
    private JButton botaoFinalizarDeck = new JButton(imagemBotaoFinalizarDeck);
    private int contador = 0;
    public String nomeJogador1;
    public String nomeJogador2;

    private CriadorDecks criadorDecks;
    private Carta cartaEmUso;
    private Deck deckEmEdicao;
    private DefaultListModel<String> cartaListModel;

    public TelaJogador(CriadorDecks criadorDecks) {

        // Organizando a tela
        super();

        this.criadorDecks = criadorDecks;
        this.cartaListModel = new DefaultListModel<>();
        this.deckEmEdicao = new Deck("");

        // Label fundo
        labelBackground.setIcon(fundo);
        labelBackground.setBounds(0, 0, 800, 500);
        painelTela.add(labelBackground, Integer.valueOf(0));

        // Label nome jogador
        labelNomeDeck.setLocation(60, 120);
        labelNomeDeck.setSize(660, 60);
        labelNomeDeck.setOpaque(true);
        labelNomeDeck.setBackground(new Color(0x4A3157));
        labelNomeDeck.setText(" Nome do  Deck:");
        labelNomeDeck.setForeground(new Color(0xFFFFFF));
        labelNomeDeck.setFont(new Font("Calibri Light", Font.BOLD, 30));

        // TexField nome deck
        textNomeDeck.setBounds(360, 137, 330, 25);

        // Botao Deck
        botaoDeck.setFocusable(false);
        botaoDeck.setBounds(270, 250, 250, 40);
        botaoDeck.addActionListener(this);

        // Botao Deck
        botaoFinalizarDeck.setFocusable(false);
        botaoFinalizarDeck.setBounds(270, 300, 250, 40);
        botaoFinalizarDeck.addActionListener(this);

        // Organizando a Painel
        painelTela.setPreferredSize(new Dimension(800, 500));
        painelTela.add(labelNomeDeck, Integer.valueOf(1));
        painelTela.add(textNomeDeck, Integer.valueOf(2));
        painelTela.add(botaoDeck, Integer.valueOf(2));
        painelTela.add(botaoFinalizarDeck, Integer.valueOf(2));

        this.add(painelTela);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoDeck) {

            JFrame cartaOptionsWindow = new JFrame("Escolha suas cartas:");
            cartaOptionsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cartaOptionsWindow.setSize(400, 300);
            cartaOptionsWindow.setLocationRelativeTo(null);

            JLabel labelContador = new JLabel(
                "Quantidade de cartas escolhidas: " + contador + "/20");
            labelContador.setBounds(100, 200, 50, 50);
            cartaOptionsWindow.add(labelContador);

            cartaListModel.clear();

            for (Carta carta: criadorDecks.getCartas()) {
                cartaListModel.addElement(carta.getNome());
            }
                        
            JList<String> cartaOptions = new JList<>(cartaListModel);
            cartaOptions.setCellRenderer(new ButtonListCellRenderer());

            cartaOptions.addListSelectionListener(e1 -> {
                if (!e1.getValueIsAdjusting()) {
                    int selectedIndex = cartaOptions.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Seleciona a carta a ser usada
                        this.cartaEmUso = criadorDecks.getCartas().get(selectedIndex);
                        if (this.contador < 20) {
                            if (this.deckEmEdicao.adicionarCarta(cartaEmUso)) {
                                contador += 1;
                                labelContador.setText(
                                    "Quantidade de cartas escolhidas: " + contador + "/20");
                                System.out.println("Carta selecionada: " + cartaEmUso.getNome());
                                System.out.println(this.contador);
                                System.out.println(deckEmEdicao.getCartas());
                            }
                        }
                        else {
                            cartaOptions.setEnabled(false);
                            JOptionPane.showMessageDialog(
                                null, "Você não pode adicionar mais que 20 cartas no deck!",
                                "Limite de cartas", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            });

            cartaOptionsWindow.getContentPane().add(new JScrollPane(cartaOptions));

            cartaOptionsWindow.setLayout(new FlowLayout());

            cartaOptionsWindow.setVisible(true);
        }

        if (e.getSource() == botaoFinalizarDeck) {

            if (textNomeDeck.getText().equals("")) {
                JOptionPane.showMessageDialog(
                null, "O deck deve possuir um nome!",
                "Nome do deck", JOptionPane.WARNING_MESSAGE);
            } 
            else if (deckEmEdicao.getCartas().size() != 20) {
                JOptionPane.showMessageDialog(
                null, "O deck deve possuir 20 cartas!",
                "Quantidade de cartas", JOptionPane.WARNING_MESSAGE);
            }
            else {
                deckEmEdicao.setNome(textNomeDeck.getText());
                criadorDecks.exportarDeck(deckEmEdicao);

                JOptionPane.showMessageDialog(
                    null, "Deck criado com sucesso!",
                    "Deck criado", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("Deck exportado!");
            }
        }
    }


    public ImageIcon getFundo() {
        return this.fundo;
    }

    public void setFundo(ImageIcon fundo) {
        this.fundo = fundo;
    }

    public ImageIcon getImagemBotaoDeck() {
        return this.imagemBotaoDeck;
    }

    public void setImagemBotaoDeck(ImageIcon imagemBotaoDeck) {
        this.imagemBotaoDeck = imagemBotaoDeck;
    }

    public JLayeredPane getPainelTela() {
        return this.painelTela;
    }

    public void setPainelTela(JLayeredPane painelTela) {
        this.painelTela = painelTela;
    }

    public JLabel getLabelBackground() {
        return this.labelBackground;
    }

    public void setLabelBackground(JLabel labelBackground) {
        this.labelBackground = labelBackground;
    }

    public JLabel getLabelNomeDeck() {
        return this.labelNomeDeck;
    }

    public void setLabelNomeDeck(JLabel labelNomeDeck) {
        this.labelNomeDeck = labelNomeDeck;
    }

    public JTextField getTextNomeDeck() {
        return this.textNomeDeck;
    }

    public void setTextNomeDeck(JTextField textNomeDeck) {
        this.textNomeDeck = textNomeDeck;
    }

    public JButton getBotaoDeck() {
        return this.botaoDeck;
    }

    public void setBotaoDeck(JButton botaoDeck) {
        this.botaoDeck = botaoDeck;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public CriadorDecks getCriadorDecks() {
        return criadorDecks;
    }

    public void setCriadorDecks(CriadorDecks criadorDecks) {
        this.criadorDecks = criadorDecks;
    }

}
