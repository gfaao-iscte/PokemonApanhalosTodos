public class Coordinate {

    private int X;
    private int Y;

    public Coordinate(int x,int y){
        this.X=x;
        this.Y=y;
    }

    public Coordinate sum(int x, int y){
        this.X+=x;
        this.Y+=y;
        return this;
    }

    public int[] toArray(){
        return new int[] {this.X,this.Y};
    }
}
