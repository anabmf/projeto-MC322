import java.util.Scanner;
//falta colocar arquivo, terminar a estrutura da mein, implementar a interface gráfica
public class Main {
    public static void main(String[] args) {
        //aparecer o menu com as opções de construir um deck, jogar e sair do jogo.
        Scanner entrada = new Scanner(System.in);
        String opcao = "lixo";
        while (opcao.equals("Sair") == false){
            System.out.println("\nOpcoes: \nJogo \nDeck \nSair");
            opcao = entrada.nextLine();
            if (opcao.equals("Deck")){
                //construir o deck e salvar o deck no arquivo.
            }
            //jogo
            if (opcao.equals("Jogo")){
                //Essa sessão é puramente pra teste, vamos ter que refazer dps com os arquivos
                //jogador 1 escolhendo o deck e poder
                System.out.println("\nEscreva o nome do player1: ");
                String nomePlayer1 = entrada.nextLine();
                //escolher um deck do arquivo
                //escolher um poder do arquivo
                Lacaio lacaio = new Lacaio("Mane", 1, 1, 1);//intancia pra teste;
                PoderCura poder1 = new PoderCura(nomePlayer1, 2);//Instancia de teste
                Deck deck1 = new Deck("Abobora");//apenas para texte; eles devem ser retirados de um arquivo com os deck prontos
                deck1.adicionarCarta(lacaio);
                Jogador player1 = new Jogador(nomePlayer1, 20, 10, 0, deck1, poder1);
                //jogador 2 escolhendo o deck e poder
                System.out.println("\nEscreva o nome do player2: ");
                String nomePlayer2 = entrada.nextLine();
                //escolher um deck do arquivo
                //escolher um poder do arquivo
                Lacaio putz = new Lacaio("Otario", 1, 2, 2);
                PoderCura poder2 = new PoderCura(nomePlayer2, 2);//Instancia de teste
                Deck deck2 = new Deck("Pepino");//apenas para texte; eles devem ser retirados de um arquivo com os deck prontos
                deck2.adicionarCarta(putz);
                Jogador player2 = new Jogador(nomePlayer2, 20, 10, 0, deck2, poder2);
                player1.embaralharDeck();
                player2.embaralharDeck();
                //player1.comprarCarta();no teste é só uma carta, mas na partida a gente começa com 5, só fazer um for, fazer para os dois players
                while(player1.getVida() > 0 && player2.getVida() > 0){
                    if (player1.getMao().size() < 5) {
                        player1.comprarCarta();
                    }
                    if (player1.getManaTotal() < 10){
                        player1.setManaTotal(player1.getManaTotal() + 1);
                    }
                    player1.setManaDisponivel(player1.getManaTotal());
                    boolean fazer_algo = true;
                    while(fazer_algo == true){
                        System.out.println("\nOpcoes de jogada do " + player1.getNome() + ": \nInvocar \nMagia \nAtacar \nPoder \nSair");
                        String acao = entrada.nextLine();
                        if (acao.equals("Invocar")){
                            System.out.println("\nVocê tem os lacaios: ");
                            for (Cartas carta: player1.getMao()) {
                                if (carta instanceof Lacaio) {
                                    System.out.println("\n" + carta.getNome());
                                }
                            }

                            String nomeCarta = entrada.nextLine();
                            player1.invocar(nomeCarta);
                        }
                        if (acao.equals("Magia")){
                            System.out.println("\nVocê possui feiticos de: ");
                            for (Cartas carta: player1.getMao()) {
                                if (carta instanceof Feitico) {
                                    System.out.println("\n" + carta.getNome());
                                }
                            }

                            String nomeFeitico = entrada.nextLine();
                            Cartas feiticoLancado = player1.acharCarta(nomeFeitico);

                            if (feiticoLancado instanceof Feitico) {
                                Feitico magia = (Feitico) feiticoLancado;
                                System.out.println("\nPossiveis alvos: ");

                                if (magia.getHabilidade().equals("Comprar") || magia.getHabilidade().equals("Cura") || 
                                magia.getHabilidade().equals("Dano")) {
                                    System.out.println("\n" + player1.getNome() + "\n" + player2.getNome());
                                    String alvo = entrada.nextLine();

                                    if (alvo.equals(player1.getNome()))
                                        player1.castar(magia, player1);
                                    else if (alvo.equals(player2.getNome())) {
                                        player1.castar(magia, player2);
                                    }
                                    player1.getMao().remove(feiticoLancado);
                                }

                                else if (magia.getHabilidade().equals("Crescer") || magia.getHabilidade().equals("Destruir")) {
                                    System.out.println("\nAliados: ");
                                    for (Lacaio monstro: player1.getMesa()) {
                                        System.out.println("\n" + monstro.getNome());
                                    }
                                    System.out.println("\nInimigos: ");
                                    for (Lacaio monstro: player2.getMesa()) {
                                        System.out.println("\n" + monstro.getNome());
                                    }
                                    String alvo = entrada.nextLine();
                                    for (Lacaio monstro: player1.getMesa()) {
                                        if (monstro.getNome().equals(alvo)) {
                                            player1.castar(magia, player2, monstro);
                                        }
                                    }
                                    for (Lacaio monstro: player2.getMesa()) {
                                        if (monstro.getNome().equals(alvo)) {
                                            player2.castar(magia, player2, monstro);
                                        }
                                    }
                                    player1.getMao().remove(feiticoLancado);
                                }
                            }
                        }
                        if (acao.equals("Atacar")){
                            System.out.println("\nLacaios aliados: ");
                            for (Lacaio monstro: player1.getMesa()) {
                                System.out.println("\n" + monstro.getNome());
                            }
                            System.out.println("\nLacaios inimigos: ");
                            for (Lacaio monstro: player2.getMesa()) {
                                System.out.println("\n" + monstro.getNome());
                            }
                            System.out.println("\nEscolha que lacaio vai atacar: ");
                            String atacante = entrada.nextLine();

                            for (Lacaio monstro: player1.getMesa()) {
                                if (monstro.getNome().equals(atacante)) {
                                    if (player2.getMesa().isEmpty()) {
                                        System.out.println("\nAlvo: " + player2.getNome());
                                        player1.atacar(monstro, player2);
                                    }
                                    else {
                                        System.out.println("\nEscolha alvo: ");
                                        String alvo = entrada.nextLine();
                                        for (Lacaio inimigo: player2.getMesa()) {
                                            if (inimigo.getNome().equals(alvo)) {
                                                player1.atacar(monstro, inimigo, player2);
                                                break; //Precisa?
                                            }           
                                        }
                                    }
                                }
                            }
                        }
                        if (acao.equals("Poder")){
                            System.out.println("\nVocê possui o poder de: " + player1.getPoder());
                            System.out.println("\nPossiveis alvos: ");
                            System.out.println("\n" + player1.getNome() + "\n" + player2.getNome());
                            String alvo = entrada.nextLine();

                            if (alvo.equals(player1.getNome())) {
                                player1.getPoder().ativarHabilidade(player1);
                            }
                            else if (alvo.equals(player2.getNome())) {
                                player1.getPoder().ativarHabilidade(player2);
                            }
                        }
                        if (acao.equals("Sair")){
                            fazer_algo = false;
                        }
                    }


                    if (player2.getMao().size() < 5) {
                        player2.comprarCarta();
                    }
                    if (player2.getManaTotal() < 10){
                        player2.setManaTotal(player2.getManaTotal() + 1);
                    }
                    player2.setManaDisponivel(player2.getManaTotal());
                    System.out.println("\nVai fazer algo?");
                    String vai_fazer2 = entrada.nextLine();
                    boolean fazer_algo2 = false;
                    if(vai_fazer2.equals("Sim")){
                        fazer_algo2 =true;
                    }
                    while(fazer_algo2 == true){
                        System.out.println("\nOpcoes de jogada do " + player2.getNome() + ": \nInvocar \nMagia \nAtacar \nPoder \nSair");
                        String acao = entrada.nextLine();
                        if (acao.equals("Invocar")){
                            System.out.println("\nVocê tem os lacaios: ");
                            for (Cartas carta: player2.getMao()) {
                                if (carta instanceof Lacaio) {
                                    System.out.println("\n" + carta.getNome());
                                }
                            }

                            String nomeCarta = entrada.nextLine();
                            player2.invocar(nomeCarta);
                        }
                        if (acao.equals("Magia")){
                            System.out.println("\nVocê possui feiticos de: ");
                            for (Cartas carta: player2.getMao()) {
                                if (carta instanceof Feitico) {
                                    System.out.println("\n" + carta.getNome());
                                }
                            }

                            String nomeFeitico = entrada.nextLine();
                            Cartas feiticoLancado = player2.acharCarta(nomeFeitico);

                            if (feiticoLancado instanceof Feitico) {
                                Feitico magia = (Feitico) feiticoLancado;
                                System.out.println("\nPossiveis alvos: ");

                                if (magia.getHabilidade().equals("Comprar") || magia.getHabilidade().equals("Cura") || 
                                magia.getHabilidade().equals("Dano")) {
                                    System.out.println("\n" + player2.getNome() + "\n" + player1.getNome());
                                    String alvo = entrada.nextLine();

                                    if (alvo.equals(player2.getNome()))
                                        player2.castar(magia, player2);
                                    else if (alvo.equals(player1.getNome())) {
                                        player2.castar(magia, player1);
                                    }
                                    player2.getMao().remove(feiticoLancado);
                                }

                                else if (magia.getHabilidade().equals("Crescer") || magia.getHabilidade().equals("Destruir")) {
                                    System.out.println("\nAliados: ");
                                    for (Lacaio monstro: player2.getMesa()) {
                                        System.out.println("\n" + monstro.getNome());
                                    }
                                    System.out.println("\nInimigos: ");
                                    for (Lacaio monstro: player1.getMesa()) {
                                        System.out.println("\n" + monstro.getNome());
                                    }
                                    String alvo = entrada.nextLine();
                                    for (Lacaio monstro: player2.getMesa()) {
                                        if (monstro.getNome().equals(alvo)) {
                                            player2.castar(magia, player1, monstro);
                                        }
                                    }
                                    for (Lacaio monstro: player1.getMesa()) {
                                        if (monstro.getNome().equals(alvo)) {
                                            player1.castar(magia, player1, monstro);
                                        }
                                    }
                                    player2.getMao().remove(feiticoLancado);
                                }
                            }
                        }
                        if (acao.equals("Atacar")){
                            System.out.println("\nLacaios aliados: ");
                            for (Lacaio monstro: player2.getMesa()) {
                                System.out.println("\n" + monstro.getNome());
                            }
                            System.out.println("\nLacaios inimigos: ");
                            for (Lacaio monstro: player1.getMesa()) {
                                System.out.println("\n" + monstro.getNome());
                            }
                            System.out.println("\nEscolha que lacaio vai atacar: ");
                            String atacante = entrada.nextLine();

                            for (Lacaio monstro: player2.getMesa()) {
                                if (monstro.getNome().equals(atacante)) {
                                    if (player1.getMesa().isEmpty()) {
                                        System.out.println("\nAlvo: " + player1.getNome());
                                        player2.atacar(monstro, player2);
                                    }
                                    else {
                                        System.out.println("\nEscolha alvo: ");
                                        String alvo = entrada.nextLine();
                                        for (Lacaio inimigo: player1.getMesa()) {
                                            if (inimigo.getNome().equals(alvo)) {
                                                player2.atacar(monstro, inimigo, player2);
                                                break; //Precisa?
                                            }           
                                        }
                                    }
                                }
                            }
                        }
                        if (acao.equals("Poder")){
                            System.out.println("\nVocê possui o poder de: " + player2.getPoder());
                            System.out.println("\nPossiveis alvos: ");
                            System.out.println("\n" + player2.getNome() + "\n" + player1.getNome());
                            String alvo = entrada.nextLine();

                            if (alvo.equals(player2.getNome())) {
                                player2.getPoder().ativarHabilidade(player2);
                            }
                            else if (alvo.equals(player1.getNome())) {
                                player2.getPoder().ativarHabilidade(player1);
                            }
                        }
                        if (acao.equals("Sair")){
                            fazer_algo2 = false;
                        }
                    }
                }
                //avaliando quem venceu
                if (player1.getVida() <= 0){
                    System.out.println("Player 2 venceu");
                } else if (player2.getVida() <= 0) {
                    System.out.println("Player 1 venceu");
                }
            }
            if (opcao.equals("Fechar")){
                entrada.close();
                //fechar o app
            }
            else {
                continue;
            }
        }
    }
}