import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Shape extends Rectangle {
	public int xSpeed, ySpeed;
	public Color color;
	
	public Shape(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
		setSpeeds();
	}
	
	public abstract void draw(Graphics g);
	
	public void setSpeeds() {
		Random rnd = new Random();
		xSpeed = (rnd.nextInt(2)+1);
		ySpeed = (rnd.nextInt(2)+1);
	}
	
	public void move(Rectangle canvas) {
		Random rnd = new Random();
		double xSpeed1 = xSpeed * (rnd.nextDouble() + 1);
		double ySpeed1 = ySpeed * (rnd.nextDouble() + 1);
		double distance = Math.sqrt(Math.pow(x-1000, 2)+Math.pow(y-1000, 2));
		double distanceNext = Math.sqrt(Math.pow(x+xSpeed1-1000, 2)+Math.pow(y+ySpeed1-1000, 2));

		if (distance <= 200) {
			x += (x - 1000)/100 - xSpeed1;
			y += (y - 1000)/100 - ySpeed1;
		}else {
			if (distanceNext < 200) {
				if (Math.abs(xSpeed) > Math.abs(ySpeed)) x -= xSpeed1;
				else y -= ySpeed1;
			}else {
				x += xSpeed1;
				y += ySpeed1;
			}		
		}
		
		if(canvas.contains(this)) return;
		
		if(x + width > canvas.width) {
			x = canvas.width - width;
			xSpeed = -xSpeed;		
		} else if(x < 0) {
			x = 0;
			xSpeed = -xSpeed;
		}
		if(y + height > canvas.height) {
			y = canvas.height - height;
			ySpeed = -ySpeed;
		} else if(y < 0) {
			y = 0;
			ySpeed = -ySpeed;
		}
	}
}
