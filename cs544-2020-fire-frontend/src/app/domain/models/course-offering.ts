import Course from "./course.model";
import Location from "./location.model";
import User from "./user.model";

export default interface CourseOffering {
  id?: number;
  course?: Course;
  location?: Location;
  faculty?: User;
  startDate?: Date;
  endDate?: Date;
}
