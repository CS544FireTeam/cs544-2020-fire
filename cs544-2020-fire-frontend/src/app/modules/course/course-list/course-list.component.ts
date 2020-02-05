import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import Course from "../../../domain/models/course.model";

@Component({
  selector: 'fire-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.less']
})
export class CourseListComponent extends PagingBaseComponent<Course> implements OnInit, AfterViewInit {

  @Input() set courses(courses: Course[]) {
    this._courses = courses;
    super.ngOnInit(courses);
  }

  @Output() onEdit: EventEmitter<Course> = new EventEmitter();
  @Output() onAddNew: EventEmitter<Course> = new EventEmitter();

  _courses: Course[];

<<<<<<< HEAD
//=CONCAT("{ code: '", A1,"', abbr: '", B1, ", name: '", C1, "description: '", D1, ", isChecked: false,")
  //TODO will be integrate with BK
  mockData: CourseItem[] = [
    { code: 'CS 109', abbr: 'MICROS Tour', name: 'Meeting with Compro students at MICROS company', description: 'Meeting with Compro students at MICROS company', isChecked: false, },
    { code: 'CS 110', abbr: 'ICC Tour', name: 'Meeting with Compro students at ICC, Ohio', description: 'Meeting with Compro students at ICC, Ohio', isChecked: false, },
    { code: 'CS000', abbr: 'JSearch', name: 'Job Search (Sept 04 students only)', description: 'Full-time Job Search', isChecked: false, },
    { code: 'CS108', abbr: 'Des Moines Trip', name: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', description: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', isChecked: false, },
    { code: 'CS208', abbr: 'Seattle Trip', name: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', description: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', isChecked: false, },
    { code: 'CS220', abbr: 'Data Structures', name: 'Data Structures', description: 'NULL', isChecked: false, },
    { code: 'CS390', abbr: 'FPP', name: 'Fundamental Programming Practices', description: 'Fundamentals of OO Programming', isChecked: false, },
    { code: 'CS401', abbr: 'MPP', name: 'Modern Programming Practices', description: 'Modern Programming Practices', isChecked: false, },
    { code: 'CS422', abbr: 'DBMS', name: 'Database Management Systems', description: 'Database systems organize and retrieve information, allowing the user to access the desired information easily and efficiently. Topics include: relational data model; SQL; ER modeling; relational algebra; data normalization; transactions; objects in the database; data security and integrity; data warehousing, OLAP, and data mining; distributed databases; and study of a specific commercial database system. (4 units) Prerequisite: CS 401 or consent of the department faculty.', isChecked: false, },
    { code: 'CS423', abbr: 'System Analysis & Design', name: 'System Analysis and Design', description: 'The systems approach is an organized way of dealing with a problem. The software systems development life cycle (SDLC) has three major phases. It begins with preliminary and feasibility studies to make the decision to develop a system to solve a particular problem in a cost-effective and timely way. This is followed by a detailed system study, in which every aspect of the current system is analyzed and a new system is designed to meet the needs of the organization. Finally, the system design is brought to life through software engineering techniques including coding, testing, implementation and maintenance of the system. This course focuses on the middle phase. A system is studied in detail to gather requirements and its process elements analyzed for suitability and relevance to meet the needs of the system’s users. This is followed by an iterative and creative design process, using tools such as flowcharts, data flow diagrams (DFD), data dictionary, decision tables and decision trees, to provide an effective and detailed design of the system.', isChecked: false, },
    { code: 'CS424', abbr: 'FOOP', name: 'Fundamentals of Object- Oriented Programming', description: 'This course presents the key principles of object-oriented programming. Students will learn how to write reusable and better maintainable software, and they integrate this knowledge with laboratory assignments and projects. Topics include: Fundamental principles and models of object-oriented programming, UML class diagrams, and design principles that promote reusability and maintainability of software. (2 units)', isChecked: false, },
    { code: 'CS425', abbr: 'SWE', name: 'Software Engineering', description: 'The Software Engineering course introduces the student to best practices in software development through a software development methodology. Students have already had some experience in previous courses with the Object Oriented paradigm and have used some of the basic UML diagrams for purposes of modeling relationships between software objects. In Software Engineering, the student will develop skills in putting these tools together to produce robust, easily maintainable software. A software development methodology describes when and how OO concepts and UML diagrams should be used to accomplish the aim of building quality software. The course centers around a small project in which the principles discussed in the lecture format can be illustrated and applied. By the end of the course, the student will have a running application, built in accord with the high standards of the RUP (Rational Unified Process) development methodology.', isChecked: false, },
    { code: 'CS428', abbr: 'Software Development with Fundamental Design Patterns', name: 'Software Development with Fundamental Design Patterns', description: 'This course is an introduction to 23 GoF (Gang of Four) design patterns. Design Patterns are proven solutions to recurring problems in object-oriented software design/development. Our course will cover the rationale and benefits of using them in real projects, with an emphasis on both the intellectual understanding and the ability to discover, apply, and implement them correctly (in Java) in any software project.', isChecked: false, },
    { code: 'CS435', abbr: 'Algo', name: 'Algorithms', description: 'This course presents methods for analyzing the efficiency of algorithms (including worst-case and average-case analysis) and introduces a variety of known, highly efficient algorithms. Analysis, design, and implementation of algorithms are given equal emphasis. Topics include searching and sorting, efficiency of operations on data structures (including lists, hashtables, balanced binary search trees, priority queues), graph algorithms, combinatorial algorithms, recurrence relations, NP-complete problems, and special topics as time allows.(4 units) Prerequisites: CS 401 and MATH 272, or consent of the department faculty.', isChecked: false, },
    { code: 'CS436', abbr: 'Robotics', name: 'Robotics', description: 'NULL', isChecked: false, },
    { code: 'CS440', abbr: 'Cmpl', name: 'Compilers', description: 'Students learn the successive stages and detailed mechanics by which high-level programming languages are translated into machine language by a compiler. Topics include language and grammar specification, compiler structure, compiler generation tools, lexical analysis, parsing, syntax analysis, semantic analysis, intermediate language, code generation and optimization, storage management and linkages, user interface, and a large programming project implementing part of a compiler. (4 units) ', isChecked: false, },
    { code: 'CS450', abbr: 'NET', name: 'Networks', description: 'Computers are connected with high-speed communication lines in local area or wide area networks, for the purpose of sharing databases and distributing workloads to increase efficiency and improve service. Topics include sampling and information theory, error detecting and correction codes, network architecture, communication protocols and models, protocol analysis, hardware components, logical and physical topology, message routing and switching, flow control, local area networks, and data security. (4 credits) Prerequisite: CS 401 or consent of the department faculty.', isChecked: false, },
    { code: 'CS455', abbr: 'DC2', name: 'Software Technologies', description: 'This course will cover the most current emerging methods, principles, and practices in', isChecked: false, },
    { code: 'CS456', abbr: 'Software Testing', name: 'Software Testing', description: 'The process of analyzing a software item to detect the differences between existing and required conditions (that is bugs) and to evaluate the features of the software items. [IEEE Standard 610.12-1990]', isChecked: false, },
    { code: 'CS465', abbr: 'OS', name: 'Operating Systems', description: 'An operating system controls the central resources of the computer system and allocates them to individual users. Course topics include sequential and concurrent processes, mutual exclusion, resource sharing, process cooperation, deadlock, resource allocation, processor scheduling, memory management, segmentation and paging algorithms, timesharing systems, scheduling algorithms, and resource protection. (4 units) ', isChecked: false, },
    { code: 'CS466', abbr: 'CompSec', name: 'Introduction to Computer Security', description: 'Knowledge of computer security is essential when writing software that will be used over a network.  The overall theme of the course is the study of the main principles in the design of secure systems.  Topics include access control mechanisms, cryptography, authentication, representing identity, malicious logic, auditing, intrusion detection, network security, system security, and user security.  The course features weekly labs in security theory which are applied to existing systems, such as .NET, Java, Windows XP, and Unix.  The course also relates the principles and concepts of computer security to the Science and Technology of Consciousness and Maharishi Vedic Science. ', isChecked: false, },
    { code: 'CS470', abbr: 'KBS (AI)', name: 'Knowledge-Based Systems (AI)', description: 'The field of artificial intelligence attempts to create computer programs that reflect the values of human intelligence. Course topics include state-space representations, tree and graph searches, predicate calculus and deduction, heuristics, learning and problem solving, natural language processing, expert systems, and programming languages for artificial intelligence. (4 units) ', isChecked: false, },
    { code: 'CS471', abbr: 'Parallel Programming', name: 'Parallel Programming', description: 'The standard processor for all new computers is now a multi-core processor. Each', isChecked: false, },
    { code: 'CS472', abbr: 'Web Prog', name: 'Web Programming', description: 'This course provides a systematic introduction to programming interactive and dynamic web applications.  The course is intended for individuals with little or no prior web application programming experience.  This offering will use PHP for server side processing.  PHP is a widely used web application server side scripting language.  It has been used for some very large systems (e.g., Facebook), but generally is used for smaller applications.  The course will introduce HTML and CSS as they are currently used, and also covers Javascript, Ajax, jQuery, and web security.   ', isChecked: false, },
    { code: 'CS473', abbr: 'MDP', name: 'Mobile Device Programming', description: 'Smart phones (including tablets) were predicted to out-ship the combined global market of laptop, desktop, and notebook computers in 2012. They did so in the last quarter of 2010, two years earlier than predicted! This course will prepare the students to program for a mobile device. The course will be project based, converting a 4500 line HTML5/Javascript/CSS3 app to a native Android app written in Java. Each student will be assigned a Samsung 7 tablet to use during the course. The first quarter of the course will familiarize the students with the Javascript app and examine the best practices that were employed in writing it. The next half of the course will convert most of the Javascript app to Java. The remaining 1/4 of the course will explore aspects of native Android programming such as the use of the camera and the accelerometer that were not used by the Javascript app. Prerequisite: CS472 or consent of the department faculty.', isChecked: false, },
    { code: 'CS475', abbr: 'Computer Graphics', name: 'Computer Graphics', description: 'The objective of Computer Graphics is to introduce the students to the basic concepts and challenges found in the areas of 2D and 3D Computer Graphics. Theory concepts will be covered in the first part of each lesson. Then, the concepts will be demonstrated using a programming API (Java2D, Java3D or OpenGL). This is a course on how to program Computer Graphics. It is NOT a course on how to use software to edit images, such as Photoshop or GIMP.', isChecked: false, },
    { code: 'CS476', abbr: 'Image Processing', name: 'Selected topics in Image Processing', description: 'Selected topics in Image Processing', isChecked: false, },
    { code: 'CS487', abbr: 'DComp&XML', name: 'Distributed Computing and XML', description: 'This course will investigate the uses of XML in distributed computation. First an understanding of the W3C specifications for XML, XML Schema, XPath, XML namespaces, XSLT and XQuery will be acquired. Then three important applications of XML in distributed computing will be investigated: syndication, web services and Ajax. Finally, advanced issues such as encrypted XML and binary XML will be considered. There will be daily labs using .NET 2.0', isChecked: false, },
    { code: 'CS488', abbr: 'Big Data Analytics ', name: 'Big Data Analytics', description: 'Big Data is the new natural resource: data is doubling every 12-18 months. This new Big Data Analytics course covers the fundamental concepts and tools for mining large diverse data sets to generate new insights. You will master the use of R language to create Wordcloud, Pagerank, Data Visualization, Decision Trees, Regression, Clustering, Neural Networks, and more. You will work with some large multi-million record datasets, and also mine Twitter feeds. You will learn Hadoop/MapReduce and Streaming Data concepts, and will explore other Apache Big Data Projects such as Spark, Flink, Kafka, Storm, Samza, NoSQL through individual research papers. You will work in groups on open projects from Kaggle.com to compete for prize money by solving best-of-breed data-analytic challenges.  You will also learn to use industry-leading IBM SPSS Modeler, and open-source data mining platforms.  The #1 bestseller textbook used in this course is written by the instructor himself. The course will also use a wide range of video training materials from MIT, Coursera, Google, and elsewhere. ', isChecked: false, },
    { code: 'CS490', abbr: 'Seminar', name: 'Seminar', description: 'Computer Science Seminar', isChecked: false, },
    { code: 'CS490-01',abbr: 'Rules Engines', name: 'Building Rules Engines For Business Applications', description: 'In this seminar, we will examine current industry trends in managing business rules. We will discuss pros and cons of externalizing rules and the emerging industry standards for implementation of a rules engine. The course will provide hands-on experience with a medium-scale rules engine.', isChecked: false, },
  ]
    ;
   constructor() {
    super(['action', 'number', 'abbr', 'name', 'description']);
=======
  get courses() {
    return this._courses;
  }

  constructor() {
    super(['number', 'abbr', 'name', 'description', 'actionButton']);
>>>>>>> 2d8deb5f896ab27709c9337a28c4c2b374b062c6
  }

  ngOnInit() {
    super.ngOnInit(this.courses);
  }

  ngAfterViewInit(): void {
    super.ngAfterViewInit();
  }

  onEditClick(course) {
    this.onEdit.emit(course)
  }

  onAddClick() {
    this.onAddNew.emit();
  }
}
