import java.util.HashMap;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){

        int pokedex = 1;

        Coordinate position = new Coordinate(0,0);

        HashMap<Character,Coordinate> directionMath = new HashMap<Character,Coordinate>();
        directionMath.put('N', position.sum(0,1));
        directionMath.put('S', position.sum(0,-1));
        directionMath.put('E', position.sum(1,0));
        directionMath.put('O', position.sum(-1,0));

        HashMap<int[],Coordinate> discovered = new HashMap<int[], Coordinate>();
        discovered.put(position.toArray(),position);

        System.out.println("\nPokemon: Apanhá-los Todos\n");

        System.out.println("Insere quantos Ns, Ss, Es, ou Os, para o Ash se deslocar\n");

        String viagem = new Scanner(System.in).nextLine();

        for (char direction: viagem.toCharArray()) {
            directionMath.get(direction);
            System.out.println(position.toArray()[0]+","+position.toArray()[1]);
            if (!discovered.containsKey(position.toArray())){
                pokedex+=1;
                discovered.put(position.toArray(),position);
            }
        }
        System.out.println(pokedex);

    }
}
