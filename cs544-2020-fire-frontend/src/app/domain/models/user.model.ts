import {UserRoleEnum} from "../enums/user-role.enum";

export default interface User {
  id?: number;
  username?: string;
  password?: string;
  firstName?: string;
  lastname?: string;
  role?: UserRoleEnum;
}
