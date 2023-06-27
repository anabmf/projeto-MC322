/*
 * Classe abstrata: Carta
 * Construtor: Cartas(String nome, int custoMano)
 * Possui gets e sets, além do método ativarHabilidade() que será implementado nas classes fihas
*/

public abstract class Carta {
    
    protected String nome;
    protected int custoMana;
    protected String descricao;

    public Carta(String nome, int custoMana, String descricao) {
        // Construtor da classe
        this.custoMana = custoMana;
        this.nome = nome;
        this.descricao = descricao;
    }

    public void ativarHabilidade() {} // Método abstrato

    // Getters e setters
    public int getCustoMana() {
        return custoMana;
    }
    public void setCustoMana(int custo) {
        this.custoMana = custo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}