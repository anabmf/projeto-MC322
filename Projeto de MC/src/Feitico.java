/*
 *Classe Feitiço filha de Cartas 
 *Construtor: Feitico(String nome, int custoMana, String habilidade)
 *Possui gets e sets, além de um método sobrecarregado ativarHabilidade() 
*/

public class Feitico extends Carta {
    
    private String habilidade;

    public Feitico(String nome, int custoMana, String descricao){
        
        //Construtor da classe Feitiço
        
        super(nome, custoMana, descricao);
    }

    public String toString(){
        return nome;
    }

    public String toStringFull(){
        return "Nome: " + nome + "\nCusto de mana: " + custoMana + "\nDescrição: " + descricao;
    }

    // Getters e setters
    public String getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
