//javac com/segma/Main.java
//java com.segma.Main
//javac -d . com/segma/Main.java
/**
 * the structure of the file is like this:
 * com/
 *  -segma/
 *     -Main.java
 */
package com.segma;
import java.util.Scanner;
import java.util.Random;
public class Main {
    private static String player1,player2;
    private static char player1xo,player2xo;
    private static char[] xo ={'X','O'};
    private static char[] button ={'1','2','3','4','5','6','7','8','9'};
    private static int count = 0;
    //player1 --> 0,2,4,6,8 even
    //player2 --> 1,3,5,7   odd
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        gameIntro();
        int b;
        while (count<9){
            gameGui(button);
            l1:{
              if (count % 2 == 0){// player1
                  System.out.print(player1+" choose a number: ");
                  if(scan.hasNextInt() & ( b=scan.nextInt()) != 0 ){
                      if (button[b-1] == 'X'||button[b-1]=='O') {
                          System.out.println("sorry :this number is already used");
                          break l1;
                      } else
                          button[b-1]= player1xo;
                  }else {
                      System.out.println("Wrong!!!:choose a number from 1 to 9");
                      break l1;
                  }
              }else {
                  System.out.print(player2+" choose a number: ");
                  if(scan.hasNextInt() & ( b=scan.nextInt()) != 0 ){
                      if (button[b-1] == 'X'||button[b-1]=='O') {
                          System.out.println("sorry :this number is already used");
                          break l1;
                      } else
                          button[b-1]= player2xo;
                  }else {
                      System.out.println("Wrong!!!:choose a number from 1 to 9");
                      break l1;
                  }
              }
              checkWhoIsWin();
              count++;
            }
        }
        System.out.println("\t****************");
        System.out.println("\t*  NOONE WIN   *");
        System.out.println("\t****************");

    }

    public static void gameIntro(){
        System.out.println("\n**********************************************************************************************************************");
        System.out.println("********************************************************************************************************************");
        System.out.println("*                                                                                                                  *");
        System.out.println("* ##########    #     ###   ###     ##########     ######       ###   ###       ##########  #########  ##########  *");
        System.out.println("* ##########   ###    ###  ###      ##########    ###  ###      ###  ###        ##########  ##     ##  ###         *");
        System.out.println("*    ###              ### ###          ###       ###    ###     ### ###            ###      ##     ##  ###         *");
        System.out.println("*    ###       ###    ######           ###      ############    ######             ###      ##     ##  #######     *");
        System.out.println("*    ###       ###    ### ###          ###     ###        ###   ### ###            ###      ##     ##  ###         *");
        System.out.println("*    ###       ###    ###  ###         ###    ###          ###  ###  ###           ###      ##     ##  ###         *");
        System.out.println("*    ###       ###    ###   ###        ###   ###            ### ###   ###          ###      #########  ##########  *");
        System.out.println("*                                                                                                                  *");
        System.out.println("********************************************************************************************************************");
        System.out.println("********************************************************************************************************************");

        //the player name
        Scanner name = new Scanner(System.in);
        System.out.print("player[1] enter your name :--> ");
        player1 = name.next();
        System.out.print("player[2] enter your name :--> ");
        player2 = name.next();
        // X & O
        Random type = new Random();
        player1xo = xo[type.nextInt(2)];
        if(player1xo == 'X')
            player2xo ='O';
        else
            player2xo ='X';
    }
    public static void gameGui(char[] button){
        System.out.println("###################################################################");
        System.out.println("player[1]: "+player1+"------>("+player1xo+")");
        System.out.println("player[2]: "+player2+"------>("+player2xo+")");
        System.out.println("\t*-----------*");
        System.out.println("\t| "+button[0]+" | "+button[1]+" | "+button[2]+" |");
        System.out.println("\t|---|---|---|");
        System.out.println("\t| "+button[3]+" | "+button[4]+" | "+button[5]+" |");
        System.out.println("\t|---|---|---|");
        System.out.println("\t| "+button[6]+" | "+button[7]+" | "+button[8]+" |");
        System.out.println("\t*__|___|__*");
    }
    public static void checkWhoIsWin(){
        if(     (button[0]==player1xo&button[1]==player1xo&button[2]==player1xo)|| 
                (button[3]==player1xo&button[4]==player1xo&button[5]==player1xo)||
                (button[6]==player1xo&button[7]==player1xo&button[8]==player1xo)||
                (button[0]==player1xo&button[3]==player1xo&button[6]==player1xo)||
                (button[1]==player1xo&button[4]==player1xo&button[7]==player1xo)||
                (button[2]==player1xo&button[5]==player1xo&button[8]==player1xo)||
                (button[0]==player1xo&button[4]==player1xo&button[8]==player1xo)||
                (button[2]==player1xo&button[4]==player1xo&button[6]==player1xo))
        {
                System.out.println("\t*************************************");
                System.out.println("\t* "+player1 + " you are win         *");
                System.out.println("\t*************************************");
                System.exit(0);
        }
        else if((button[0]==player2xo&button[1]==player2xo&button[2]==player2xo)||
                (button[3]==player2xo&button[4]==player2xo&button[5]==player2xo)||
                (button[6]==player2xo&button[7]==player2xo&button[8]==player2xo)||
                (button[0]==player2xo&button[3]==player2xo&button[6]==player2xo)||
                (button[1]==player2xo&button[4]==player2xo&button[7]==player2xo)||
                (button[2]==player2xo&button[5]==player2xo&button[8]==player2xo)||
                (button[0]==player2xo&button[4]==player2xo&button[8]==player2xo)||
                (button[2]==player2xo&button[4]==player2xo&button[6]==player2xo))
        {
                System.out.println("\t*************************************");
                System.out.println("\t* "+player2 + " you are win         *");
                System.out.println("\t*************************************");
                System.exit(0);
        }
    }

}