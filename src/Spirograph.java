import java.awt.*;

public class Spirograph {
    private double R;
    private double r;
    private double O;
    private double desiredRotations;

    public Spirograph(double CircleRadius, double PointRadius, double Offset, double desiredRotations){
        R = CircleRadius;
        r = PointRadius;
        O = Offset;
        this.desiredRotations = desiredRotations;
    }

    public void draw(Graphics g){
        int x, y, prevX = 0, prevY = 0;
        double theta = 0;
        double deltaTheta = 0.0001;
        int centerX = 400;
        int centerY = 400;

        prevX = (int) ((R-r)*Math.cos(theta) + O*Math.cos(((R-r)/r)*theta));
        prevY = (int) ((R-r)*Math.sin(theta) - O*Math.sin(((R-r)/r)*theta));

        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(2));
        while(theta < desiredRotations * 2 * Math.PI){
            x = (int) ((R-r)*Math.cos(theta) + O*Math.cos(((R-r)/r)*theta));
            y = (int) ((R-r)*Math.sin(theta) - O*Math.sin(((R-r)/r)*theta));
            g2D.drawLine(centerX + prevX, centerY + prevY, centerX + x, centerY + y);

            prevX = x;
            prevY = y;
            theta += deltaTheta;

            try {
                Thread.sleep((long) 0.2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
