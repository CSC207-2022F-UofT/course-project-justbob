package usecases.markOperations.addMark;

public class AddMarkResponseModel {
    private double newHypotheticalGrade;

    public AddMarkResponseModel(double newHypotheticalGrade) {
        this.newHypotheticalGrade = newHypotheticalGrade;
    }

    public double getNewHypotheticalGrade() {
        return newHypotheticalGrade;
    }
}
