package com.demo.Util;

public interface IClientQueryMapper {

    // User Login Queries

    String VALIDATE_USER_QUERY = "SELECT user_id, name, user_grade FROM users_table WHERE username = ? AND userpassword = ?";

    // Admin Queries

    String ADD_USER_TO_DATABASE_QUERY = "INSERT INTO users_table VALUES(user_id_generator.nextval, ?, ?, ?, ?)";

    String VIEW_USERS_IN_DATABASE = "SELECT * FROM users_table";

    String UPDATE_USER_IN_DATABASE = "UPDATE users_table SET user_grade = ?, username = ?, userpassword = ?, name = ? WHERE user_id = ?";

    String DELETE_USER_FROM_DATABASE = "DELETE FROM users_table WHERE user_id = ?";

    // Resource Manager DAO Queries

    String GET_PROJECT_DETAILS_FOR_MANAGER = "SELECT executive_ID, project_id FROM project_table WHERE project_manager_id = ?";

    String ADD_REQUISITION_REQUEST = "INSERT INTO requisition_requests_table " +
            "(requisition_request_id , requesting_manager_id, requesting_project_id, request_status, " +
            "request_open_date, vacancy, required, skills_required, domain, executiveID)" +
            " VALUES (requests_id_generator.nextval, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ? )";

    String GET_REQUISITION_REQUEST_ID = "SELECT requests_id_generator.CURRVAL FROM DUAL";

    String GET_REQUISITION_REQUEST_ID_FROM_SUGGESTION_ID = "SELECT requisition_request_id FROM requisition_suggestions_table WHERE requisition_suggestion_id = ?";

    String VIEW_ALL_REQUESTS_FOR_MANAGER = "SELECT * FROM requisition_requests_table WHERE requesting_manager_id = ? AND request_status = ?";

    String VIEW_ALL_SUGGESTIONS = "SELECT * FROM requisition_suggestions_table WHERE suggesting_executive_id = ? AND requesting_manager_id = ? AND status_of_suggestion = ?";

    String ACCEPT_REJECT_SUGGESTIONS = "UPDATE requisition_suggestions_table SET status_of_suggestion = ? WHERE requisition_suggestion_id = ?";

    String UPDATE_EMPLOYEE_ALLOCATION = "UPDATE employee_table SET emp_project_id = ?, emp_allocation_status = ? WHERE emp_id = ?";

    String UPDATE_REQUISITION_REQUEST_STATUS = "UPDATE requisition_requests_table SET request_status = ?, request_close_date = SYSDATE WHERE requisition_request_id = ?";

    // Queries For Executive

    String SEARCH_EMPLOYEE_BY_ID = "SELECT * FROM employee_table WHERE emp_id = ?";

    String SEARCH_EMPLOYEE_BY_DOMAIN = "SELECT * FROM employee_table WHERE emp_domain = ?";

    String SEARCH_EMPLOYEE_BY_EXPERIENCE = "SELECT * FROM employee_table WHERE emp_experience_years >= ?";

    String SEARCH_EMPLOYEE_BY_SKILLS = "SELECT * FROM employee_table WHERE emp_skills = ?";

    String VIEW_ALL_CLOSED_REQUESTS_FOR_EXECUTIVE = "SELECT * FROM requisition_requests_table WHERE executiveID = ? AND request_status = ? AND request_close_date <= TO_DATE(?,'yyyy-mm-dd')";

    String VIEW_ALL_OPEN_REQUESTS_FOR_EXECUTIVE = "SELECT * FROM requisition_requests_table WHERE executiveID = ? AND request_status = ? AND request_open_date <= TO_DATE(?,'yyyy-mm-dd')";

}
