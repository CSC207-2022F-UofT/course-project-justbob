package usecases.dataStorage;

import entities.assessment.Assessment;
import entities.assessmentInstance.AssessmentInstance;
import entities.course.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecases.dataStorage.account.AccountDsModel;
import usecases.dataStorage.assessment.AssessmentDsModel;
import usecases.dataStorage.course.CourseDsModel;
import usecases.dataStorage.instance.InstanceDsModel;
import usecases.dataStorage.weightScheme.SimpleWeightDsModel;
import usecases.dataStorage.weightScheme.WeightDsModel;
import usecases.dataStorage.weightScheme.WeightSchemeDsModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class DsConverterTest {
    InstanceDsModel quiz1Model = new InstanceDsModel(
            "Quiz 1",
            LocalDate.of(2022, 12, 03),
            null,
            0.8,
            false,
            true
    );

    AssessmentDsModel quizAssessmentModel = new AssessmentDsModel(
            "Quizzes",
            Arrays.asList(new InstanceDsModel[] {quiz1Model}),
            new SimpleWeightDsModel(new WeightDsModel(1, 1.0))
    );

    CourseDsModel csc207Model = new CourseDsModel(
            "CSC207",
            "Software Design",
            "Fall",
            false,
            (float) 1.0,
            Arrays.asList(new AssessmentDsModel[] {quizAssessmentModel}),
            new ArrayList<>()
    );

    AccountDsModel myAccountModel = new AccountDsModel(
            "my account",
            "verysafepasswd",
            Arrays.asList(new CourseDsModel[] {csc207Model})
    );

    private void assertInstanceModelEqualsEntity(InstanceDsModel instanceDsModel, AssessmentInstance instance) {
        Assertions.assertEquals(instanceDsModel.getAssessmentInstanceName(), instance.getName());
        Assertions.assertEquals(instanceDsModel.getDueDate(), instance.getDueDate());
        Assertions.assertEquals(instanceDsModel.getDueTime(), instance.getDueTime());
        Assertions.assertEquals(instanceDsModel.getMark(), instance.getMark());
        Assertions.assertEquals(instanceDsModel.isCommitted(), instance.isCommitted());
        Assertions.assertEquals(instanceDsModel.isSubmitted(), instance.isSubmitted());
    }

    @Test
    public void convertInstanceModelToEntityTest() {
        assertInstanceModelEqualsEntity(quiz1Model, DsConverter.instanceModelToEntity(quiz1Model));
    }

    private void assertAssessmentModelEqualsEntity(AssessmentDsModel assessmentDsModel, Assessment assessment) {
        WeightSchemeDsModel weightSchemeDsModel = assessmentDsModel.getWeightSchemeModel();
        if (weightSchemeDsModel instanceof SimpleWeightDsModel) {
            //WeightDsModel weightDsModel = ((SimpleWeightDsModel) weightSchemeDsModel).get
            //Assertions.assertEquals(.g
        }
    }

    @Test
    public void convertAssessmentModelToEntityTest() {
        AssessmentDsModel assessmentDsModel = quizAssessmentModel;
        Assessment assessment = DsConverter.assessmentModelToEntity(quizAssessmentModel);
        Assertions.assertEquals(assessmentDsModel.getTitle(), assessment.getTitle());
        // since we know the weight is simpleWeight

    }
}
