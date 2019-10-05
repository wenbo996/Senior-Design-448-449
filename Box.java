import java.awt.Color;
import java.awt.Graphics;

public class Box extends Shape {
	public Box(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);	
	}
}
