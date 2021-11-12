import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import core.data.DataSource;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {

	// CREATE THE OBJECT (STEP 1)
	Background bg = new Background(0, 0);

	// Scoring variables
	int score = 0;

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//Paints background
		bg.paint(g);
		
		//Copied from ActionsPerformed
		String id1 = "KATL";
		DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml");
		ds1.setCacheTimeout(15 * 60);
		ds1.load();
		Observation ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");
		//Copied from ActionsPerformed
		//Paints stats
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(id1 + ":", 150,480);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString(""+ob1, 40,500);

	}

	public static void main(String[] arg) {
		Frame f = new Frame();
	}

	public Frame() {
		JFrame f = new JFrame("Saturday Night Live");
		f.setSize(new Dimension(400, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1, 2));
		f.addMouseListener(this);
		f.addKeyListener(this);

		Timer t = new Timer(2048, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		bg.changePicture("sunny.jpg");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		String id1 = "KATL";
		DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml");
		ds1.setCacheTimeout(15 * 60);
		ds1.load();
		// ds1.printUsageString();

		Observation ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");
		System.out.println(id1 + ": " + ob1);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
