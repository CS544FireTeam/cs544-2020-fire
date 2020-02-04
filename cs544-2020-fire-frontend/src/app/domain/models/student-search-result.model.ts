import User from "./user.model";
import Registration from "./registration.model";
import Student from "./student.model";

export default interface StudentSearchResult extends Student {
  psercentAttendance?: number;
}
