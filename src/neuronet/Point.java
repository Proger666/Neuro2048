package neuronet;

import general.ControllerNeuroNetForm;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Scorpa on 12/18/2015.
 */

  public class Point {

        //Draw neuroNode
        private Color col;

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    private double xPos;
        private double yPos;

        public Point(double x, double y) {
            this(x, y, Color.rgb((int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D)));
        }

        public Point(double x, double y, Color c) {
            this.xPos = x;
            this.yPos = y;
            this.col = c;
        }
        public void draw(ControllerNeuroNetForm controllerNeuroNetForm) {
            controllerNeuroNetForm.setStrokeColor(Color.BLACK);
            controllerNeuroNetForm.drawNodes(col,this.xPos,this.yPos,50.0D,50.0D);
        }
        public void setColor(int r, int g, int b) {
            this.col = Color.rgb(r, g, b);
        }

        public int getRed() {
            return (int)(this.col.getRed() * 255.0D);
        }

        public int getGreen() {
            return (int)(this.col.getGreen() * 255.0D);
        }

        public int getBlue() {
            return (int)(this.col.getBlue() * 255.0D);
        }


}
