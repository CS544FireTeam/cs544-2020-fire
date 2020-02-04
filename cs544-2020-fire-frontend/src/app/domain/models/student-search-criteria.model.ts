import SearchCriteria from "./search-criteria.model";

export default interface StudentSearchCriteria extends SearchCriteria{
  sessionId?: number;
}
