public class Coordinates {

    //O Obejcto Coordinates tem 2 atributos
    //X para a coordenada do Ash no eixo do X
    //e Y para a coordenada do Ash no eixo do Y.
    private int X;
    private int Y;

    //Para inicializar o objecto é preciso
    //dar como argumentos as coordenadas para
    //posição inicial do Ash.
    public Coordinates(int x, int y){
        this.X=x;
        this.Y=y;
    }

    //sum() permite somar as coordenadas de dois obejctos Coordenadas.
    public Coordinates sum(Coordinates direction){
        this.X+=direction.X;
        this.Y+=direction.Y;
        return this;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "X=" + X + ", Y=" + Y + '}';
    }

    //hashcode() passa a gerar o hashcode de um objecto Coordenada
    // da seguinte forma
    //Caso 1 - ambas as coordenadas positivas
    //Hashcode => 1xy
    //Caso 2 - ambas as variaveis negativas
    //Hashcode => 2|x||y|
    //Caso 3 - x positivo e y negativo
    //Hashcode => 3x|y|
    //Caso 4 - x negativo e y positivo
    //Hashcode => 4|x|y
    @Override
    public int hashCode(){
        int x = this.X;
        int y = this.Y;
        String num;
        if (x>=0 && y>=0){
            num = "1"+String.valueOf(x)+String.valueOf(y);
        }else if(x<0 && y<0){
            num = "2"+String.valueOf(-x)+String.valueOf(-y);
        }else if(x>=0 && y<0){
            num = "3"+String.valueOf(x)+String.valueOf(-y);
        }else {
            num = "4"+String.valueOf(-x)+String.valueOf(y);
        }
        return Integer.parseInt(num);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Coordinates coordinates = (Coordinates) obj;
        return (coordinates.hashCode() == this.hashCode());
    }

}
