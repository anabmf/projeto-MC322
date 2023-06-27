import javax.swing.*;

public abstract class Tela extends JFrame{
    private ImageIcon logo = new ImageIcon("Projeto de MC/src/GUI/HearthstoneLogo.png");
        
    public Tela() {
        // Estabelecendo a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800,500);
        this.setTitle("HearthStone Deck Creator");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());  // Adiciona logo
    }
}