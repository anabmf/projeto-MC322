/*
 * Classe Lacios filha de Cartas
 * Construtor: Lacaio(String nome, int custoMana, int poder, int vida)
 * possui os métodos gets e sets
*/

public class Lacaio extends Carta {
    
    private int poder;
    private int vida;

    public Lacaio(String nome, int custoMana, String descricao, int poder, int vida) {
        // Construor da classe.
        super(nome, custoMana, descricao);
        this.poder = poder;
        this.vida = vida;
    }

    public String toString() {
        return nome;
    }

    public String toStringFull() {
        return "Nome: " + nome + "\nCusto de mana: " + custoMana + 
        "\nPoder: " + poder + "/ Vida: " + vida + "\nDescrição: " + descricao;
    }

    // Getters e setters
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
}
