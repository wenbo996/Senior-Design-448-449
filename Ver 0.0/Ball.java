

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.RandomAccessFile;
import java.util.Random;

public class Ball extends Shape {

	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);	
	}
	
//	@Override
//	public void move(Rectangle canvas) {
//		Random rnd = new Random();
//		x += xSpeed * (rnd.nextDouble() * 2);
//		y += ySpeed * (rnd.nextDouble() * 2);
//		
//		if(canvas.contains(this)) return;
//		
//		if(x + width > canvas.width) {
//			x = canvas.width - width;
//			xSpeed = -xSpeed;		
//		} else if(x < 0) {
//			x = 0;
//			xSpeed = -xSpeed;
//		}
//		
//		if(y + height > canvas.height) {
//			y = canvas.height - height;
//			ySpeed = -ySpeed;
//		} else if(y < 0) {
//			y = 0;
//			ySpeed = -ySpeed;
//		}
//	}
	
}
