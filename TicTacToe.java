package tictac;

import javax.swing.JFrame;

public class TicTacToe {

	public TicTacToe(JFrame mainFrame) {
		TicTacToeModel ticTac = new TicTacToeModel();
		TicTacPanel panel = new TicTacPanel(ticTac);
		mainFrame.add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tic-Tac-Toe!");
		TicTacToe tictac = new TicTacToe(frame);
		
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}