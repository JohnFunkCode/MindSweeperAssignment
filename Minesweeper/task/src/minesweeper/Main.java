package minesweeper;
import java.util.Scanner;
import java.util.Arrays ;
import java.util.Random ;

public class Main {
    static final int SIZE_X = 9;
    static final int SIZE_Y = 9;
    static final char MINE = 'X';
    static final char NO_MINE = '.';
    static final char ASCII_ZERO = 48;

    static char[][] mineField = new char[SIZE_X][SIZE_Y];


    public static void main(String[] args) {
        Random random = new Random(1) ;

        for (int i = 0; i < SIZE_Y; i++) {
            Arrays.fill(mineField[i], NO_MINE);
        }

        Scanner scanner = new Scanner(System.in) ;
        System.out.print("How many mines do you want on the field?");
        int numberOfMines = scanner.nextInt();
        if(numberOfMines > SIZE_X*SIZE_Y){
            System.out.println("Maximum number of mines is " + SIZE_X*SIZE_Y);
            System.exit(1);
        }
        do {
            int x = random.nextInt(SIZE_X);
            int y = random.nextInt(SIZE_Y);
            if( mineField[x][y]==NO_MINE){
                mineField[x][y]='X' ;
                numberOfMines--;
            }
        } while(numberOfMines > 0) ;


/*
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                System.out.print(mineField[x][y]);
            }
            System.out.println();
        }
*/

        /*   new stuff   */
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if (mineField[x][y] == NO_MINE) {
                    int numberOfNearByMines = countNearByMines(x, y);
                    if( numberOfNearByMines > 0) {
                        mineField[x][y] = (char) (numberOfNearByMines + ASCII_ZERO);   
                    }
                }
            }
        }

//        System.out.println("\nNew Map\n");

        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                System.out.print(mineField[x][y]);
            }
            System.out.println();
        }


        }
    private static int countNearByMines(int x, int y) {
        int mineCount = 0 ;
        for(int localX = x-1; localX <= x+1; localX++) {
            if( (localX >= 0) && (localX < SIZE_X)) {
                for( int localY = y-1; localY <= y+1; localY++) {
                    if( (localY >=0) && (localY < SIZE_Y)) {
                        if(mineField[localX][localY]==MINE) {
                            mineCount++;
  //                          System.out.println("Found a mine at " + localX + "," + localY);
                        }
                    }
                }
            }
        }
        return mineCount;
    }
}


