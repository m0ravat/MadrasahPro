# Process to produce requirements
## Similar products
To start off, I decided to research what a good website would look like, and came across https://www.iza.org.uk/. 
What impressed me with this was the depth behind the website, it included an abundance of information ranging from 
different classes to class schedules and books used. This would inspire the design for my database, as I intend to replicate 
the structure shown here since it works extremely effectively. 
## Base aims of what to cover
- Based off what I saw on the website, this was my starting point of what I wanted to implement: 
- Allow for prospective students to create an account which would allow them to view classes and their structure. 
- Allow for them to apply for said classes, and upon being successful their account is given access to a range of other features like
viewing their timetable, teachers, books to be paid for and allow them to log in absences.
- As for teachers, they should be able to view their classes (including logging in attendance), students and 
file complaints. 
- The headteacher/admin should be the one to view applications, accept them and move people in classes if necessary. 
- They should be able to book meetings for students/teachers, as well as add new teacher accounts for new employees. 
## Extension of requirements based off stakeholder (ChatGPT)
Since I don't know any mosque teachers personally, I decided to use ChatGPT
to add onto my basic aims and create extra requirements. The ones I have decided to implement are as follows:
- Students should be able to view progress reports for grades and feedback. 
- They should receive notifications for future events or notices.
- Teachers should be able to assign grades digitally, as well as request reference of employment.
- Headteacher/admin should be able to kick out students/teachers and add them without needing to directly interact with the database. 
- They should be able to create new classes or update them (e.g. add new books) without interacting with the database directly. 
- They should be able to introduce new events which would be shown to students/teachers depending on the type (lectures specific to certain classes)

## Summary of Requirements
### Students 
- Allow for prospective students to create an account which would allow them to view classes and their structure.
- Allow for them to apply for said classes, and upon being successful their account is given access to a range of other features like
  viewing their timetable, teachers, books to be paid for and allow them to log in absences.
- Students should be able to view progress reports for grades and feedback.
- They should receive notifications for future events or notices.

### Teachers
- They should be able to view their classes (including logging in attendance), students and
file complaints. 
- Teachers should be able to assign grades digitally, as well as request reference of employment.

### Headteacher/admin
- The headteacher/admin should be the one to view applications, accept them and move people in classes if necessary.
- They should be able to book meetings for students/teachers, as well as add new teacher accounts for new employees. 
- Headteacher/admin should be able to kick out students/teachers and add them without needing to directly interact with the database.
- They should be able to create new classes or update them (e.g.  add new books) without interacting with the database directly.
- They should be able to introduce new events which would be shown to students/teachers depending on the type (lectures specific to certain classes)

### Database Design
- Should cover entities for different types of user accounts (prospective student, student, teacher, headteacher, admin)
- Should include different classes which have subjects, each subject with its own specific schedule, teacher and book(s).
- Should track payment for books by students. 
- Track payment for course per student. 
- Track attendance for classes and for each student. 
- Track complaints made and the outcome. 
- Should include personal details for students and teachers/headteacher.
- Track events which can be for teachers, students or anybody as well as tickets for such events. 