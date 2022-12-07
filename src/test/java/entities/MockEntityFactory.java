package entities;

import entities.assessment.Assessment;
import entities.assessment.Assessment.AssessmentFactory;
import entities.assessment.AssessmentInstance;
import entities.assessment.AssessmentInstance.AssessmentInstanceFactory;
import entities.course.Course;
import entities.course.Course.CourseFactory;
import entities.course.CourseEvent;
import entities.course.Outline;
import entities.course.Outline.OutlineFactory;
import inMemoryDB.entities.AssessmentInstanceImpl;
import entities.weightScheme.WeightScheme;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockEntityFactory implements CourseFactory, OutlineFactory, AssessmentFactory, AssessmentInstanceFactory {
    private class CourseMock extends Course {
        private String courseCode;
        private String courseName;
        private float credit;
        private Outline outline;
        private ArrayList<CourseEvent> courseEvents;

        @Override
        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        @Override
        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        @Override
        public float getCredit() {
            return credit;
        }

        @Override
        public void setCredit(float credit) {
            this.credit = credit;
        }

        @Override
        public Outline getOutline() {
            return outline;
        }

        @Override
        public void setOutline(Outline outline) {
            this.outline = outline;
        }

        @Override
        public ArrayList<CourseEvent> getCourseEvents() {
            return courseEvents;
        }

        @Override
        public CourseEvent getCourseEventByTitle(String title) {
            for (CourseEvent courseEvent : courseEvents) {
                if (courseEvent.getTitle().equals(title)) {
                    return courseEvent;
                }
            }
            return null;
        }

        @Override
        public void addCourseEvent(CourseEvent courseEvent) {
            if (!courseEvents.contains(courseEvent)) {
                courseEvents.add(courseEvent);
            }
        }

        @Override
        public void removeCourseEvent(CourseEvent courseEvent) {
            courseEvents.remove(courseEvent);
        }
    }

    private class OutlineMock extends Outline {
        private ArrayList<Assessment> assessments = new ArrayList<>();

        @Override
        public ArrayList<Assessment> getAssessments() {
            return assessments;
        }

        @Override
        public ArrayList<String> getAssessmentsTitles() {
            ArrayList<String> titles = new ArrayList<>();
            for (Assessment assessment : assessments) {
                titles.add(assessment.getTitle());
            }
            return titles;
        }

        @Override
        public ArrayList<String> getAssessmentsSingularTitles() {
            ArrayList<String> singularTitles = new ArrayList<>();
            for (Assessment assessment : assessments) {
                singularTitles.add(assessment.getSingularTitle());
            }
            return singularTitles;
        }

        @Override
        public ArrayList<Integer> getAssessmentsNumberOfInstances() {
            ArrayList<Integer> numberOfInstances = new ArrayList<>();
            for (Assessment assessment : assessments) {
                numberOfInstances.add(assessment.getTotalNumberOfInstances());
            }
            return numberOfInstances;
        }

        @Override
        public ArrayList<Double> getAssessmentsWeights() {
            ArrayList<Double> weights = new ArrayList<>();
            for (Assessment assessment : assessments) {
                weights.add(assessment.getTotalWeight());
            }
            return weights;
        }

        @Override
        public int getIndexByTitle(String assessmentTitle){
            int index = 0;
            for (Assessment assessment : assessments) {
                if (assessment.getTitle().equals(assessmentTitle)) {
                    return index;
                }
                index++;
            }
            return -1;
        }

        @Override
        public Assessment getAssessmentByTitle(String assessmentTitle){
            for (Assessment assessment : assessments) {
                if (assessment.getTitle().equals(assessmentTitle)) {
                    return assessment;
                }
            }
            return null;
        }

        @Override
        public void addAssessment(Assessment assessment) {
            if (!assessments.contains(assessment)) {
                assessments.add(assessment);
            }
        }

        @Override
        public void removeAssessment(Assessment assessment) {
            assessments.remove(assessment);
        }

        @Override
        public Assessment getAssessment(int index) throws IndexOutOfBoundsException {
            try {
                return assessments.get(index);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }
    }

    private class AssessmentMock extends Assessment {
        private String title;
        private WeightScheme weightScheme;
        private ArrayList<AssessmentInstance> instances = new ArrayList<>();

        private String singularTitle;

        public AssessmentMock(String title, WeightScheme weightScheme) {
            this.title = title;
            this.weightScheme = weightScheme;
            this.singularTitle = toSingular(this.title);

            for (int i = 0, j = 1; i < this.getTotalNumberOfInstances(); i++, j++) {
                this.instances.add(new AssessmentInstanceImpl(this.singularTitle + " #" + j));
            }
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getSingularTitle() {
            return singularTitle;
        }

        @Override
        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public WeightScheme getWeightScheme() {
            return weightScheme;
        }

        // TODO: ensure setting weightscheme adjusts instance list
        @Override
        public void setWeightScheme(WeightScheme weightScheme) {
            this.weightScheme = weightScheme;
        }

        @Override
        public ArrayList<AssessmentInstance> getInstances() {
            return instances;
        }

        @Override
        public void addInstance(AssessmentInstance instance) {
            if (getCurrentNumberOfInstances() < getTotalNumberOfInstances()) {
                // TODO: throw appropriate error
            }
            if (!instances.contains(instance)) {
                instances.add(instance);
            }
        }

        @Override
        public void removeInstance(AssessmentInstance instance) {
            instances.remove(instance);
        }

        @Override
        public String toSingular(String title) {
            if (title == "Quizzes"){
                return "Quiz";
            }
            if (title.charAt(title.length()-1) == 's'){
                return singularTitle.substring(0, title.length()-1);
            }
            return title;
        }
    }



    @Override
    public Course createCourse() {
        return new CourseMock();
    }

    @Override
    public Outline createOutline() {
        return new OutlineMock();
    }

    @Override
    public Assessment createAssessment(String title, WeightScheme weightScheme) {
        return new AssessmentMock(title, weightScheme);
    }

    @Override
    public Assessment createAssessment(String title, WeightScheme weightScheme, List<AssessmentInstance> instances) {
        if (instances.size() > weightScheme.getNumberOfInstances()) {
            throw new IllegalArgumentException("instances size exceeds weightScheme's number of instances");
        }
        Assessment assessment = createAssessment(title, weightScheme);
        for (AssessmentInstance instance : instances) {
            assessment.addInstance(instance);
        }
        return assessment;
    }

    @Override
    public AssessmentInstance createAssessmentInstance(String title, LocalDateTime deadline, Double mark,
                                                       boolean isCommitted, boolean isSubmitted)
            throws IllegalArgumentException {
        if (mark != null && !AssessmentInstance.isMarkValid(mark)) {
            throw new IllegalArgumentException(String.format("Mark %f is not valid", mark));
        }
        if (isCommitted && !isSubmitted) {
            // TODO: is this a valid exception? Would it be better to override isSubmitted as true?
            throw new IllegalArgumentException("AssessmentIntance cannot be committed and not submitted");
        }

        AssessmentInstance instance = new AssessmentInstanceImpl(title);
        instance.setSubmitted(isSubmitted);
        instance.setCommitted(isCommitted);
        instance.setMark(mark);

        return instance;
    }


    /*
    private class ArchiveMock extends Archive {
        private HashMap<Course, ArchivedCourseData> courseToData = new HashMap<>();

        @Override
        public List<Course> getCourses() {
            return List.copyOf(courseToData.keySet());
        }

        @Override
        public Archive.ArchivedCourseData getArchivedCourseData(Course course) {
            return courseToData.get(course);
        }

        @Override
        public void addCourse(Course course, String semester) {
            Archive.ArchivedCourseData data = new Archive.ArchivedCourseData();
            data.setSemester(semester);
            data.setDateArchived(LocalDate.now());
            courseToData.put(course, data);
        }

        @Override
        public void RemoveCourse(Course course) {
            courseToData.remove(course);
        }
    }

    private class SemesterMock extends Semester {
        private String title;
        private ArrayList<Course> runningCourses;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public ArrayList<Course> getRunningCourses() {
            return runningCourses;
        }

        @Override
        public void setRunningCourses(ArrayList<Course> runningCourses) {
            this.runningCourses = runningCourses;
        }

        @Override
        public void addCourse(Course course) {
            if (!getRunningCourses().contains(course)) {
                getRunningCourses().add(course);
            }
        }

        @Override
        public void removeCourse(Course course) {
            getRunningCourses().remove(course);
        }
    }

    private class AccountMock extends Account {
        private String username;
        private String password;
        private Semester semester;
        private Archive archive;

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public Semester getSemester() {
            return semester;
        }

        @Override
        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        @Override
        public Archive getArchive() {
            return archive;
        }

        @Override
        public void setArchive(Archive archive) {
            this.archive = archive;
        }
    }
     */


}