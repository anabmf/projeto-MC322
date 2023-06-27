import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends Tela implements ActionListener{
    private ImageIcon logo = new ImageIcon("Projeto de MC/src/imagens/HearthstoneLogo.png");
    private ImageIcon fundo = new ImageIcon("Projeto de MC/src/imagens/HearthstoneFrontPage.png");
    private ImageIcon iniciarSolto = new ImageIcon("Projeto de MC/src/imagens/BotaoIniciar.png");
    private ImageIcon iniciarPressed = new ImageIcon("Projeto de MC/src/imagens/BotaoIniciarPressed.png");
    private ImageIcon sairSolto = new ImageIcon("Projeto de MC/src/imagens/BotaoSair.png");
    private ImageIcon sairPressed = new ImageIcon("Projeto de MC/src/imagens/BotaoSairPressed.png");
    private JLayeredPane paneTela = new JLayeredPane();
    private JLabel labelBack = new JLabel();
    private JLabel labelBotoes = new JLabel();
    private JButton botaoIniciar = new JButton(iniciarSolto);
    private JButton botaoSair = new JButton(sairSolto);

    private CriadorDecks criadorDecks;

    public TelaInicial(CriadorDecks criadorDecks) {

        this.criadorDecks = criadorDecks;

        // Organizando a Pane
        paneTela.setPreferredSize(new Dimension(800, 500));
        
        // Label fundo
        labelBack.setIcon(fundo);
        labelBack.setBounds(0, 0, 800, 500);
        paneTela.add(labelBack, Integer.valueOf(0));
        
        // Label botoes
        labelBotoes.setBounds(300, 300, 800, 300);
        this.getContentPane().add(labelBotoes);
        paneTela.add(labelBotoes, Integer.valueOf(1));

        // Botao Jogar
        botaoIniciar.setPressedIcon(iniciarPressed);
        botaoIniciar.setBorder(BorderFactory.createEmptyBorder());
        botaoIniciar.setFocusable(false);
        botaoIniciar.setBounds(200, 380, iniciarSolto.getIconWidth(), iniciarPressed.getIconHeight());
        labelBotoes.add(botaoIniciar);
        paneTela.add(botaoIniciar, Integer.valueOf(2));
        botaoIniciar.addActionListener(this);
        
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

    // Getters e setters
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

    public ImageIcon getiniciarSolto() {
        return this.iniciarSolto;
    }

    public void setiniciarSolto(ImageIcon iniciarSolto) {
        this.iniciarSolto = iniciarSolto;
    }

    public ImageIcon getiniciarPressed() {
        return this.iniciarPressed;
    }

    public void setiniciarPressed(ImageIcon iniciarPressed) {
        this.iniciarPressed = iniciarPressed;
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

    public JButton getBotaoIniciar() {
        return this.botaoIniciar;
    }

    public void setBotaoIniciar(JButton botaoIniciar) {
        this.botaoIniciar = botaoIniciar;
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
        if (e.getSource() == getBotaoIniciar()) {
            System.out.println("Jogar");
            new TelaPrincipal(criadorDecks);
            this.dispose();
        } else if (e.getSource() == getBotaoSair()) {
            System.out.println("Sair");
            System.exit(0);
        }
    }

}