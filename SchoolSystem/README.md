# School system:

This code will simulate a school system.

Some fool proof baked in:
* Numbers can only be assigned if subject and students are in system.
* Different classes for Students, Subjects, Administration and a main.

Class diagram of the schoolsystem is as following:

```mermaid
classDiagram
App --> Student
App --> Administration
App --> Subject
Administration --> Student: Uses
Administration --> Subject: Uses
App: Administration adminstration
App: List CMI
App: List HBO
App: Subject Math
App: Subject English
App: Subject Programming
App: Subject Databases
App: Subject Networking
App: Student Rick
App: Student Dieter
App: Student You
Student: List subjects
Student: String studentNummer
Student: String name
Student: String sex
Student: String class
Student: Study
Student: Student(String number, String name, String sex, String study)
Student: newVakken(String name)
Administration: List students
Administration: Administration()
Administration: addStudents(Student student)
```

In the following flowcharts the custom functions are described. Getters and setters are not included as those are very standard procedures.

                                                      SUBJECT:
Variable:
  * Private List[Double] cijfers;
  * Private String moduleCode;
  * Private Int year;

              Initialization
```mermaid
flowchart TD
  A[String moduleCode, Int givenYear] --> B[SetModuleCode] --> C{Validate year};
  C -- <0 --> D[ERROR!];
  C --> E{>0}
  E -- >5 --> F[yearInput == 5];
  E -- <5 --> G[SetYear]
  F --> G[SetYear]
```

                                                     STUDENT:
Variable:
  * Private List<Subject> subjects;
  * Private String studentNumber;
  * Private String name;
  * Private String gender;
  * Private String class;
  * Private String FoS;  
\\FoS is Field of Study

              Initialization
```mermaid
flowchart TD
  A[String Number, String Name, String sex, String Class, String FoS] --> B[SetName] --> C[SetSex] --> D[SetClass] --> E[SetFos];
```
               newVakken
```mermaid
flowchart TD
  A[String newSubject, Int givenYear] --> B[new Subject] --> C[add Subject];
```
  
               getVak
```mermaid
flowchart TD
  A[String moduleCode] --> B{Validate inputCode};
  B -- isNull --> C[return null];
  B -- !isNull --> D{i < Subjects.size};
  D -- False --> E[return null];
  D -- True --> F{Check subjectCode in list}
  F -- False --> D{i >= Subjects.size}
  F -- True --> G{return subject};
```

               deviation
For better working use streams when possible.
  
```mermaid
flowchart TD
  A[No Specific Input] --> B[Calculate average for every subject];
  B -- No Averages --> I[Return 0.0];
  B -- Else --> C[Get general average of every average];
  C --> D{i <Averages.size};
  D -- True --> F[average i- general average];
  F --> G[average i squared];
  G --> D{i <Averages.size};  
  D -- False --> E[Deviation divided by averages size];
  E --> H[square deviation];
```
  
                                                     Administration:
```mermaid
flowchart TD

```
