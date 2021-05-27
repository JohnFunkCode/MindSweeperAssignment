package minesweeper;

public class Free extends Cell{
    public Free(boolean debugMode){this.debugMode=debugMode;}

    public void draw(){
        System.out.print('.');
    }

}
