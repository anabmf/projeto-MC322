/*
 * Classe Deck
 * Construtor: Deck(String nome)
 * Possui os métodos de adicionar e remover as cartas no deck
 * Garante a unicidade das cartas no deck e o limite máximo de cartas
*/

import java.util.ArrayList;

public class Deck {
    
    private String nome;
    private ArrayList<Carta> cartas;

    // Construtor
    public Deck(String nome){
        this.nome = nome;
        this.cartas = new ArrayList<>();
    }

    public String toString() {
        String s = "";
        s += "- Nome do Deck: " + nome + "\n\nCartas:\n\n";
        for (Carta carta: cartas) {
            s += carta.toStringFull() + "\n\n";
        }
        return s;
    }

    public String toStringLabel(){
        String s = "<html>";
        s += "-----------------------------------------------------" + 
            "-----------------------------------------------------<br>" +
            "- Nome do Deck: " + nome + "<br>" +
            "-----------------------------------------------------" +
            "-----------------------------------------------------<br>" +
            "<br>Cartas:<br><br>";
        for (Carta carta: cartas) {
            s += carta.toStringFullLabel() + "<br><br>";
        }
        s += "<html>";
        return s;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public boolean adicionarCarta(Carta carta){
        
        // Método para adicionar cartas ao deck, além de garantir a unicidade das cartas

        boolean carta_presente = false;  // Variável auxiliar para garantir unicidade da carta no deck
        if (this.cartas.size() >= 20) {
            return false;  // Não serão adicionadas cartas adicionais (limite máximo do deck: 20)
        } else {
            for (int i = 0; i < this.cartas.size(); i++){
                // Percorrendo o deck
                if (this.cartas.get(i).getNome().equals(carta.getNome())){
                    carta_presente = true;  // Carta encontrada no deck, carta adicional não se´ra adicionada
                }
            }
            if (carta_presente == false){
                this.cartas.add(carta);  // Adicionando a carta ao deck
                return true;
            }
        }
        return false;
    }

    public void removerCarta(Carta carta){
        
        // Método para remover uma carta já existente do deck, caso a carta não esteja presente, nada será realizado

        for (int i = 0; i < this.cartas.size(); i++){
            // Procurando a carta no deck pelo nome
            if (this.cartas.get(i).getNome().equals(carta.getNome())){
                this.cartas.remove(i); // Remoção da carta
            }
        }
    }
}