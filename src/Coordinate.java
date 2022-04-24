public class Coordinate {

    private int X;
    private int Y;

    public Coordinate(int x,int y){
        this.X=x;
        this.Y=y;
    }

    public Coordinate sum(Coordinate direction){
        this.X+=direction.X;
        this.Y+=direction.Y;
        return this;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "X=" + X + ", Y=" + Y + '}';
    }

    //Hashcode passa a ger gerado da seguinte forma
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
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Coordinate coordinate = (Coordinate) obj;
        return (coordinate.hashCode() == this.hashCode());
    }

}
