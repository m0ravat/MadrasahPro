CREATE TABLE Teacher (
                         email VARCHAR(100) PRIMARY KEY, -- Primary key is email
                         firstName VARCHAR(50) NOT NULL,
                         lastName VARCHAR(50) NOT NULL,
                         doB DATE NOT NULL,
                         address TEXT,
                         telNo VARCHAR(20),
                         allergies TEXT,
                         password VARCHAR(255) NOT NULL,
                         salary DECIMAL(10,2),
                         CV TEXT,
                         hours INT
);

CREATE TABLE Course (
                        courseName VARCHAR(100) PRIMARY KEY,
                        shortDesc VARCHAR(255),
                        longDesc TEXT,
                        duration INT,
                        price DECIMAL(10,2)
);

CREATE TABLE Subject (
                         subjectName VARCHAR(100) PRIMARY KEY,
                         shortDesc TEXT,
                         overview TEXT,
                         outcome TEXT,
                         duration INT,
                         startYear INT,
                         courseName VARCHAR(100) NULL,
                         FOREIGN KEY (courseName) REFERENCES Course(courseName) ON DELETE SET NULL
);

CREATE TABLE Lesson (
                       lessonName VARCHAR(100) PRIMARY KEY,
                       weekNo INT,
                       duration INT,
                       timeStart TIME,
                       teacherEmail VARCHAR(100) NULL, -- Changed to reference Teacher(email)
                       subjectName VARCHAR(100),
                       FOREIGN KEY (teacherEmail) REFERENCES Teacher(email) ON DELETE SET NULL,
                       FOREIGN KEY (subjectName) REFERENCES Subject(subjectName) ON DELETE CASCADE
);

CREATE TABLE Student (
                         email VARCHAR(100) PRIMARY KEY, -- Primary key is email
                         firstName VARCHAR(50) NOT NULL,
                         lastName VARCHAR(50) NOT NULL,
                         doB DATE NOT NULL,
                         address TEXT,
                         telNo VARCHAR(20),
                         allergies TEXT,
                         password VARCHAR(255) NOT NULL,
                         punctuality DECIMAL(5,2),
                         moneyOwed DECIMAL(10,2),
                         attendance DECIMAL(5,2)
);

CREATE TABLE EmergencyContact (
                                  personID INT PRIMARY KEY AUTO_INCREMENT,
                                  firstName VARCHAR(50) NOT NULL,
                                  lastName VARCHAR(50) NOT NULL,
                                  doB DATE NOT NULL,
                                  email VARCHAR(100),
                                  address TEXT,
                                  telNo VARCHAR(20),
                                  studentEmail VARCHAR(100), -- Changed to reference Student(email)
                                  FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE
);

CREATE TABLE StudentCourseAllocation (
                                         studentEmail VARCHAR(100), -- Changed to reference Student(email)
                                         courseName VARCHAR(100),
                                         yearJoined INT,
                                         monthJoined INT,
                                         grade VARCHAR(10),
                                         status VARCHAR(20),
                                         PRIMARY KEY (studentEmail, courseName, yearJoined),
                                         FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE,
                                         FOREIGN KEY (courseName) REFERENCES Course(courseName) ON DELETE CASCADE
);

CREATE TABLE Exam (
                      examID INT PRIMARY KEY AUTO_INCREMENT,
                      total DECIMAL(6,2),
                      type VARCHAR(20),
                      weekTaken INT,
                      teacherEmail VARCHAR(100) NULL, -- Changed to reference Teacher(email)
                      subjectName VARCHAR(100) NULL,
                      FOREIGN KEY (teacherEmail) REFERENCES Teacher(email) ON DELETE SET NULL,
                      FOREIGN KEY (subjectName) REFERENCES Subject(subjectName) ON DELETE SET NULL
);

CREATE TABLE ExamResult (
                            resultID INT PRIMARY KEY AUTO_INCREMENT,
                            mark DECIMAL(6,2),
                            studentEmail VARCHAR(100), -- Changed to reference Student(email)
                            examID INT NULL,
                            FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE,
                            FOREIGN KEY (examID) REFERENCES Exam(examID) ON DELETE SET NULL
);

CREATE TABLE PaymentReceipt (
                                paymentID INT PRIMARY KEY AUTO_INCREMENT,
                                dateMade DATE,
                                amount DECIMAL(10,2),
                                courseName VARCHAR(100) NULL,
                                studentEmail VARCHAR(100), -- Changed to reference Student(email)
                                FOREIGN KEY (courseName) REFERENCES Course(courseName) ON DELETE SET NULL,
                                FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE
);

CREATE TABLE Book (
                      bookName VARCHAR(100) PRIMARY KEY,
                      bookDesc TEXT,
                      author VARCHAR(100),
                      price DECIMAL(10,2),
                      subjectName VARCHAR(100) NULL,
                      FOREIGN KEY (subjectName) REFERENCES Subject(subjectName) ON DELETE SET NULL
);

CREATE TABLE BookOrder (
                           studentEmail VARCHAR(100), -- Changed to reference Student(email)
                           bookName VARCHAR(100),
                           dateBought DATE,
                           PRIMARY KEY (studentEmail, bookName, dateBought),
                           FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE,
                           FOREIGN KEY (bookName) REFERENCES Book(bookName) ON DELETE CASCADE
);

CREATE TABLE StudentAttendance (
                                   studentEmail VARCHAR(100), -- Changed to reference Student(email)
                                   lessonName VARCHAR(100),
                                   mark DECIMAL(5,2),
                                   PRIMARY KEY (studentEmail, lessonName,mark),
                                   FOREIGN KEY (studentEmail) REFERENCES Student(email) ON DELETE CASCADE,
                                   FOREIGN KEY (lessonName) REFERENCES Lesson(lessonName) ON DELETE CASCADE
);