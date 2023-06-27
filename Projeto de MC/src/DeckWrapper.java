/*
 * Classe DeckWrapper
 * Construtor: DeckWrapper(Deck deck)
 * Essa classe é usada para converter um deck em um objeto que pode ser
 * melhor convertido para o arquivo Json do formato correto.
 * Possui gets e sets.
*/

import java.util.ArrayList;

public class DeckWrapper {
    
    private String nome;
    private ArrayList<String> cartas;

    // Construtor
    public DeckWrapper(Deck deck) {
        this.nome = deck.getNome();
        this.cartas = new ArrayList<String>();
        for (Carta carta: deck.getCartas()) {
            this.cartas.add(carta.nome);
        }
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }
    public ArrayList<String> getNomesCartas() {
        return cartas;
    }
}
