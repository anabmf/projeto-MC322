/*
 * Classe Lacios filha de Cartas
 * Construtor: Lacaio(String nome, int custoMana, int poder, int vida, String habilidade)
 * possui os métodos gets e sets, além do método ativarHabilidade()
 */

public class Lacaio extends Cartas{
    
    private int poder;
    private int vida;
    private String habilidade;//as habilidades terão valores unitários e serão restritas a: Cura, Dano e Comprar.

    public Lacaio(String nome, int custoMana, int poder, int vida, String habilidade){
        
        //Construor da classe.
        
        super(nome, custoMana);
        this.poder = poder;
        this.vida = vida;
        this.habilidade = habilidade;
    }

    //getters e setters
    public int getPoder() {
        return poder;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public void ativarHabilidade(Jogador player){

        //para ativar a habilidade o método recebe um Jogador
        //o Jogador pode tanto causar o efeito nele como no Jogador oponente

        if (this.getHabilidade().equals("Cura")){
            //Cura aumenta a vida do Jogador em 1.
            int nova_vida = player.getVida() + 1;//variável auxiliar que soma 1 à vida atual
            player.setVida(nova_vida);
        }
        if (this.getHabilidade().equals("Dano")){
            //Dano diminui a vida do Jogador em 1.
            int nova_vida = player.getVida() - 1;//variável auxiliar que subtrái 1 à vida atual
            player.setVida(nova_vida);
        }
        if (this.getHabilidade().equals("Comprar")){
            //Comprar adiciona uma carta do deck para a mão do jogador.
            player.comprarCarta();
        }
    }

    public String toString(){
        return "Nome: " + nome + "\nCusto de mana: " + custoMana + "\nPoder: " + poder + " Vida: " + vida + "\nHabilidade: " + habilidade;
    }
}
