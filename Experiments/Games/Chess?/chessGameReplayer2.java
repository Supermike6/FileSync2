import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Experiments.functions.Formating;

import java.io.File;




public class chessGameReplayer2
{
    private static String[][] board = new String[8][8];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        path = "/Users/gbancroft25/Desktop/Chess games/gavin.game";
        
        ArrayList<String> lines = new ArrayList<>();
        // lines.add("default");
		try {
            sc.reset();
			sc = new Scanner(new File(path));
			while(sc.hasNextLine())
			{
                String nl = sc.nextLine();
                if(nl.length()==4)
                lines.add(nl);
			}
		} catch (FileNotFoundException e1) {e1.printStackTrace();}
        
        System.out.println(lines);
        sc.reset();
        sc = new Scanner(System.in);
        String cmd = "";
        int moveNum = 0;
        while(!cmd.equals("stop"))
        {
            cmd = sc.nextLine();
            System.out.println(cmd);
            System.out.println();
            String[][] filled = fillBoard();
            // printList(filled);

            if(cmd.equals("n"))
                moveNum++;
            if(cmd.equals("p"))
            {
                moveNum--;
                if(moveNum<0)
                    moveNum=0;
            }
            if(cmd.equals("start"))
                moveNum=0;
            if(cmd.equals("end"))
                moveNum = lines.size()-1;
            printList(doMove(lines, moveNum, filled));
        }
        Formating.textReset();
    }

    public static String[][] fillBoard()
    {
        String[][] out = new String[8][8];

        //pawns
        for(int y = 1; y<8; y+=5)
            for(int x = 0; x<8; x+=1)
            {
                out[y][x] = "p";
            }

        //air
        for(int y = 2; y<6; y+=1)
            for(int x = 0; x<8; x+=1)
            {
                out[y][x] = " ";
            }

        //rooks
        for(int y = 0; y<8; y+=7)
            for(int x = 0; x<8; x+=7)
            {
                out[y][x] = "r";
            }
            
        //knight
        for(int y = 0; y<8; y+=7)
            for(int x = 1; x<8; x+=5)
            {
                out[y][x] = "h";
            }
            
        //bishop
        for(int y = 0; y<8; y+=7)
            for(int x = 2; x<8; x+=3)
            {
                out[y][x] = "b";
            }

        //queen
        for(int y = 0; y<8; y+=7)
            for(int x = 3; x<8; x+=10)
            {
                out[y][x] = "q";
            }
            
        //queen
        for(int y = 0; y<8; y+=7)
            for(int x = 4; x<8; x+=10)
            {
                out[y][x] = "k";
            }

        return out;
    }

    public static void printList(String[][] sss)
    {
        boolean white = false;
        for(int i = 0; i<sss.length;i++)
        {
            Formating.textUnderlineWhite();
            System.out.print("|");
            for(int j = 0; j<sss[i].length;j++)
            {
                Formating.textUnderlineWhite();
                if(!white)
                {
                    white = !white;
                } else {
                    Formating.backgroundBoldBrightBlack();
                    white = !white;
                }
                System.out.print(sss[i][j]);
                Formating.backgroundReset();
                Formating.textUnderlineWhite();
                System.out.print("|");
            }
            white = !white;
            System.out.println();
        }
    }

    public static String[][] doMove(ArrayList<String> moves, int moveNum, String[][] board)
    {
        if(moveNum<moves.size())
        {
            for(int i = 0; i<moveNum; i++)
            {
                System.out.println(moves.get(i));
                char pt1 = moves.get(i).charAt(0);
                Integer pt2 = Integer.parseInt(moves.get(i).substring(1,2));
                char pt3 = moves.get(i).charAt(2);
                Integer pt4 = Integer.parseInt(moves.get(i).substring(3));
                board[pt4-1][(int)pt3-97] = board[pt2-1][(int)pt1-97];
                board[pt2-1][(int)pt1-97] = " ";

            }
            return board;
        } else {
            System.out.println("Move num to large");
        }
        return board;
    }
}
