import Student from "./student.model";
import TimeSlot from "./time-slot.model";
import Location from "./location.model";

export default interface Attendance {
  id?: number;
  student?: Student;
  timeSlot?: TimeSlot;
  location?: Location;
  attendedDate?: string;
}
