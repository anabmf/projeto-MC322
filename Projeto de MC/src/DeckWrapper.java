import java.util.ArrayList;

public class DeckWrapper {
    
    private String nome;
    private ArrayList<String> cartas;

    public DeckWrapper(Deck deck) {
        this.nome = deck.getNome();
        this.cartas = new ArrayList<String>();
        for (Carta carta: deck.getCartas()) {
            this.cartas.add(carta.nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getNomesCartas() {
        return cartas;
    }
}
