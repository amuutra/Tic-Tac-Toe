package tictac;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TicTacToe {

	public TicTacToe(JFrame mainFrame) {
		TicTacToeModel ticTac = new TicTacToeModel();
		
		TicTacPanel panel = new TicTacPanel(ticTac);
		BonusTicTacPanel bonusPanel = new BonusTicTacPanel(ticTac, panel);
		
		mainFrame.add(panel);
		mainFrame.add(bonusPanel, BorderLayout.SOUTH);
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