import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the (X,O) board game");
        String [][] boardGame ={{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        String [] players = getPlayers();

        int userInput =0;
        int countPlays =0;

        printBoardGame(boardGame);
        do {
            System.out.println("please enter your position ");

            userInput = input.nextInt();


            if (userInput < 1 || userInput > 9) System.out.println("Please enter a number between 1 and 9");


            int Position[] = getBoardPosition(userInput);

            if(boardGame[Position[0]][Position[1]].equals("X") || boardGame[Position[0]][Position[1]].equals("O")){
                printBoardGame(boardGame);
                System.out.println("this position already taken :"+userInput);
                continue;
            }
            boardGame[Position[0]][Position[1]]=players[0];
            countPlays++;

            if(checkWin(boardGame)){

            }

            if(countPlays <9){
                boardGame =computerPLay(boardGame,players);
                countPlays++;
            }




            printBoardGame(boardGame);
            if(countPlays == 9)break;
        }while (true);




    }

    public static void printBoardGame(String [][] boardGame){

        String boardRows = "";
        for(int i=0;i<boardGame.length;i++){
            boardRows = "";
            for(int j=0;j<boardGame[i].length;j++){
                boardRows += boardGame[i][j];
                if(j == boardGame[i].length-1)continue;
                boardRows += "│";
            }
            System.out.println(boardRows);
            if(i == boardGame.length-1)continue;
            System.out.println("━━━━━");
        }
    }

    public static String[] getPlayers(){
        Scanner input = new Scanner(System.in);
        String [] players = {"",""};
        do {

            System.out.println("PLease choose you want play X or O");
            players[0] = input.nextLine();
            if (players[0].equals("X") || players[0].equals("O")) {
                break;
            }else System.out.println("Invalid input ,please choose only X or O");
        }while (true);
        players[1] = players[0].equals("X")  ? "O" : "X";

        return players;
    }
    public static int[] getBoardPosition(int Position){

        switch (Position){
            case 1:
                return new int[]{0,0};
                case 2:
                    return new int[]{0,1};
                    case 3:
                        return new int[]{0,2};
                        case 4:
                            return new int[]{1,0};
                            case 5:
                                return new int[]{1,1};
                                case 6:
                                    return new int[]{1,2};
                                    case 7:
                                        return new int[]{2,0};
                                        case 8:
                                            return new int[]{2,1};
                                            case 9:
                                                return new int[]{2,2};
                                                default: return new int[]{100,100};


        }
    }

    public static  String[][] computerPLay(String [][] boardGame , String[] players){
        int randomPlay= 0;
        do {
            randomPlay = (int)((Math.random()*(10-1))+1);
            int Position[] = getBoardPosition(randomPlay);

            if(boardGame[Position[0]][Position[1]].equals("X") || boardGame[Position[0]][Position[1]].equals("O")){
                continue;
            }
            boardGame[Position[0]][Position[1]]=players[1];
            break;
        }while (true);
        return boardGame;
    }
    public static boolean checkWin(String[][] boardGame){
        int countRepetition = 0;
        String playerCheck ="";
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j < boardGame[i].length; j++) {

                if(j == 0 ){
                    playerCheck = boardGame[i][j].equals("X")  ? "X" : "O";
                    countRepetition= 0;
                }
                if (playerCheck == boardGame[i][j]) {
                    countRepetition++;
                }
            }
            if (countRepetition == 3) break;
        }
        return countRepetition == 3;
    }


}