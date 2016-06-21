import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fitts extends JFrame implements MouseListener, MouseMotionListener {

	JLabel mousePosition;

	public void mouseClicked(MouseEvent e) {
		mousePosition.setText("Mouse clicked at coordinate : [" + e.getX()
				+ "," + e.getY() + "]");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mousePosition.setText("Current mouse Coordinates : [" + e.getX() + ","
				+ e.getY() + "]");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mousePosition.setText("Mouse outside access window");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePosition.setText("Mouse pressed at coordinates : [" + e.getX()
				+ "," + e.getY() + "]");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePosition.setText("Current mouse coordinates : [" + e.getX() + ","
				+ e.getY() + "]");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePosition.setText("Mouse dragged at coordinates : [" + e.getX()
				+ "," + e.getY() + "]");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition.setText("Mouse moved to coordinates : [" + e.getX() + ","
				+ e.getY() + "]");
	}

	public static void main(String args[]) {
		StdDraw.circle(0.5, 0.5, 0.3);
		new Fitts().start();
	}

	public void start() {
		mousePosition = new JLabel();
		addMouseListener(this); // listens for own mouse and
		addMouseMotionListener(this);
		// mouse-motion events
		setLayout(new FlowLayout(1));
		add(mousePosition);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
