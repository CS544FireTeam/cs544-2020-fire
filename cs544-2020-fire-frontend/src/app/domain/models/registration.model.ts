import Student from "./student.model";
import CourseOffering from "./course-offering";

export default interface Registration {
  id?: number;
  student?: Student;
  courseOffering?: CourseOffering;
  registerDate?: string;
}
