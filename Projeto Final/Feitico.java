/*
 *Classe Feitiço filha de Cartas 
 *Construtor: Feitico(String nome, int custoMana, String habilidade)
 *Possui gets e sets, além de um método sobrecarregado ativarHabilidade() 
 */

 public class Feitico extends Cartas {
    
    private String habilidade;

    public Feitico(String nome, int custoMana, String habilidade){
        
        //Construtor da classe Feitiço
        
        super(nome, custoMana);
        this.habilidade = habilidade;
    }

    //getters e setters
    public String getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public void ativarHabilidade(Jogador player){
        //Método com sobrecarga
        //Esse é ativado quando o alvo é um jogador
        //Pode ser tanto o jogador que conjurou o Feitiço como o oponente
        if (this.getHabilidade().equals("Cura")){
            //Cura aumenta a vida do Jogador em 1.
            int nova_vida = player.getVida() + 1;//variável auxiliar que soma 1 à vida atual
            player.setVida(nova_vida);
        }
        if (this.getHabilidade().equals("Dano")){
            //Dano diminui a vida do Jogador em 1.
            int nova_vida = player.getVida() - 1;//variável auxiliar que subtrai 1 à vida atual
            player.setVida(nova_vida);
        }
        if (this.getHabilidade().equals("Comprar")){
            //Comprar adiciona uma carta do deck para a mão do jogador.
            player.comprarCarta();
        }
    }

    public void ativarHabilidade(Jogador player, Lacaio minion){
        //Método com sobrecarga
        //Esse é ativado quando o alvo é um Lacaio
        //Pode tanto ser conjurado em um minion aliado com adversário
        if (this.getHabilidade().equals("Crescer")){
            //Aumenta o poder e a vida de um minion em 1
            int novo_poder = minion.getPoder() + 1;
            int nova_vida = minion.getVida() + 1;
            minion.setPoder(novo_poder);
            minion.setVida(nova_vida);
        }
        if (this.getHabilidade().equals("Destruir")){
            //Remove um minion da mesa
            for (int i = 0; i < player.getMesa().size(); i++){
                //Procura o minion alvo
                if (player.getMesa().get(i).getNome().equals(minion.getNome())){
                    player.getMesa().remove(i);//remove ele do ArrayList Mesa do jogador
                }
            }
        }
        if (this.getHabilidade().equals("Comprar")){
            //compra uma carta do deck
            player.comprarCarta();
        }
    }

    public String toString(){
        return "Nome: " + nome + "\nCusto de mana: " + custoMana + "\nHabilidade: " + habilidade;
    }
}