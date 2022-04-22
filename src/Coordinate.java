public class Coordinate {

    private int X;
    private int Y;

    public Coordinate(int x,int y){
        this.X=x;
        this.Y=y;
    }

    public void sum(int x, int y){
        this.X+=x;
        this.Y+=y;
    }

    public int[] toArray(){
        return new int[] {this.X,this.Y};
    }
}
