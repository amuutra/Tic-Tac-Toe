package tictac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TicTacPanel extends JPanel implements MouseListener {

	private TicTacToeModel gameModel;
	
	public TicTacPanel(TicTacToeModel model) {
		gameModel = model;
		this.addMouseListener(this);
	}
	
	private Dimension getSquareCoords(int square) {
		
		Dimension x = new Dimension(0, 0);
		
		if(square == 1) {
			x.height = 0;
			x.width = 0;
		}
		
		if(square == 2) {
			x.height = 0;
			x.width = this.getWidth()/3;
		}
		
		if(square == 3) {
			x.height = 0;
			x.width = (this.getWidth()/3) * 2;
		}
		
		if(square == 4) {
			x.height = this.getHeight() / 3;
			x.width = 0;
		}
		
		if(square == 5) {
			x.height = this.getHeight() / 3;
			x.width = this.getWidth() / 3;
		}
		
		if(square == 6) {
			x.height = this.getHeight() / 3;
			x.width = (this.getWidth() / 3) * 2;
		}
		
		if(square == 7) {
			x.height = (this.getHeight() / 3) * 2;
			x.width = 0;
		}
		
		if(square == 8) {
			x.height = (this.getHeight() / 3) * 2;
			x.width = this.getWidth() / 3;
		}
		
		if(square == 9) {
			x.height = (this.getHeight() / 3) * 2;
			x.width = (this.getWidth() / 3) * 2;
		}
		
		return x;
	}
	
	public int getClickedSquare(int x, int y) {
		
		if(x > 0 && x < this.getWidth() / 3 ) {
			
			if(y < this.getHeight()/3) {
				return 1;
			}
			
			if(y > this.getHeight()/3 && y < (this.getHeight()/3) * 2) {
				return 4;
			}
			
			if(y > (this.getHeight()/3) * 2 && y < this.getHeight()) {
				return 7;
			}
			
		}
		
		if(x > this.getWidth()/3 && x < (this.getWidth() / 3) * 2 ) {
			
			if(y < this.getHeight()/3) {
				return 2;
			}
			
			if(y > this.getHeight()/3 && y < (this.getHeight() / 3) * 2) {
				return 5;
			}
			
			if(y > (this.getHeight() / 3) * 2 && y < this.getHeight()) {
				return 8;
			}
			
		}
		
		if(x > (this.getWidth() / 3) * 2 && x < this.getWidth()) {
			
			if(y < this.getHeight()/3) {
				return 3;
			}
			
			if(y > this.getHeight()/3 && y < (this.getHeight() / 3) * 2) {
				return 6;
			}
			
			if(y > (this.getHeight() / 3) * 2 && y < this.getHeight()) {
				return 9;
			}	
		}
			
		return 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i <= 3; i++) {
			g.drawLine((this.getWidth()/3) * i, 0, (this.getWidth()/3) * i, this.getHeight());
		}
		
		for(int j = 0; j <= 3; j++) {
			g.drawLine(0, (this.getHeight()/3) * j, this.getWidth(), (this.getHeight()/3) * j);	
		}
		
		for(int i = 1; i <= 9; i++) {
			
			if(gameModel.getSquare(i) == 1) {
				g.setColor(Color.GREEN);
				g.drawLine(getSquareCoords(i).width, getSquareCoords(i).height, getSquareCoords(i).width + (this.getWidth() / 3), getSquareCoords(i).height + (this.getHeight() / 3));
				g.drawLine(getSquareCoords(i).width + (this.getWidth()/3), getSquareCoords(i).height, getSquareCoords(i).width, getSquareCoords(i).height + (this.getHeight() / 3));
			}
			
			if(gameModel.getSquare(i) == 2) {
				g.setColor(Color.RED);
				g.drawOval(getSquareCoords(i).width + 5, getSquareCoords(i).height + 5, this.getWidth()/3 - 10, this.getHeight()/3 - 10);
			}
			
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gameModel.placeShape(getClickedSquare(e.getX(), e.getY()));
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {		
	}
	
}