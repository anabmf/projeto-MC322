/*
 * Classe PoderCompra filha de Poder
 * Construtor: PoderCompra(String nome)
 * Método ativarHabilidade faz o jogador comprar uma carta
 */

public class PoderCompra extends Poder {
    
    public PoderCompra(String nome){
        super(nome);
    }

    public void ativarHabilidade(Jogador player){
        player.comprarCarta();
    }
}