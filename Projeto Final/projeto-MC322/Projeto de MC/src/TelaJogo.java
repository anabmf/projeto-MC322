import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaJogo extends Tela implements ActionListener {
    
    private JLayeredPane painelTela = new JLayeredPane();
    private JPanel painelJogador2 = new JPanel();
    private JPanel painelMesaJogador2 = new JPanel();
    private JPanel painelMesaJogador1 = new JPanel();
    private JPanel painelJogador1 = new JPanel();
    private JLabel labelBackground = new JLabel();
    private JLabel labelJogador2 = new JLabel();
    private JLabel labelJogador1 = new JLabel();
    private JButton botaoPassarVez = new JButton(new ImageIcon("Projeto de MC/src/imagens/botaoPassarVez.png"));
    private JButton botaoSelecionarCarta = new JButton(new ImageIcon("Projeto de MC/src/imagens/botaoSelecionarCartas.png"));
    private String teste = "nome do jogador 2";


    public TelaJogo() {
        super();

        labelBackground.setIcon(new ImageIcon("HearthstoneBattleBackground.png"));
        labelBackground.setBounds(0, 25, 800, 400);

        // painel com infos do jogador2
        painelJogador2.setBackground(new Color(0x4A3157));
        painelJogador2.setBounds(0, 0, 800, 70);
        painelJogador2.setLayout(new BorderLayout());

        // painel com infos do jogador1
        painelJogador1.setBackground(new Color(0x4A3157));
        painelJogador1.setBounds(0, 390, 800, 80);
        painelJogador1.setLayout(new BorderLayout());

        // painel com as cartas na mesa do Jogador2
        painelMesaJogador2.setBackground(new Color(0xFFFFFF));
        painelMesaJogador2.setBounds(0, 105, 800, 120);

        // painel com as cartas na mesa do Jogador1
        painelMesaJogador1.setBounds(0, 235, 800, 120);
        painelMesaJogador1.setBackground(new Color(0xFFFFFF));

        // painel superior com as informacoes do jogador 2
        labelJogador2.setText("Jogador 2: " + teste +"        Vida:      "+"         Mana:      ");
        labelJogador2.setForeground(new Color(0xFFFFFF));
        labelJogador2.setFont(new Font("Calibri Light", Font.BOLD, 20));
        labelJogador2.setVerticalAlignment(JLabel.CENTER);
        labelJogador2.setHorizontalAlignment(JLabel.CENTER);
        painelJogador2.add(labelJogador2);
        
        // painel superior com as informacoes do oponente
        labelJogador1.setText("Jogador 1: " + teste +"        Vida:      "+"         Mana:      ");
        labelJogador1.setForeground(new Color(0xFFFFFF));
        labelJogador1.setFont(new Font("Calibri Light", Font.BOLD, 20));
        labelJogador1.setVerticalAlignment(JLabel.CENTER);
        labelJogador1.setHorizontalAlignment(JLabel.CENTER);
        painelJogador1.add(labelJogador1);

        // botao de passar a vez
        botaoPassarVez.setFocusable(false);
        botaoPassarVez.setBounds(610, 210, 150, 40);
        botaoPassarVez.setBackground(new Color(0,0,0,0));
        botaoPassarVez.addActionListener(this);

        // botao de selecionar cartas da mao
        botaoSelecionarCarta.setFocusable(false);
        botaoSelecionarCarta.setBounds(30, 210, 150, 40);
        botaoSelecionarCarta.setBackground(new Color(0,0,0,0));
        botaoSelecionarCarta.addActionListener(this);

        
        // Adicionando todos os paineis no painelTela (principal)
        painelTela.setPreferredSize(new Dimension(800, 500));
        painelTela.setLayout(new BorderLayout());
        painelTela.add(labelBackground, Integer.valueOf(0));
        painelTela.add(painelJogador2, Integer.valueOf(1));
        painelTela.add(painelJogador1, Integer.valueOf(1));
        painelTela.add(painelMesaJogador2, Integer.valueOf(1));
        painelTela.add(painelMesaJogador1, Integer.valueOf(1));
        painelTela.add(botaoPassarVez, Integer.valueOf(2));
        painelTela.add(botaoSelecionarCarta, Integer.valueOf(2));

        this.add(painelTela);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}