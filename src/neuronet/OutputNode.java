package neuronet;

import javafx.scene.paint.Color;


/**
 * Created by Scorpa on 12/19/2015.
 */
public class OutputNode extends HiddenNode {

    private KEYS decision;

    public OutputNode(double x, double y) {
        super(x, y);
    }

    public OutputNode(double x, double y, Color c) {
        super(x, y, c);
    }

   /* public void setKeys(Synapse[] synapses){

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
        this.decision = KEYS.DOWN;
    }
*/
    public enum KEYS {
        UP,DOWN,LEFT,RIGHT
    }

}
