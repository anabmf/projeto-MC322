/*
 * Classe PoderCura filha de Poder
 * Construtor: PoderDano(String nome, int qtdCura)
 * Poder responsável por diminuir a vida atual do jogador
 */

 public class PoderDano extends Poder{
    
    private int qtdDano;

    public PoderDano(String nome, int qtdDano){
        //construtor
        super(nome);
        this.qtdDano = qtdDano;
    }

    //getters e setters
    public int getQtdDano() {
        return qtdDano;
    }
    public void setQtdDano(int qtdDano) {
        this.qtdDano = qtdDano;
    }

    public void ativarHabilidade(Jogador player){
        //Recebe um Jogador e aumenta a vida dele de acordo com a intensidade do poder;
        int nova_vida = player.getVida() - qtdDano;//variaável auxiliar
        player.setVida(nova_vida);
    }
}