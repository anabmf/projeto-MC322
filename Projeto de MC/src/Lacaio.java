/*
 * Classe Lacios filha de Cartas
 * Construtor: Lacaio(String nome, int custoMana, int poder, int vida)
 * possui os métodos gets e sets
*/

public class Lacaio extends Cartas{
    
    private int poder;
    private int vida;

    public Lacaio(String nome, int custoMana, int poder, int vida){
        //Construor da classe.
        super(nome, custoMana);
        this.poder = poder;
        this.vida = vida;
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

    public String toString(){
        return "Nome: " + nome + "\nCusto de mana: " + custoMana + "\nPoder: " + poder + " Vida: " + vida;
    }
}
