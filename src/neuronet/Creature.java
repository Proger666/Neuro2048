package neuronet;



import general.ControllerNeuroNetForm;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Scorpa on 12/18/2015.
 */
public class Creature {

    //Static Variables

    //Points for this creature
    private Point[] points;
    private HiddenNode[] hiddenNodes;
    private OutputNode[] outputNodes;
    private InputNode[] inputNodes;

    //Synapses for this creature
    private List<Synapse> creatureSynapses;

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return fitness;
    }

    private double fitness = 0.0D;
    private Synapse[] synapses;
    private List<Synapse> listOfSynapses;


    public Creature() {
        this.createPoints();
        this.createSynapses(Neuronet.HIDDEN_COUNT * Neuronet.INPUTS_COUNT + Neuronet.HIDDEN_COUNT * Neuronet.OUTPUTS_COUNT);

    }

    public Creature(Synapse[] s) {
        this.createPoints();
        this.synapses = s;


    }

    private void createSynapses(int totalSynapses) {

        this.synapses = new Synapse[totalSynapses];

        int tS = 0;
        for (InputNode in :
                inputNodes) {
            for (int i = 0; i < Neuronet.HIDDEN_COUNT; i++, tS++) {
                this.synapses[tS] = new Synapse(in.getxPos(), in.getyPos(),
                        hiddenNodes[i].getxPos(), hiddenNodes[i].getyPos(), in, hiddenNodes[i]);
            }
        }
        for (OutputNode ou :
                outputNodes) {

            for (int i = 0; i < Neuronet.HIDDEN_COUNT; i++, tS++) {
                this.synapses[tS] = new Synapse(ou.getxPos(), ou.getyPos(),
                        hiddenNodes[i].getxPos(), hiddenNodes[i].getyPos(), ou, hiddenNodes[i]);
            }
        }
    }



    private void createPoints() {
        int totalPoints = Neuronet.INPUTS_COUNT + Neuronet.HIDDEN_COUNT + Neuronet.OUTPUTS_COUNT;
        this.points = new Point[totalPoints];
        this.inputNodes = new InputNode[Neuronet.INPUTS_COUNT];
        this.hiddenNodes = new HiddenNode[Neuronet.HIDDEN_COUNT];
        this.outputNodes = new OutputNode[Neuronet.OUTPUTS_COUNT];


        int curPoint =0;
        for (int in = 0; in < Neuronet.INPUTS_COUNT; in++, curPoint++) {
            this.inputNodes[in] = new InputNode(125.0D, 85.0D + 25.0D * in, Color.RED);
            points[curPoint] = inputNodes[in];
        }

        for (int hn = 0; hn < Neuronet.HIDDEN_COUNT; hn++, curPoint++) {

           points[curPoint] = this.hiddenNodes[hn] =
                   new HiddenNode(375.0D, 85.0D + 25.0D * hn, Color.rgb(255, 0, 0));

        }

        for (int out = 0; out < Neuronet.OUTPUTS_COUNT; out++, curPoint++) {
            points[curPoint] = this.outputNodes[out] =
                    new OutputNode(375.0D, 85.0D + 25.0D * out, Color.rgb(255, 0, 0));
        }
    }





    public double calculateFitness(int score, int bestScore){
        return this.fitness = score - bestScore;
    }

    public Synapse getSynapse(int i) {
        return this.synapses[i];
    }

    public void draw(ControllerNeuroNetForm controller) {
        for (int i = 0; i < synapses.length; i++) {
            this.synapses[i].draw(controller);
        }

        for (int i = 0; i < points.length; i++) {
            this.points[i].draw(controller);
        }

    }

}
