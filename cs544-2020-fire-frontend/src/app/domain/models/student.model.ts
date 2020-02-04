import User from "./user.model";
import Registration from "./registration.model";

export default interface Student extends User {
  studentCode?: string;
  barcode?: string;
  registrations?: Registration[];
}
