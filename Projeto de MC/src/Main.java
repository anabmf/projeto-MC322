import javax.swing.SwingUtilities;

// Falta colocar arquivo, terminar a estrutura da mein, implementar a interface gráfica

public class Main {
    public static void main(String[] args) {

        CriadorDecks a = new CriadorDecks();
        a.InicializarCartas();
        a.InicializarDecks();
        a.InicializarDecksUsuario();

        SwingUtilities.invokeLater(() -> {
            new TelaInicial(a);
        });
    }
}