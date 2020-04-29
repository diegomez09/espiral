
package espiral;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Espiral extends JFrame implements ActionListener{
    BufferedImage buffer;
    Graphics graPixel;    
    Integer rad=0;
    Integer deg=0;
    
    public Espiral(){
        super("Espiral DFGG 17310120");        
        this.setBounds(800,10,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        this.setVisible(true);        
    }
    
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    
    public void draw_esp(int rad){
        rad = 50;
        deg=0;
        while(true){
            double radi = Math.toRadians(deg);
            double x = 250+(radi*(Math.cos(radi)));
            double y = 250+(radi*(Math.sin(radi)));            
            putPixel((int)x,(int)y, Color.BLACK);
            if(!((x-250)<=rad&&(y-250)<=rad)) break;
            deg++;
        }
    }
    
    public static void main(String[] args) {
       new Espiral().show();
    }
    
    @Override
    public void paint(Graphics g) {
       draw_esp(rad); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        repaint();        
    }
}
