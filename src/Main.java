import java.util.*;

public class Main {

    //É criada um objecto Coordinates com as coordenadas iniciais do Ash
    private static Coordinates position = new Coordinates(0,0);

    //É criado um HashMap para se conseguir obter as cordenadas a somar às
    // cordenadas do Ash dando como chave uma direção escolhida.
    final private static HashMap<Character, Coordinates> directionSum = new HashMap<>(){{
        put('N', new Coordinates(0,1));
        put('S', new Coordinates(0,-1));
        put('E', new Coordinates(1,0));
        put('O', new Coordinates(-1,0));
    }};

    //É criado um HashSet de forma a guardar as cordenadas onde o Ash já esteve.
    private static HashSet<Coordinates> discovered = new HashSet<>();

    public static void main(String[] args){

        while (true) {
            System.out.println("\nPokemon: Apanhá-los Todos");
            System.out.println("Insere quantos Ns, Ss, Es, ou Os quiseres, para o Ash se deslocar,\n" +
                    "Não insiras nada e prime enter para testar a rota definida no código,\n" +
                    "Ou introduz 0 para sair:\n" );

            String route = new Scanner(System.in).nextLine();
            //route  = pathGenerator(500000);
            //route  = "E";
            // route  = "NESO";
            // route  = "NSNSNSNSNS";
            //route = "NSONE";

            if (route.equals("0")){
                break;
            }
            //Reset ao HashSet que guarda as cordenadas onde o Ash já esteve
            //e inserção da cordenada inicial do Ash no HashSet.
            discovered.clear();
            discovered.add(position);

            //É usado um for para percorrer a String com a rota do Ash e analisar
            //cada caracter da rota individualmente.
            for (char direction : route.toCharArray()) {
                //System.out.println(position.toString());

                //É somada à posição do Ash a cordenada obtida utilizando o caracter
                //como chave no Hashmap directionSum. Como o HashSet não permite duplicados só vão ser adicionadas
                // novas Coordenadas. Se o caracter não for N S O ou E o
                //erro provocado é ignorado.
                try {
                    position = position.sum(directionSum.get(direction));
                    discovered.add(position);
                }catch (Exception e){
                    //System.out.println("Caracter Inválido");
                }
            }
            //O tamanho do Hashset será igual ao nº de posições diferentes que o Ash percorreu.
            System.out.println("\nO Ash descobriu "+discovered.size()+" Pokemons.");
        }
    }

    //Gera um caminho aleatório com tamanho igual a n
    public static String pathGenerator(int n){
        String[] nsoe = {"N","S","O","E"};
        String path="";

        for(int i=0;i<n;i++){
            path=path.concat(nsoe[(int) (Math.random() * 3)]);
        }

        System.out.println(path);

        return path;
    }


}
