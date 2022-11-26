package usecases.dataStorage_DEPRECATED;

public class DsConverter {}
    /*
    public static AssessmentInstance instanceModelToEntity(InstanceDsModel instanceDsModel) {
        return new AssessmentInstanceFactory().create(
                instanceDsModel.getAssessmentInstanceName(),
                instanceDsModel.getDueDate(),
                instanceDsModel.getDueTime(),
                instanceDsModel.getMark(),
                instanceDsModel.isCommitted(),
                instanceDsModel.isSubmitted()
        );
    }

    public static Weight weightModelToEntity(WeightDsModel weightDsModel) {
        return new Weight(
                weightDsModel.getNumberOfInstances(),
                weightDsModel.getWeightOfEachInstance()
        );
    }
    public static WeightScheme weightSchemeModelToEntity(WeightSchemeDsModel weightSchemeDsModel) {
        if (weightSchemeDsModel instanceof SimpleWeightDsModel) {
            return new SimpleWeight(weightModelToEntity(
                    ((SimpleWeightDsModel) weightSchemeDsModel).getWeightModel()
            ));
        } else {
            WeightDsModel[] weightDsModels = ((OrderedWeightDsModel) weightSchemeDsModel).getOrderedWeightModels();
            return new OrderedWeight((Weight[]) Arrays.stream(weightDsModels)
                    .map(weightDsModel -> weightModelToEntity(weightDsModel))
                    .toArray()
            );
        }
    }
    public static Assessment assessmentModelToEntity(AssessmentDsModel assessmentDsModel) {
        Assessment assessment = new AssessmentFactory().create(
                assessmentDsModel.getTitle(),
                weightSchemeModelToEntity(assessmentDsModel.getWeightSchemeModel()),
                false
        );
        for (InstanceDsModel instanceDsModel : assessmentDsModel.getInstanceData()) {
            assessment.getInstanceList().addInstance(
                    instanceModelToEntity(instanceDsModel)
            );
        }
        return assessment;
    }
    public static Course courseModelToEntity(CourseDsModel courseDsModel) {
        Course course = new CourseFactory().create(courseDsModel.getCourseCode(), courseDsModel.getCourseName(), courseDsModel.getCredit());
        for (AssessmentDsModel assessmentDsModel : courseDsModel.getAssessmentData()) {
            course.getOutline().addAssessment(assessmentModelToEntity(assessmentDsModel));
        }
        // DOES NOT LOAD EVENTS (TEMPORARY)
        return course;
    }
    public static Account accountModelToEntity(AccountDsModel accountDsModel, EntityFactory entityFactory) {
        Account account = entityFactory.createAccount(accountDsModel.getUsername(), accountDsModel.getPassword());
        Semester semester = new Semester();
        Archive archive = new Archive();
        for (CourseDsModel courseDsModel : accountDsModel.getCourseData()) {
            if (courseDsModel.isArchived()) {
                archive.addCourse(courseModelToEntity(courseDsModel));
            } else {
                semester.addCourse(courseModelToEntity(courseDsModel));
            }
        }
        return account;
    }
} */