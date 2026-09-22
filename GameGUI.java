import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameGUI extends JFrame
{
    private CPU game;
    private JButton[] boardButtons;
    private boolean cpuMode;
    private boolean xTurn;

    public GameGUI()
    {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 400);
        setLocationRelativeTo(null);
        showModeSelection();
        setVisible(true);
    }

    private void showModeSelection()
    {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("Choose game mode", SwingConstants.CENTER);
        JButton humanButton = new JButton("Human vs Human");
        JButton cpuButton = new JButton("Human vs CPU");

        humanButton.addActionListener(event -> startGame(false));
        cpuButton.addActionListener(event -> startGame(true));

        panel.add(title);
        panel.add(humanButton);
        panel.add(cpuButton);
        setContentPane(panel);
    }

    private void startGame(boolean playAgainstCpu)
    {
        cpuMode = playAgainstCpu;
        xTurn = true;
        game = new CPU('X', 'O');
        game.createBoard();
        game.setCPUSymbol('O');
        showBoard();
    }

    private void showBoard()
    {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        boardButtons = new JButton[9];
        for(int i = 0; i < boardButtons.length; i++)
        {
            boardButtons[i] = new JButton();
            boardButtons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
            boardButtons[i].addActionListener(new BoardButtonListener(i));
            panel.add(boardButtons[i]);
        }
        setContentPane(panel);
        setTitle(cpuMode ? "Tic Tac Toe - Human vs CPU" : "Tic Tac Toe - Human vs Human");
        revalidate();
        repaint();
    }

    private class BoardButtonListener implements java.awt.event.ActionListener
    {
        private final int position;

        BoardButtonListener(int position)
        {
            this.position = position;
        }

        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            if(game.isGameOver() || !boardButtons[position].getText().isEmpty())
            {
                return;
            }

            char symbol = xTurn ? game.getSymbol_1() : game.getSymbol_2();
            game.assign_choice_CPU(symbol, position + 1);
            updateBoard();

            if(game.isGameOver())
            {
                showResult();
                return;
            }

            if(cpuMode)
            {
                int cpuMove = game.CPUmove();
                game.assign_choice_CPU(game.getCPUSymbol(), cpuMove);
                updateBoard();
                if(game.isGameOver())
                {
                    showResult();
                }
                xTurn = true;
            }
            else
            {
                xTurn = !xTurn;
            }
        }
    }

    private void updateBoard()
    {
        char[][] board = game.getBoard();
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                char value = board[row][col];
                boardButtons[row * 3 + col].setText(value == 'X' || value == 'O' ? String.valueOf(value) : "");
            }
        }
    }

    private void showResult()
    {
        try
        {
            game.saveGameResult();
            game.write_to_file("Game_Results_Save.txt");
        }
        catch(IOException exception)
        {
            JOptionPane.showMessageDialog(this, "Could not save game results: " + exception.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }

        String result;
        if(game.getAssignWinner() == '\n')
        {
            result = "Draw";
        }
        else
        {
            result = "Player " + game.getAssignWinner() + " wins";
        }

        JPanel panel = new JPanel(new GridLayout(5, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        panel.add(new JLabel(result, SwingConstants.CENTER));
        panel.add(new JLabel("X wins: " + game.GetWinCount_1(), SwingConstants.CENTER));
        panel.add(new JLabel("O wins: " + game.GetWinCount_2() + " | Draws: " + game.GetDrawCount(), SwingConstants.CENTER));

        JButton pastGamesButton = new JButton("View Past Games");
        pastGamesButton.addActionListener(event -> showPastGames());
        panel.add(pastGamesButton);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(event -> resetGame());
        panel.add(newGameButton);
        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void resetGame()
    {
        game.resetBoard(false);
        xTurn = true;
        showBoard();
    }

    private void showPastGames()
    {
        StringBuilder games = new StringBuilder();
        int gameNumber = 1;
        for(char[][] savedBoard : game.pastGames)
        {
            games.append("Game ").append(gameNumber++).append("\n");
            for(char[] row : savedBoard)
            {
                games.append(row[0]).append(" | ").append(row[1]).append(" | ").append(row[2]).append('\n');
            }
            games.append('\n');
        }

        JTextArea textArea = new JTextArea(games.length() == 0 ? "No past games saved." : games.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Past Games", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}

