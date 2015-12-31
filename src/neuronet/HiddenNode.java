package neuronet;

import javafx.scene.paint.Color;

/**
 * Created by Scorpa on 12/19/2015.
 */
public class HiddenNode extends Point {
        public HiddenNode(double x, double y) {
            super(x, y);
        }

        public HiddenNode(double x, double y, Color c) {
            super(x, y, c);
        }

        public void calculateColor(Synapse[] synapses) {
            double r = 0.0D;
            double g = 0.0D;
            double b = 0.0D;

            for(int i = 0; i < synapses.length; ++i) {
                r += (double)synapses[i].getSource().getRed() * synapses[i].getWeight();
                g += (double)synapses[i].getSource().getGreen() * synapses[i].getWeight();
                b += (double)synapses[i].getSource().getBlue() * synapses[i].getWeight();
            }

            if(r > 255.0D) {
                r = 255.0D;
            }

            if(g > 255.0D) {
                g = 255.0D;
            }

            if(b > 255.0D) {
                b = 255.0D;
            }

            this.setColor((int)r, (int)g, (int)b);
        }
}
