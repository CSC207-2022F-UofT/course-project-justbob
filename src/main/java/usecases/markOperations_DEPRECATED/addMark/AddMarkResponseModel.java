package usecases.markOperations_DEPRECATED.addMark;

public class AddMarkResponseModel {
    private double newHypotheticalGrade;

    public AddMarkResponseModel(double newHypotheticalGrade) {
        this.newHypotheticalGrade = newHypotheticalGrade;
    }

    public double getNewHypotheticalGrade() {
        return newHypotheticalGrade;
    }
}
