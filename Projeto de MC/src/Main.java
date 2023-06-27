import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        CriadorDecks d = new CriadorDecks();
        d.InicializarCartas();
        d.InicializarDecks();
        d.InicializarDecksUsuario();

        SwingUtilities.invokeLater(() -> {
            new TelaInicial(d);
        });
    }
}