package minesweeper;
import java.util.Scanner;


public class Game {
    Board theBoard = new Board();
    private int numberOfMines ;

    public int getNumberOfMines() { return numberOfMines; }

    public void initialize(){
        Scanner scanner = new Scanner(System.in) ;
        System.out.print("How many mines do you want on the field?");
        numberOfMines = scanner.nextInt();
        if(numberOfMines > Board.SIZE_X*Board.SIZE_Y){
            System.out.println("Maximum number of mines is " + Board.SIZE_X*Board.SIZE_Y);
            System.exit(1);
        }

        theBoard.placeMines(numberOfMines);
        theBoard.calculateNearByMines();
        theBoard.renderBoard();
    }


    public void playOneRound(){
        Scanner scanner = new Scanner(System.in) ;
        System.out.print("Set/delete mine marks (x and y coordinates):");
        String UserInput = scanner.nextLine();
        String[] inputsArray = UserInput.split(" ");
        if(inputsArray.length !=2){
            System.out.println("incorrect number of inputs please input x and y with a space between them");
        }
        int inputX=Integer.parseInt(inputsArray[0]);
        --inputX;
        int inputY=Integer.parseInt(inputsArray[1]);
        --inputY;
        //System.out.println("X="+inputX+" Y="+inputY);

        theBoard.flipMineMarker(inputX,inputY);

    }

    public boolean IsSolved() {
        if (theBoard.isBoardSolved()) {
            System.out.println("Congratulations! You found all the mines!");
            return true;
        } else {
            return false;
        }
    }
}
