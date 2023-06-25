/*
 * Classe PoderCura filha de Poder
 * Construtor: PoderCura(String nome, int qtdCura)
 * Poder responsável por aumentar a vida atual do jogador em 1 ponto
 */

public class PoderCura extends Poder{
    
    private int qtdCura;

    public PoderCura(String nome, int qtdCura){
    //construtor
        super(nome);
        this.qtdCura = qtdCura;
    }

    //getters e setters
    public int getQtdCura() {
        return qtdCura;
    }
    public void setQtdCura(int qtdCura) {
        this.qtdCura = qtdCura;
    }

    public void ativarHabilidade(Jogador player){
        //Recebe um Jogador e aumenta a vida dele de acordo com a intensidade do poder;
        int nova_vida = player.getVida() + qtdCura;//variaável auxiliar
        player.setVida(nova_vida);
    }
}
