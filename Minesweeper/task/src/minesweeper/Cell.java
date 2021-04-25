package minesweeper;

public class Cell {
    private enum CellState{ MARKED, UNMARKED, NUMBER};
    private CellState state = CellState.UNMARKED;
    private int nearbyMines=0;
    private boolean mine=false;

    public Cell(){}

    public boolean isNumber() {
        return (state == CellState.NUMBER) ;
    }

    public boolean isMarked(){
        return (state == CellState.MARKED);
    }
    public boolean isUnMarked(){
        return (state == CellState.UNMARKED);
    }

    public boolean isMine() { return mine;}
    public boolean isNotMine() { return !mine;}
    public void makeMine() { mine=true;}

    public int getNearbyMines() { return nearbyMines;}
    public void setNearbyMines(int howManyMines) { nearbyMines=howManyMines;}

    public void makeMarked(){
        state = CellState.MARKED ;
    }
    public void makeUnmark(){
        state = CellState.UNMARKED;
    }
    public void makeNumber(){
        state = CellState.NUMBER;
    }

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
        } else if (isNumber()) {
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

}

