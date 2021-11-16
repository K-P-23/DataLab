import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	private double scaleW = 0.5, scaleH = 0.5;

	public Background(int x, int y) {
		img = getImage("churchOfGod.jpg");
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		update();
		g2.drawImage(img, tx, null);
		
		

	}
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(scaleW, scaleH);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleW, scaleH);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
