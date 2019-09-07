package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Torres extends JPanel{
	
	protected void paintComponent(Graphics graph) {
		super.paintComponent(graph);
		Graphics2D g = (Graphics2D) graph;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		BasicStroke torre1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g.setStroke(torre1);
		g.drawLine(100, 40, 100, 300);
		
		BasicStroke torre2 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g.setStroke(torre2);
		g.drawLine(340, 40, 340, 300);
		
		BasicStroke torre3 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g.setStroke(torre3);
		g.drawLine(580, 40, 580, 300);
	}
}
