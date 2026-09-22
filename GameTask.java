public class GameTask
{
    char board[][] = new char[3][3];

    char playerSymbol;
    char playerSymbol2;
   
    boolean endGameToggle = false;
    boolean DrawGame = false;

    // used only for the count of the positions on game board for draw game feature to work
    int positionCounted = 0;

    private int row, col;
    
    public void setPlayerSymbol(char playerSymbol, char playerSymbol2)
    {
        this.playerSymbol = playerSymbol;
        this.playerSymbol2 = playerSymbol2;
    }

    public char getPlayerSymbol()
    {
        return playerSymbol;
    }

    public char getPlayerSymbol_2()
    {
        return playerSymbol2;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    final int getRow()
    {
        return row;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    final int getCol()
    {
        return col;
    }

    final char[][] getBoard()
    {
        return board;
    }

    public void setBoard(int currentRow, int currentCol, char symbol)
    {
        board[currentRow][currentCol] = playerSymbol;
    }

    public void setBoardPlayer2(int currentRow, int currentCol, char symbol)
    {
        board[currentRow][currentCol] = playerSymbol2;
    }
    
    public void clearBoard()
    {
        endGameToggle = false;

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    public int endGame()
    {
        if(endGameToggle == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public void decideWinner()
    {
        if(board[0][0] == playerSymbol && board[0][0] == board[0][1] && board[0][1] == board[0][2])
        {
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }   
            if(board[0][0] == playerSymbol2 && board[0][0] == board[0][1] && board[0][1] == board[0][2])
            {
                
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[1][0] == playerSymbol && board[1][0] == board[1][1] && board[1][1] == board[1][2])
        {
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[1][0] == playerSymbol2 && board[1][0] == board[1][1] && board[1][1] == board[1][2])
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[2][0] == playerSymbol && board[2][0] == board[2][1] && board[2][1] == board[2][2])
        {
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[2][0] == playerSymbol2 && board[2][0] == playerSymbol)
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[0][0] == playerSymbol && board[0][0] == board[1][0] && board[1][0] == board[2][0])
        {    
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }  
            if(board[0][0] == playerSymbol2 && board[0][0] == board[1][0] && board[1][0] == board[2][0])
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }

        if(board[0][1] == playerSymbol && board[0][1] == board[1][1] && board[1][1] == board[2][1])
        {
                
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[0][1] == playerSymbol2 && board[0][1] == board[1][1] && board[1][1] == board[2][1])
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[0][2] == playerSymbol && board[0][2] == board[1][2] && board[1][2] == board[2][2])
        { 
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[0][2] == playerSymbol2 && board[0][2] == board[1][2] && board[1][2] == board[2][2])
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[0][0] == playerSymbol && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        { 
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[0][0] == playerSymbol2 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            {
                
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
        if(board[0][2] == playerSymbol && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            endGameToggle = true;
            PLayer1_winCount++;
            PLayer2_lossCount++;
            
        }
            if(board[0][2] == playerSymbol2 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            {
                endGameToggle = true;
                PLayer2_winCount++;
                PLayer1_lossCount++;
                
            }
        
            else
            {
                for(var itr = 0; itr != board.length; itr++)
                {
                    for(var itr2 = 0; itr2 != board[itr].length; itr2++)
                    {
                        if(board[itr][itr2] == playerSymbol || board[itr][itr2] == playerSymbol2)
                        {
                            positionCounted++;
                        }
                        else
                        {
                            positionCounted = 0;
                            break;
                        }
                        if(positionCounted == 9)
                        {
                            endGameToggle = true;
                            drawCount++;
                        }
                    }
                }

            }
          
    }


    //TESTING BACKGROUND FEATURES

    void outputboard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int PLayer1_winCount = 0;
    private int PLayer2_winCount = 0;

    private int PLayer1_lossCount = 0;
    private int PLayer2_lossCount = 0;
    

    private int drawCount = 0;
    
    final int getWinCount_Player1()
    {
        return PLayer1_winCount;
    }
    final int getWinCount_Player2()
    {
        return PLayer2_winCount;
    }

    final int getLossCount_Player1()
    {
        return PLayer1_lossCount;
    }
    final int getLossCount_Player2()
    {
        return PLayer2_lossCount;
    }

    final int getDrawCount()
    {
        return drawCount;
    }

}
