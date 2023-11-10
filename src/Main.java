import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame("Spirograph Generator 3001™");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the circle: ");
        double R = scanner.nextDouble();
        System.out.println("Enter the radius of the point: ");
        double r = scanner.nextDouble();
        System.out.println("Enter the offset of the point: ");
        double O = scanner.nextDouble();
        System.out.println("Enter the number of rotations: ");
        double desiredRotations = scanner.nextDouble();
        scanner.close();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 800));
        frame.add(panel);
        panel.repaint();
        frame.pack();
        frame.setVisible(true);
        new Spirograph(R, r, O, desiredRotations).draw(panel.getGraphics());
    }
}