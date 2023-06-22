/*
 * Calsse Deck
 * Construtor: Deck(String nome)
 * Possui os métodos de adicionar e remover as cartas no deck
 * Garante a unicidade das cartas no deck e o limite máximo de cartas
 */

import java.util.ArrayList;

public class Deck {
    
    private String nome;
    private ArrayList<Cartas> cartas;

    public Deck(String nome){
        this.nome = nome;
        this.cartas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cartas> getCartas() {
        return cartas;
    }

    public void adicionarCarta(Cartas carta){
        
        //Método para adicionar cartas ao deck, além de garantir a unicidade das cartas

        boolean carta_presente = false;//variável auxiliar para garantir unicidade da carta no deck
        if (this.cartas.size() >= 20){
            //não serão adicionadas cartas adicionais (limite máximo do deck: 20)
        } else {
            for (int i = 0; i < this.cartas.size(); i++){
                //percorrendo o deck
                if (this.cartas.get(i).getNome().equals(carta.getNome())){
                    carta_presente = true;//carta encontrada no deck, carta adicional não se´ra adicionada
                }
            }
            if (carta_presente == false){
                this.cartas.add(carta);//adicionando a carta ao deck
            }
        }
    }

    public void removerCarta(Cartas carta){
        
        //Método para remover uma carta já existente do deck, caso a carta não esteja presente, nada será realizado

        for (int i = 0; i < this.cartas.size(); i++){
            //procurando a carta no deck pelo nome
            if (this.cartas.get(i).getNome().equals(carta.getNome())){
                this.cartas.remove(i);//remoção da carta
            }
        }
    }

    public String toString(){
        return nome;
    }
}