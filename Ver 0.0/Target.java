import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Target extends Shape implements Breakable {
	private int hitCount = 0;
	
	public Target(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public Shape breakApart() {
		if(++hitCount == 2) return null;
		width /= 2;
		height /= 2;
		setSpeeds();
		Target t = new Target(x, y, width, height, color);
		t.hitCount = hitCount;
		return t;
	}
	
	@Override
	public void move(Rectangle canvas) {
		Random rnd = new Random();
		x = 1000;
		y = 1000;
		
		if(canvas.contains(this)) return;
		
		if(x + width > canvas.width) {
			x = canvas.width - width;
			xSpeed = -xSpeed;		
		} else if(x < 0) {
			x = 0;
			xSpeed = -xSpeed;
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.WHITE);
		g.fillOval(x+5, y+5, width-10, height-10);
		g.setColor(color);
		g.fillOval(x+10, y+10, width-20, height-20);
		g.setColor(Color.WHITE);
		g.fillOval(x+15, y+15, width-30, height-30);
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);		
		g.drawOval(x+5, y+5, width-10, height-10);
		g.drawOval(x+10, y+10, width-20, height-20);
		g.drawOval(x+15, y+15, width-30, height-30);
	}



	
	
}
