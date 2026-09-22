

import java.util.Random;

public class CPU extends Game
{
    protected boolean CPU_Start = false;
    protected boolean CPU_Turn = false;

    private final int ROW = 3;
    private final int COL = 3;
    

    private char CPU_symbol;
    private char other_symbol;
    private char[][] board = new char[ROW][COL];

    Random random = new Random();
    int randomInt;
    int moves[] = {1, 3, 7, 9};

    CPU(char playerSymbol, char playerSymbol_2) 
    { 
        super(playerSymbol, playerSymbol_2); 
    }

    void set_CPU_Start(boolean start)
    {
        CPU_Start = start;
    }

    void set_CPU_Turn(boolean turn)
    {
        CPU_Turn = turn;
    }
    boolean get_CPU_Turn()
    {
        return CPU_Turn;
    }


    boolean get_CPU_Start()
    {
        return CPU_Start;
    }

    void fetchBoard()
    {
        board = getBoard();
    }

    void setCPUSymbol(char CPU) // assigned in App.java 
    {
        if(CPU == getSymbol_1())
        {
            CPU_symbol = getSymbol_1();
            other_symbol = getSymbol_2();
        }
        else
        {
            CPU_symbol = getSymbol_2();
            other_symbol = getSymbol_1();
        }
        
    }
    char getCPUSymbol()
    {
        return CPU_symbol;
    }
    char getOtherSymbol()
    {
        return other_symbol;
    }
    
// add moves that catch end with a missing middle for counter / win 
    int CPUmove()
    {
        fetchBoard();
        if(CPU_Error == true)
        {
            return 0; // testing 
        }
        
        if(CPU_Start == true)
        {
            int counter = 0;

            for(var i : board)
            {
                for(var x : i)
                {
                    if(x != getSymbol_1() || x != getSymbol_2())
                    {
                        counter++;
                        if(counter == 9)
                        {
                            int randomInt = moves[random.nextInt(4)];
                            CPU_Start = false;
                            return randomInt;
                        }
                    }
                    
                }
            }
        }

            if(board[1][1] != CPU_symbol && board[1][1] != other_symbol)
            {
                CPU_Turn = false;
                return 5;
            }
            if(board[0][0] == CPU_symbol && board[0][1] == CPU_symbol
            && board[0][2] != other_symbol)
            {
                CPU_Turn = false;
                return 3;
            }
            if(board[0][1] == CPU_symbol && board[0][2] == CPU_symbol
            && board[0][0] != other_symbol)
            {
                CPU_Turn = false;
                return 1;
            }
            if(board[0][0] == CPU_symbol && board[1][0] == CPU_symbol
            && board[2][0] != other_symbol)
            {
                CPU_Turn = false;
                return 7;
            }
            if(board[1][0] == CPU_symbol && board[1][1] == CPU_symbol
            && board[1][2] != other_symbol)
            {
                CPU_Turn = false;
                return 6;
            }
            if(board[1][1] == CPU_symbol && board[1][2] == CPU_symbol
            && board[1][0] != other_symbol)
            {
                CPU_Turn = false;
                return 4;
            }
            if(board[0][1] == CPU_symbol && board[1][1] == CPU_symbol
            && board[2][1] != other_symbol)
            {
                CPU_Turn = false;
                return 8;
            }
            if(board[0][2] == CPU_symbol && board[1][2] == CPU_symbol
            && board[2][2] != other_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[2][0] == CPU_symbol && board[2][1] == CPU_symbol
            && board[2][2] != other_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[2][1] == CPU_symbol && board[2][2] == CPU_symbol
            && board[2][0] != other_symbol)
            {
                CPU_Turn = false;
                return 7;
            }
            if(board[0][0] == CPU_symbol && board[1][1] == CPU_symbol
            && board[2][2] != other_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[0][2] == CPU_symbol && board[1][1] == CPU_symbol
            && board[2][0] != other_symbol)
            {
                CPU_Turn = false;
                return 7;
            }
            if(board[2][0] == CPU_symbol && board[1][0] == CPU_symbol
            && board[0][0] != other_symbol)
            {
                CPU_Turn = false;
                return 1;
            }
            if(board[2][1] == CPU_symbol && board[1][1] == CPU_symbol
            && board[0][1] != other_symbol)
            {
                CPU_Turn = false;
                return 2;
            }
            if(board[2][2] == CPU_symbol && board[1][2] == CPU_symbol
            && board[0][2] != other_symbol)
            {
                CPU_Turn = false;
                return 3;
            }
            if(board[0][0] == CPU_symbol && board[2][0] == CPU_symbol
            && board[1][0] != other_symbol)
            {
                CPU_Turn = false;
                return 4; 
            }
            if(board[0][2] == CPU_symbol && board[2][2] == CPU_symbol
            && board[1][2] != other_symbol)
            {
                CPU_Turn = false;
                return 6; 
            }
            if(board[0][0] == CPU_symbol && board[0][2] == CPU_symbol
            && board[0][1] != other_symbol)
            {
                CPU_Turn = false;
                return 2; 
            }
            if(board[1][0] == CPU_symbol && board[1][2] == CPU_symbol
            && board[1][1] != other_symbol)
            {
                CPU_Turn = false;
                return 5; 
            }
            if(board[1][0] == CPU_symbol && board[1][1] == CPU_symbol
            && board[1][2] != other_symbol)
            {
                CPU_Turn = false;
                return 6;
            }
            if(board[1][1] == CPU_symbol && board[1][2] == CPU_symbol
            && board[1][0] != other_symbol)
            {
                CPU_Turn = false;
                return 4;
            }
            if(board[2][0] == CPU_symbol && board[2][2] == CPU_symbol
            && board[2][1] != other_symbol)
            {
                CPU_Turn = false;
                return 8; 
            }
            
            // favorable moves here above

            if(board[0][0] == other_symbol && board[2][0] == other_symbol
            && board[1][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 4; 
            }
            if(board[0][2] == other_symbol && board[2][2] == other_symbol
            && board[1][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 6; 
            }
            if(board[0][0] == other_symbol && board[0][2] == other_symbol
            && board[0][1] != CPU_symbol)
            {
                CPU_Turn = false;
                return 2; 
            }
            if(board[1][0] == other_symbol && board[1][2] == other_symbol
            && board[1][1] != CPU_symbol)
            {
                CPU_Turn = false;
                return 5; 
            }
            if(board[1][0] == other_symbol && board[1][1] == other_symbol
            && board[1][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 6;
            }
            if(board[1][1] == other_symbol && board[1][2] == other_symbol
            && board[1][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 4;
            }
            if(board[2][0] == other_symbol && board[2][2] == other_symbol
            && board[2][1] != CPU_symbol)
            {
                CPU_Turn = false;
                return 8; 
            }
            if(board[0][0] == other_symbol && board[1][0] == other_symbol
            && board[2][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 7;
            }
            if(board[0][0] == other_symbol && board[0][1] == other_symbol
            && board[0][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 3;
            }
            if(board[0][0] == other_symbol && board[1][1] == other_symbol
            && board[2][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[0][2] == other_symbol && board[1][2] == other_symbol
            && board[2][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[0][1] == other_symbol && board[0][2] == other_symbol
            && board[0][0] != CPU_symbol)    
            {
                CPU_Turn = false;
                return 1;
            }
            if(board[0][1] == other_symbol && board[1][1] == other_symbol
            && board[2][1] != CPU_symbol)
            {
                CPU_Turn = false;
                return 8;
            }
            if(board[0][2] == other_symbol && board[1][1] == other_symbol
            && board[2][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 7;
            }
            if(board[2][0] == other_symbol && board[1][0] == other_symbol
            && board[0][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 1;
            }
            if(board[2][1] == other_symbol && board[1][1] == other_symbol
            && board[0][1] != CPU_symbol)
            {
                CPU_Turn = false;
                return 2;
            }
            if(board[2][2] == other_symbol && board[1][2] == other_symbol
            && board[0][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 3;
            }
            if(board[2][0] == other_symbol && board[1][1] == other_symbol
            && board[0][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 3;
            }
            if(board[2][2] == other_symbol && board[1][1] == other_symbol
            && board[0][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 1;
            }
            if(board[2][0] == other_symbol && board[2][1] == other_symbol
            && board[2][2] != CPU_symbol)
            {
                CPU_Turn = false;
                return 9;
            }
            if(board[2][2] == other_symbol && board[2][1] == other_symbol
            && board[2][0] != CPU_symbol)
            {
                CPU_Turn = false;
                return 7;
            }

            int[] availableMoves = new int[9];
            int availableMoveCount = 0;
            for (int row = 0; row < board.length; row++)
            {
                for (int col = 0; col < board[row].length; col++)
                {
                    if (board[row][col] != CPU_symbol && board[row][col] != other_symbol)
                    {
                        availableMoves[availableMoveCount++] = row * 3 + col + 1;
                    }
                }
            }

            if(availableMoveCount > 0)
            {
                randomInt = availableMoves[random.nextInt(availableMoveCount)];
                CPU_Turn = false;
                return randomInt;
            }

            return 0;
            
    }

}