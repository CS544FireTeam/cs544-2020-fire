import CourseOffering from "./course-offering";
import TimeSlot from "./time-slot.model";

export default interface Session {
  id?: number;
  courseOffering?: CourseOffering;
  timeSlot?: TimeSlot;
  date?: string;
}
