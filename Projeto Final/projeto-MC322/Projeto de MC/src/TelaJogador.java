
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogador extends Tela implements ActionListener {

    private ImageIcon fundo = new ImageIcon("Projeto de MC/src/imagens/HearthstonePlayerBackground.jpg");
    private ImageIcon imagemBotaoDeck = new ImageIcon("Projeto de MC/src/imagens/BotaoEscolher.png");
    private JLayeredPane painelTela = new JLayeredPane();
    private JLabel labelBackground = new JLabel();
    private JLabel labelNomeJogador = new JLabel();
    private JTextField textNomeJogador = new JTextField(50);
    private JButton botaoDeck = new JButton(imagemBotaoDeck);
    private int contador = 0;
    public String nomeJogador1;
    public String nomeJogador2;

    private CriadorDecks criadorDecks;
    private Deck deckEmUso;
    private DefaultListModel<String> deckListModel;

    public TelaJogador(CriadorDecks criadorDecks) {

        // Organizando a tela
        super();

        this.criadorDecks = criadorDecks;
        deckListModel = new DefaultListModel<>();

        // Label fundo
        labelBackground.setIcon(fundo);
        labelBackground.setBounds(0, 0, 800, 500);
        painelTela.add(labelBackground, Integer.valueOf(0));

        // Label nome jogador
        labelNomeJogador.setLocation(60, 120);
        labelNomeJogador.setSize(660, 60);
        labelNomeJogador.setOpaque(true);
        labelNomeJogador.setBackground(new Color(0x4A3157));
        labelNomeJogador.setText("Nome do Jogador 1:");
        labelNomeJogador.setForeground(new Color(0xFFFFFF));
        labelNomeJogador.setFont(new Font("Calibri Light", Font.BOLD, 30));

        // TexField nome jogador
        textNomeJogador.setBounds(320, 133, 300, 25);

        // Botao Jogar
        botaoDeck.setFocusable(false);
        botaoDeck.setBounds(270, 250, 250, 40);
        botaoDeck.addActionListener(this);

        // Organizando a Painel
        painelTela.setPreferredSize(new Dimension(800, 500));
        painelTela.add(labelNomeJogador, Integer.valueOf(1));
        painelTela.add(textNomeJogador, Integer.valueOf(2));
        painelTela.add(botaoDeck, Integer.valueOf(2));

        this.add(painelTela);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoDeck) {

            JFrame deckOptionsWindow = new JFrame("Selecione o seu deck:");
            deckOptionsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deckOptionsWindow.setSize(400, 300);

            deckListModel.clear();

            for (Deck deck: criadorDecks.getDecks()) {
                deckListModel.addElement(deck.getNome());
            }
                        
            JList<String> deckOptions = new JList<>(deckListModel);
            deckOptions.setCellRenderer(new ButtonListCellRenderer());

            deckOptions.addListSelectionListener(e1 -> {
                if (!e1.getValueIsAdjusting()) {
                    int selectedIndex = deckOptions.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Seleciona o deck a ser usado
                        this.deckEmUso = criadorDecks.getDecks().get(selectedIndex);
                        System.out.println("Deck selecionado: " + deckEmUso);
                    }
                }
            });
            deckOptionsWindow.getContentPane().add(new JScrollPane(deckOptions));

            deckOptionsWindow.setLayout(new FlowLayout());

            deckOptionsWindow.setVisible(true);
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

    public JLabel getLabelNomeJogador() {
        return this.labelNomeJogador;
    }

    public void setLabelNomeJogador(JLabel labelNomeJogador) {
        this.labelNomeJogador = labelNomeJogador;
    }

    public JTextField getTextNomeJogador() {
        return this.textNomeJogador;
    }

    public void setTextNomeJogador(JTextField textNomeJogador) {
        this.textNomeJogador = textNomeJogador;
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
