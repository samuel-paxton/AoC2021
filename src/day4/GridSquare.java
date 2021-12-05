package day4;

public class GridSquare {
    public int number;
    public boolean marked;

    public GridSquare(int number) {
        this.number = number;
        this.marked = false;
    }

    public GridSquare(int number, boolean marked) {
        this.number = number;
        this.marked = marked;
    }
}
