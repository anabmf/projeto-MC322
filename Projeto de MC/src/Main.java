import java.util.Scanner;
import java.util.ArrayList;
// Falta colocar arquivo, terminar a estrutura da mein, implementar a interface gráfica

public class Main {
    public static void main(String[] args) {
        //aparecer o menu com as opções de construir um deck, jogar e sair do jogo.
        String opcao;
        Scanner entrada = new Scanner(System.in);
        opcao = entrada.nextLine();
    
        while (opcao.equals("Sair")==false) {

            if (opcao.equals("Deck")){
                //construir o deck e salvar o deck no arquivo.
                CriadorDecks a = new CriadorDecks();
                a.InicializarCartas();
                ArrayList<Cartas> listaTeste1 = a.getCartas();
                for (Cartas carta: listaTeste1) {
                    System.out.println(carta + "\n");
                }
                a.adicionarDecksIniciais();
                ArrayList<Deck> listaTeste2 = a.getDecks();
                for (Deck deck: listaTeste2) {
                    System.out.println(deck + "\n" + deck.getCartas().toString() + "\n");
                }
            }

            if (opcao.equals("Jogo")){
                //Essa sessão é puramente pra teste, vamos ter que refazer dps com os arquivos

                //jogador 1 escolhendo o deck e poder
                System.out.println("Nome do Player 1: ");
                String nomePlayer1 = entrada.nextLine();

                //escolher um deck do arquivo

                //escolher um poder do arquivo
                Lacaio lacaio = new Lacaio("Mane", 1, 1, 1); // Instância de teste
                PoderCura poder1 = new PoderCura(nomePlayer1, 2);// Instância de teste
                Deck deck1 = new Deck("Abobora");//apenas para texte; eles devem ser retirados de um arquivo com os deck prontos
                deck1.adicionarCarta(lacaio);
                Jogador player1 = new Jogador(nomePlayer1, 20, 10, 0, deck1, poder1);

                //jogador 2 escolhendo o deck e poder
                String nomePlayer2 = entrada.nextLine();
                //escolher um deck do arquivo
                //escolher um poder do arquivo
                PoderCura poder2 = new PoderCura(nomePlayer2, 2);//Instancia de teste
                Deck deck2 = new Deck("Pepino");//apenas para texte; eles devem ser retirados de um arquivo com os deck prontos
                deck2.adicionarCarta(lacaio);
                Jogador player2 = new Jogador(nomePlayer2, 20, 10, 0, deck2, poder2);
                player1.embaralharDeck();
                player2.embaralharDeck();
                //player1.comprarCarta();no teste é só uma carta, mas na partida a gente começa com 5, só fazer um for, fazer para os dois players
                while(player1.getVida()>0 && player2.getVida()>0){
                    player1.comprarCarta();
                    if (player1.getManaTotal()<10){
                        player1.setManaTotal(player1.getManaTotal() + 1);
                    }
                    player1.setManaDisponivel(player1.getManaTotal());
                    System.out.println("Vai fazer algo?\n");
                    String vai_fazer = entrada.nextLine();
                    boolean fazer_algo = false;
                    if(vai_fazer.equals("Sim")){
                        fazer_algo =true;
                    }
                    while(fazer_algo == true){
                        String acao = entrada.nextLine();
                        if (acao.equals("Invocar")){
                            String nomeCarta = entrada.nextLine();
                            player1.invocar(nomeCarta);
                        }
                        if (acao.equals("Magia")){
                            //String nomeFeitico = entrada.nextLine();
                            //Cartas feiticoLancado = player1.acharCarta(String nome);
                            //player1.feitico(feiticoLancado,...);
                        }
                        if (acao.equals("Atacar")){
                            //invocar o meétodo para atacar com um lacaio
                        }
                        if (acao.equals("Poder")){
                            //invocar o método pra ativar o poder do player1
                        }
                        if (acao.equals("Sair")){
                            fazer_algo = false;
                        }
                    }
                    //repetir o bloco anterior para o jogador 2;
                }

                //avaliando quem venceu
                if (player1.getVida() <= 0) {
                    System.out.println("Player 2 venceu");
                } else if (player2.getVida() <= 0) {
                    System.out.println("Player 1 venceu");
                }
            }
            if (opcao.equals("Fechar")) {
                entrada.close();
                //fechar o app
            }
            else {
                opcao = "";
                continue;
            }
        }
    }
}