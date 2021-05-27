package minesweeper;

public class Cell {
    // private enum CellState{ MARKED, UNMARKED, NUMBER};
    //private CellState state = CellState.UNMARKED;
    private boolean isVisible = false ;
    private int nearbyMines=0;
    private boolean markedAsMine = false ;
    //private boolean mine=false;
    protected boolean debugMode=false ;

    public Cell(){}
    public Cell( boolean debugMode){ this.debugMode=debugMode;}


    public boolean isMineBorder() {
        return (this instanceof MineBorder) ;
    }

    public boolean isMarked(){
        return (this.markedAsMine);
    }
    public boolean isUnMarked(){
        return (!this.markedAsMine);
    }

    public boolean isMine() { return this instanceof Mine;}
    public boolean isNotMine() { return !(this instanceof Mine);}

    public int getNearbyMines() { return nearbyMines;}
    public void setNearbyMines(int howManyMines) { nearbyMines=howManyMines;}

    public void makeMarked(){this.markedAsMine=true;}
    public void makeUnmarked(){this.markedAsMine=false;}
//    public void makeNumber(){
//        state = CellState.NUMBER;
//    }

    /* TBD simplify this using polymorphic behavior
       e.g. a mine can tell if it's consistent, and
       a border call can tell if it's consistent,
       and a free cell can tell if it's consistent
     */
    public boolean isConsistent() {
        boolean isSolved = true;
        //System.out.print("\n("+(x+1)+","+(y+1)+")");
        if (isMine()) {
            //System.out.print(" is a mine");
            if (isMarked()) {
                // it's a mine and it's marked it's ok
                //System.out.print(" is marked");
            } else {
                //System.out.print(" is not marked! <NOT DONE>");
                isSolved = false;
                return isSolved;
            }
        } else if (isMineBorder()) {
            // if it's a number no futher checks are necessary it's ok
            //System.out.print(" is a number");
        } else if (isNotMine()) {
            //System.out.print(" is not a mine");
            if (isUnMarked()) {
                //it's not a mine and it's unmarked it's ok
                //System.out.print(" is UnMarked");
            } else {
                //System.out.print(" is Marked <NOT DONE>");
                isSolved = false;
                return isSolved;
            }

        }
        return isSolved ;
    }

    public void draw(){}
}

