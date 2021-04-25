package minesweeper;
import java.util.Scanner;
import java.util.Arrays ;
import java.util.Random ;

import minesweeper.Board;

public class Main {
    public static void main(String[] args) {
        Game theGame = new Game();
        theGame.initialize();
        int minRounds = theGame.getNumberOfMines();

        while(true) {
            theGame.playOneRound();
            minRounds -=1;
            if(minRounds < 1){
                // no need to test if we haven't at least run as many rounds as there are mines
                if(theGame.IsSolved()) {
                    break;
                }
            }
        }

    }
}

