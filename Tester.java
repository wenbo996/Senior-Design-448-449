

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel {

	JFrame window = new JFrame("Map");
	Random rnd = new Random();
	Timer tmr = null;
	ArrayList<Shape> shapes = new ArrayList<>();
	int ts = 0;
	public Tester() {
		window.setBounds(100, 100, 500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(this);
		window.setAlwaysOnTop(true);
		window.setVisible(true);
		//============================================================== Events
		tmr = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Shape s : shapes)
					s.move(getBounds());
					System.out.println("ok");
				repaint();
			}	
		});
		addMouseListener(new MouseListener() {	
			@Override
			public void mousePressed(MouseEvent e) {
				for(Shape s : shapes) {
					if((s instanceof Breakable) &&  s.contains(e.getPoint())) {
						Shape shape = ((Breakable)s).breakApart();
						if(shape == null) {
							shapes.remove(s);
						} else {
							shapes.add(shape);
						}

						return;
					}
				}
				tmr.start();
				shapes.clear();
				for(int i = 0; i < 20; i++) {
					shapes.add(new Ball(
							rnd.nextInt(getWidth()),
							rnd.nextInt(getHeight()),
							20,20,
							Color.RED
							));

					shapes.add(new Box(
							rnd.nextInt(getWidth()),
							rnd.nextInt(getHeight()),
							20,20,
							Color.YELLOW
							));
				}
				shapes.add(new Target(
						e.getX()-25, //rnd.nextInt(getWidth()),
						e.getY()-25, //rnd.nextInt(getHeight()),
						50,50,
						Color.RED
						));
			}
			
//			private boolean checkGameOver() {
//				for(Shape s : shapes) if(s instanceof Breakable) return false;
//				return true;
//			}
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseClicked(MouseEvent e) {}
		});
		//============================================================== End Events
		tmr.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//====== From here down draw whatever you want
		for(Shape s : shapes) 
			s.draw(g);
	}


	public static void main(String[] args) {
		new Tester();
	}

}
