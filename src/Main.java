import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class Main {

    private static Coordinate position = new Coordinate(0,0);
    private static HashMap<Character,Coordinate> directionSum = new HashMap<>(){{
        put('N', new Coordinate(0,1));
        put('S', new Coordinate(0,-1));
        put('E', new Coordinate(1,0));
        put('O', new Coordinate(-1,0));
    }};
    private static HashSet<Coordinate> discovered = new HashSet<>();
    public static void main(String[] args){
        while (true) {
            discovered = new HashSet<>();
            System.out.println("\nPokemon: Apanhá-los Todos");
            System.out.println("Insere quantos Ns, Ss, Es, ou Os, para o Ash se deslocar: ");

            String route = new Scanner(System.in).nextLine();
            //route = pathGenerator(500000);

            //System.out.println("\n"+position.toString());
            discovered.add(position);
            for (char direction : route.toCharArray()) {
                //System.out.println(position.toString());
                try {
                    position = position.sum(directionSum.get(direction));
                    discovered.add(position);
                }catch (Exception e){
                    //System.out.println("Caracter Inválido");
                }
            }
            System.out.println("\nO Ash Descobriu "+discovered.size()+" Pokemons.");
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
