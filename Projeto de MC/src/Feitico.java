/*
 *Classe Feitiço filha de Cartas 
 *Construtor: Feitico(String nome, int custoMana, String descricao)
 *Possui gets e sets
*/

public class Feitico extends Carta {
    
    private String habilidade;

    // Construtor
    public Feitico(String nome, int custoMana, String descricao) {
        super(nome, custoMana, descricao);
    }

    public String toString(){
        return nome;
    }

    public String toStringFull(){
        return "Nome: " + nome + "<br>Custo de mana: " + custoMana + "<br>Descrição: " + descricao;
    }

    public String toStringFullLabel(){
        return "<html>Nome: " + nome + "<br>Custo de mana: " + custoMana + "<br>Descrição: " + descricao + "<html>";
    }

    // Getters e setters
    public String getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
