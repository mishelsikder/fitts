
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;


public class pet extends JPanel implements MouseListener{
public int count = 0;
public static JFrame frame = new JFrame("frame");
public pet() throws IOException{
 setPreferredSize(new Dimension(870, 675));         //configuring panel
 addMouseListener(this);
}
public static void main(String[] args) throws IOException{
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JComponent newContentPane = new pet();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);
    frame.pack();
    frame.setVisible(true);
    frame.addMouseListener(new pet());
}
public void paintRectangleAtPoint(Graphics g, int x, int y, int r){
g.setColor(Color.BLACK);
//g.(x, y, 100,100);
//x = x-(r/2);
//y = y-(r/2);
g.drawOval(x-r,y-r,r,r);
}
public void paintStuff(Graphics g, int x, int y, int r){
g.setColor(Color.BLACK);
//x = x-(r/2);
//y = y-(r/2);
g.drawOval(x -r,y - r,r,r);
}
long start = System.currentTimeMillis();
@Override
//long start = System.currentTimeMillis();
public void mouseClicked(MouseEvent e) {
//paintStuff(frame.getGraphics(),e.getX(), e.getY(), 80);
	
for (int i=0; i<4; i++){
	paintStuff(frame.getGraphics(),100+ count, 150, 80);
	count += 120;		
}
//counter.countPrimes(1000000);
long end = System.currentTimeMillis();

System.out.println(e.getX());
System.out.println(e.getY());
System.out.println("Took : " + ((end - start) / 1000));
}
@Override
public void mousePressed(MouseEvent e) {
// TODO Auto-generated method stub

}
@Override
public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

}
@Override
public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub

}
@Override
public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub

}
}
	


