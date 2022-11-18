package gradeTrend;

public class gradeTrendController {
    final private gradeTrendInterface model;
    final private gradeTrendView view;

    public gradeTrendController(gradeTrendInterface model, gradeTrendView view) {
        this.model = model;
        this.view = view;
    }

    public void setHypothetical(boolean value) {
        this.model.setHypothetical(value);
        this.updateView();
    }

    public void updateView() {
        this.model.calculateGPATrend();
        this.view.updateFrame(this.model);
    }
}
