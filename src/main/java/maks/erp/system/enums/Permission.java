package maks.erp.system.enums;

import lombok.Getter;

/**
 * @author duity
 * @since 7/13/24
 */

@Getter
public enum Permission {
    USER_CREATE_ANY("can_create_any_user"),
    USER_EDIT_SELF("can_edit_self_user"),
    USER_VIEW_ANY("can_view_any_user"),
    USER_DELETE_ANY("can_delete_any_user"),

    COMPANY_PROFILE_CREATE_ANY("can_create_any_company_profile"),
    COMPANY_PROFILE_EDIT_ANY("can_edit_any_company_profile"),
    COMPANY_PROFILE_DELETE_ANY("can_delete_any_company_profile"),
    COMPANY_PROFILE_VIEW_ANY("can_view_any_company_profile"),
    COMPANY_PROFILE_VIEW_SELF("can_view_self_company_profile"),

    DESIGNATION_CREATE_ANY("can_create_any_designation"),
    DESIGNATION_EDIT_ANY("can_edit_any_designation"),
    DESIGNATION_DELETE_ANY("can_delete_any_designation"),
    DESIGNATION_VIEW_ANY("can_view_any_designation"),

    TASK_CREATE_SELF("can_create_self_task"),
    TASK_EDIT_ANY("can_edit_any_task"),
    TASK_EDIT_SELF("can_edit_self_task"),
    TASK_DELETE_ANY("can_delete_all_task"),
    TASK_DELETE_SELF("can_delete_self_task"),
    TASK_VIEW_ANY("can_view_task"),
    TASK_ASSIGN_ANY("can_assign_any_task"),
    TASK_ASSIGN_EMPLOYEE("can_assign_employee_task"),

    LEAVE_APPLICATION_CREATE_SELF("can_create_self_leave_application"),
    LEAVE_APPLICATION_EDIT_ANY("can_edit_any_leave_application"),
    LEAVE_APPLICATION_EDIT_SELF("can_edit_self_leave_application"),
    LEAVE_APPLICATION_DELETE_ANY("can_delete_any_leave_application"),
    LEAVE_APPLICATION_VIEW_ANY("can_view_any_leave_application"),
    LEAVE_APPLICATION_VIEW_SELF("can_view_self_leave_application"),
    LEAVE_APPLICATION_APPROVE_ANY("can_approve_leave_application"),

    ALL("all_permission"),
    NONE("no_permission");

    private final String permissionName;

    Permission(String permissionName) {
        this.permissionName = permissionName;
    }
}
