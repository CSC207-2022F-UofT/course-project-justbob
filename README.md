 



# Structure
## Entities:
- Account
    - Each user that uses our program will need to register an account. Each user would have to remember his/her username and password in order to login to his/her account
    - An account contains the username and password, as well as a semester instance that stores all the current courses the user is taking, and an archive which stores all past courses.
    - An account can only be added when a user registers for one. Accounts cannot be removed by users.
    - Users can edit information within their accounts only after a successful login. 
- Archive
    - This is where all past courses are stored. 
    - The user can add courses to the archive or remove courses from the archive
- Semester
    - This is where all current courses that the user takes are stored.
    - The user can add or remove courses just like in Archive.
    - The user can also archive a course, which will move the course from Semester to Archive.
- Course: handles a single course’s logic.
    - All assessment logic is handled by the outline
- CourseEvent
- Assessment
- AssessmentInstance
- Calculation
- InstanceList 
- Outline
- Calendar
    - An aggregate entity such that ‘StickyNote’ objects can be posted to. The Calendar contains toggle methods for ‘Assessment’, ‘TimeTable’, and ‘Miscellaneous’ sticky notes to make each of them visible or invisible in the Calendar view. The constructor creates a ‘LocalDateTime’ variable called ‘currentDateAndTime’, a ‘LocalDate’ variable called ‘today’, and a ‘LocalDate’ variable called ‘seekedDate’ which equals ‘today’. ‘seekedDate’ can be updated to a different date inputted in the method ‘goToDate’ intended to change the Calendar view to the user’s selected date. 
- StickyNote
    - Takes in a ‘String’ called ‘title’, and a ‘String’ called ‘type’. StickyNotes represent events or activities. StickyNotes can be organized into ‘Assessment’, ‘TimeTable’, and ‘Miscellaneous’ sticky notes. The user can write to a sticky note represented by a text file with the method ‘writeToStickyNote’ which takes in an array of ‘Strings’ called ‘dotJots’. The class contains setter and getter methods for the time, the location if applicable, title, and type. The StickyNote can be posted on a single day, multiple specified days, or routinely during the week. Notifications can be set for every day a StickyNote is posted on.
- Notification
    - The Notification class uses two constructors. One constructor takes in a ‘LocalDateTime’ variable called ‘notification’ so that a notification is set for that date and time. The second constructor takes in a ‘LocalDateTime’ value called ‘notification’ along with an ‘int’ value called ‘period’ which calls on the notification again after every period. ‘period’ is in milliseconds. ‘Reminder’ is a helper class which inherits ‘TimerTask’. ‘Reminder’ is what happens when the notification is rang. It prints out a statement to remind the user that their activity is in 24 hours.
- GPACalculation
    -  Converts percentToGPA (in terms of UofT 4.0 scale), converts list of percentage to list of GPA, converts percent to list of lettered Grades, compute average, and overall GPA. 


## Use Cases:
# Courses #
Courses represent courses that the User is enrolled in. Each course contains a list of all of its assessments, along with other data including
1. The course code (e.g. "Csc207.") Must be unique.
2. The course name (e.g. "Introduction to Software Design")
3. The semester the course is in (e.g. "Winter")
4. How many credits the course is worth (either 0.5 or 1.0)

# Assessments #
Assessments represent a group of marks that are weighed together. This can be a set of 10 quizzes worth 2% each, or a set of term tests where the lowest is dropped, and anything similar. 

## Choosing a weight scheme ##
Each assessment needs a `WeightScheme` with instructions on how to weigh each mark. Currently there are 2 types of weight schemes supported
  1. Ordered Weights: For situations where marks are weighed differently based on performance.
  2. Simple Weights: For situations where all marks in the assessment are always worth exactly the same.

WeightSchemes use instances of `Weight` as their basic building blocks. A `Weight` simply specifies a number of marks that are worth exactly the same (in the case of the `SimpleWeight`, one weight is enough, that's why it's so simple!)

To create a new `SimpleWeight` that represents the weight of 10 marks worth 2% each:
```
Weight weight = new Weight(10, 0.02);
WeightScheme simpleWeight = new SimpleWeight(weight);
```
(Notice that percentiles are out of 1.0)

For more complex behaviour that involves performance-based weighting, we use `OrderedWeight`.
To create a new `OrderedWeight` that represents the weight of 5 marks with the lowest 2 dropped and the other 3 worth 5%:
```
Weight[] orderedArrayOfWeights = new Weight[] {
  new Weight(2, 0.0),
  new Weight(3, 0.05)
};
WeightScheme orderedWeight = new OrderedWeight(orderedArrayOfWeights);
```
Notice the ordering of the weights. Marks are assigned in order from lowest to highest to each space in the input weight array. In our example, the lowest marks we earn will be assigned to the first weight (worth nothing), and every higher mark will be assigned to the next weight (worth 5%). 

## Managing assessments ##
To create a new `assessment` with 3 instances worth 10% each:
```
WeightScheme mySimpleWeightScheme = new SimpleWeight(3, 0.1);
Assessment assessment = new Assessment("Quizzes", mySimpleWeightScheme);
```
To add an `assessment` to a `course`:
```
course.getOutline().addAssessment(assessment);
```
To remove an `assessment` from a `course`:
```
course.getOutline().removeAssessment(assessment);
```

## Marking assessments ##
Mark management is delegated to a helper class called `InstanceList` The `InstanceList` stores a certain number of `AssessmentInstance` objects, which each store a single mark earned as part of an assessment. The `AssessmentInstance` class also includes some other data, including
1. A name for the particular instance (for example, "Quiz 1")
2. The date and time that the instance is due (optional)

Once the user receives a mark back, they need to **commit** it. Committed instances represent marks that the user has gotten back from their school, and they are used in computations where the current running average is requested. If a mark is not committed, it will only appear in the hypothetical average.

To set a hypothetical mark of 87 for the first instance in `assessment`:
```
assessment.getInstanceList().editAssessmentMark(0, 0.87);
```
(Notice that we use indexing to sort through the list. We use traditional indexing (starting from 0)
To commit the above mark (assuming you magically scored exactly an 87 later):
```
assessment.getInstanceList().getInstanceData(0).commit();
```
- gradeTrend
    - gradeTrendInterface
        - Functions to calculateGPATrend, getXData (for trend graph), getYData (for trend graph), setHypothetical
    - gradeTrendCourse
        - Implements gradeTrendInterface
        - Calculates data for a bar graph representing the grades within a single course
    - gradeTrendOverall
        - Implements gradeTrendInterface
        - Calculates data for a bar graph representing the grades for across courses.
    - gradeTrendView
        - Takes a gradeTrendInterface and uses the xchart library to create a bar graph using calculateGPATrend, getXData and getYData from the gradeTrendInterface.
    - gradeTrendController
        - updateView and setHypothetical methods that interact with gradeTrendInterface and gradeTrendView
- dataStorage
- markOperations
- checkList
    - checkListTask
        - Convert the AssessmentInstance into another version to be shown in the check list.
checkList
        - Contains all the AssessmentInstance of a user.
        - Allow users to sort the assessments in different ways, like due date or weight of the task.
    - checkListView
        - Use java GUI to generate an interface showing the existing checklist. The interface provides functions including choosing ways of sorting, whether to show details of the assessments, and whether to show the submitted and committed assessments.
- todo…
