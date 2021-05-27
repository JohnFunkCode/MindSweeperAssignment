package minesweeper;

public class MineBorder extends Cell{
    public int numberOfNearByMines ;

    public MineBorder( boolean debugMode, int numberOfNearByMines ){
        this.debugMode = debugMode ;
        this.numberOfNearByMines= numberOfNearByMines ;
    }

    public void draw(){
        System.out.print(Integer.toString(numberOfNearByMines));
    }
}
