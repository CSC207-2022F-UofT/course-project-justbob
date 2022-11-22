 



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




## Use Cases:
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
