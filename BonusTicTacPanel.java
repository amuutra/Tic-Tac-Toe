package tictac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BonusTicTacPanel extends JPanel {
	
	private TicTacToeModel gameModel;
	private TicTacPanel parentPanel;
	
	public BonusTicTacPanel(TicTacToeModel model, TicTacPanel panel) {
		gameModel = model;
		parentPanel = panel;
		addComponents();
	}
	
	public void addComponents() {
		
		JButton resetGame = new JButton("New game");
		resetGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gameModel.resetGame();
				parentPanel.repaint();
			}
			
		});
		
		this.add(resetGame);
	}

}
