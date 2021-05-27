package minesweeper;

public class Mine extends Cell{

    public Mine(boolean debugMode){this.debugMode=debugMode;}

    public void draw() {
        if (debugMode) {
            System.out.print("\u001b[31m");
        }
        if(this.isMarked()){
            System.out.print("*");
        } else {
            System.out.print(".");
        }
        if (debugMode) {
            System.out.print("\u001b[0m");
        }
    }
}
