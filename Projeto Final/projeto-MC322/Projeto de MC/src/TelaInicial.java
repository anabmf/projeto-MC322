import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener{
    private ImageIcon logo = new ImageIcon("Projeto de MC/src/imagens/HearthstoneLogo.png");
    private ImageIcon fundo = new ImageIcon("Projeto de MC/src/imagens/HearthstoneFrontPage.png");
    private ImageIcon jogarSolto = new ImageIcon("Projeto de MC/src/imagens/BotaoJogar.png");
    private ImageIcon jogarPressed = new ImageIcon("Projeto de MC/src/imagens/BotaoJogarPressed.png");
    private ImageIcon sairSolto = new ImageIcon("Projeto de MC/src/imagens/BotaoSair.png");
    private ImageIcon sairPressed = new ImageIcon("Projeto de MC/src/imagens/BotaoSairPressed.png");
    private JLayeredPane paneTela = new JLayeredPane();
    private JLabel labelBack = new JLabel();
    private JLabel labelBotoes = new JLabel();
    private JButton botaoJogar = new JButton(jogarSolto);
    private JButton botaoSair = new JButton(sairSolto);

    private CriadorDecks criadorDecks;

    public TelaInicial(CriadorDecks criadorDecks) {

        this.criadorDecks = criadorDecks;

        // Organizando a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800,500);
        this.setTitle("HearthStone");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Organizando a Pane
        paneTela.setPreferredSize(new Dimension(800, 500));
        
        // Organizando a Logo
        this.setIconImage(logo.getImage());
        
        // Label fundo
        labelBack.setIcon(fundo);
        labelBack.setBounds(0, 0, 800, 500);
        paneTela.add(labelBack, Integer.valueOf(0));
        
        // Label botoes
        labelBotoes.setBounds(300, 300, 800, 300);
        this.getContentPane().add(labelBotoes);
        paneTela.add(labelBotoes, Integer.valueOf(1));

        // Botao Jogar
        botaoJogar.setPressedIcon(jogarPressed);
        botaoJogar.setBorder(BorderFactory.createEmptyBorder());
        botaoJogar.setFocusable(false);
        botaoJogar.setBounds(200, 380, jogarSolto.getIconWidth(), jogarPressed.getIconHeight());
        labelBotoes.add(botaoJogar);
        paneTela.add(botaoJogar, Integer.valueOf(2));
        botaoJogar.addActionListener(this);
        
        //Botao Sair
        botaoSair.setPressedIcon(sairPressed);
        botaoSair.setBorder(BorderFactory.createEmptyBorder());
        botaoSair.setFocusable(false);
        botaoSair.setBounds(460, 380, sairSolto.getIconWidth(), sairPressed.getIconHeight());
        labelBotoes.add(botaoSair);
        paneTela.add(botaoSair, Integer.valueOf(2));
        botaoSair.addActionListener(this);
        
        this.add(paneTela);
        pack();
    }


    public ImageIcon getLogo() {
        return this.logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    public ImageIcon getFundo() {
        return this.fundo;
    }

    public void setFundo(ImageIcon fundo) {
        this.fundo = fundo;
    }

    public ImageIcon getJogarSolto() {
        return this.jogarSolto;
    }

    public void setJogarSolto(ImageIcon jogarSolto) {
        this.jogarSolto = jogarSolto;
    }

    public ImageIcon getJogarPressed() {
        return this.jogarPressed;
    }

    public void setJogarPressed(ImageIcon jogarPressed) {
        this.jogarPressed = jogarPressed;
    }

    public ImageIcon getSairSolto() {
        return this.sairSolto;
    }

    public void setSairSolto(ImageIcon sairSolto) {
        this.sairSolto = sairSolto;
    }

    public ImageIcon getSairPressed() {
        return this.sairPressed;
    }

    public void setSairPressed(ImageIcon sairPressed) {
        this.sairPressed = sairPressed;
    }

    public JLayeredPane getPaneTela() {
        return this.paneTela;
    }

    public void setPaneTela(JLayeredPane paneTela) {
        this.paneTela = paneTela;
    }

    public JLabel getLabelBack() {
        return this.labelBack;
    }

    public void setLabelBack(JLabel labelBack) {
        this.labelBack = labelBack;
    }

    public JLabel getLabelBotoes() {
        return this.labelBotoes;
    }

    public void setLabelBotoes(JLabel labelBotoes) {
        this.labelBotoes = labelBotoes;
    }

    public JButton getBotaoJogar() {
        return this.botaoJogar;
    }

    public void setBotaoJogar(JButton botaoJogar) {
        this.botaoJogar = botaoJogar;
    }

    public JButton getBotaoSair() {
        return this.botaoSair;
    }

    public void setBotaoSair(JButton botaoSair) {
        this.botaoSair = botaoSair;
    }

    public CriadorDecks getCriadorDecks() {
        return criadorDecks;
    }

    public void setCriadorDecks(CriadorDecks criadorDecks) {
        this.criadorDecks = criadorDecks;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getBotaoJogar()) {
            System.out.println("Jogar");
            new TelaJogador(criadorDecks);
            this.dispose();
        } else if (e.getSource() == getBotaoSair()) {
            System.out.println("Sair");
            System.exit(0);
        }
    }

}