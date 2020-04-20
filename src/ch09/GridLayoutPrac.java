package ch09;

import java.awt.Color;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutPrac extends JFrame {

	public GridLayoutPrac() {
		setTitle("GridLayoutPrac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		GridLayout grid = new GridLayout(4, 4);
		c.setLayout(grid);

//		JLabel [] label = new JLabel [16];
//		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
//				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
//				Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
//				Color.BLACK, Color.ORANGE, Color.BLUE,Color.MAGENTA}; 
//
//		for(int i=0; i<label.length; i++) {
//			label[i] = new JLabel(Integer.toString(i));
//			label[i].setOpaque(true);
//			label[i].setBackground(color[i]);
//			c.add(label[i]);
//		}


		for (int i = 0; i < 16; i++) {
			Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
					Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
					Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
					Color.BLACK, Color.ORANGE, Color.BLUE,Color.MAGENTA};
			//Color color = new Color((int)(Math.random()*100),255,255);
			JLabel j = new JLabel(i+"");
			j.setOpaque(true);
			j.setBackground(color[i]);
			c.add(j);
		}

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutPrac();
	}

}
