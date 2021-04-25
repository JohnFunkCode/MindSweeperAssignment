package minesweeper;

import java.util.Random ;

public class Board {
    public static final int SIZE_X = 9;
    public static final int SIZE_Y = 9;

    minesweeper.Cell[][] cells;
    boolean debugMode = true;

    public Board() {
        cells = new Cell[SIZE_X][SIZE_X];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                cells[x][y] = new Cell();
            }
        }
    }

    public void renderBoard() {
        System.out.println();
        System.out.println(" |123456789|");
        System.out.println("-|---------|");

        for (int y = 0; y < SIZE_X; y++) {
            System.out.print((y + 1) + "|");
            for (int x = 0; x < SIZE_Y; x++) {
                if (cells[x][y].isMarked()) {
                    printWithHighlight(x, y, "*");
                } else if (cells[x][y].isNumber()) {
                    //System.out.print(cells[x][y].getNearbyMines());
                    printWithHighlight(x, y, Integer.toString(cells[x][y].getNearbyMines()));
                } else {
                    printWithHighlight(x, y, ".");
                }
            }
            System.out.println("|");
        }
        System.out.println("-|---------|");
    }

    private void printWithHighlight(int x, int y, String s) {
        if (debugMode && cells[x][y].isMine()) {
            System.out.print("\u001b[31m");
        }
        System.out.print(s);
        if (debugMode && (cells[x][y].isMine())) {
            System.out.print("\u001b[0m");
        }
    }

    public void placeMines(int numberOfMines) {
        Random random = new Random(1);

        if (numberOfMines > SIZE_X * SIZE_Y) {
            System.out.println("Maximum number of mines is " + SIZE_X * SIZE_Y);
            System.exit(1);
        }
        do {
            int x = random.nextInt(SIZE_X);
            int y = random.nextInt(SIZE_Y);
            if (cells[x][y].isNotMine()) {
                cells[x][y].makeMine();
                numberOfMines--;
            }
        } while (numberOfMines > 0);
    }

    public void calculateNearByMines() {
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if (cells[x][y].isNotMine()) {
                    int numberOfNearByMines = countNearByMines(x, y);
                    if (numberOfNearByMines > 0) {
                        cells[x][y].setNearbyMines(numberOfNearByMines);
                        cells[x][y].makeNumber();
                        ;
                    }
                }
            }
        }
    }

    private int countNearByMines(int x, int y) {
        int mineCount = 0;
        for (int localX = x - 1; localX <= x + 1; localX++) {
            if ((localX >= 0) && (localX < SIZE_X)) {
                for (int localY = y - 1; localY <= y + 1; localY++) {
                    if ((localY >= 0) && (localY < SIZE_Y)) {
                        if (cells[localX][localY].isMine()) {
                            mineCount++;
                            //                          System.out.println("Found a mine at " + localX + "," + localY);
                        }
                    }
                }
            }
        }
        return mineCount;
    }

    public void flipMineMarker(int x, int y) {
        if (cells[x][y].isNumber()) {
            System.out.println("There is a number here!");
        } else if (cells[x][y].isMarked()) {
            cells[x][y].makeUnmark();
        } else {
            cells[x][y].makeMarked();
        }
        renderBoard();
    }

    public boolean isBoardSolved() {
        boolean isSolved = true;
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if( !cells[x][y].isConsistent()) {
                    isSolved=false ;
                    return isSolved;
                }

            }
        }
        return isSolved;
    }
}
