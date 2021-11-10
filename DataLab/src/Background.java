import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	//add location attributes
	private int x, y; //position of the bird
	private Image img; 	
	private AffineTransform tx;
	private double scaleW = 1.0, scaleH = 2.0;

	public Background(int x, int y) {
		img = getImage("sunny.jpg"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
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
