package GPATrend;

public class GPATrendController {
    final private GPATrendInterface model;
    final private GPATrendView view;

    public GPATrendController(GPATrendInterface model, GPATrendView view) {
        this.model = model;
        this.view = view;
    }

    public void setHypothetical(boolean value) {
        this.model.setHypothetical(value);
    }

    public void updateView() {
        this.model.calculateGPATrend();
        this.view.showGraph(this.model);
    }
}
