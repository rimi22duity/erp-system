package maks.erp.system.utils;

import maks.erp.system.enums.UserCategory;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static maks.erp.system.enums.Permission.*;

/**
 * @author duity
 * @since 7/13/24
 */
public class UserRoleUtils {

    public static HashMap<UserCategory, List<String>> rolePermissions = new HashMap<>();

    static  {
        rolePermissions.put(UserCategory.DIRECTOR, Arrays.asList(
                USER_CREATE_ANY.getPermissionName(),
                USER_EDIT_SELF.getPermissionName(),
                USER_VIEW_ANY.getPermissionName(),
                USER_DELETE_ANY.getPermissionName(),

                COMPANY_PROFILE_CREATE_ANY.getPermissionName(),
                COMPANY_PROFILE_EDIT_ANY.getPermissionName(),
                COMPANY_PROFILE_VIEW_ANY.getPermissionName(),
                COMPANY_PROFILE_DELETE_ANY.getPermissionName(),

                DESIGNATION_CREATE_ANY.getPermissionName(),
                DESIGNATION_EDIT_ANY.getPermissionName(),
                DESIGNATION_VIEW_ANY.getPermissionName(),
                DESIGNATION_DELETE_ANY.getPermissionName(),

                TASK_CREATE_SELF.getPermissionName(),
                TASK_EDIT_ANY.getPermissionName(),
                TASK_VIEW_ANY.getPermissionName(),
                TASK_DELETE_ANY.getPermissionName(),
                TASK_ASSIGN_ANY.getPermissionName(),

                LEAVE_APPLICATION_EDIT_ANY.getPermissionName(),
                LEAVE_APPLICATION_VIEW_ANY.getPermissionName(),
                LEAVE_APPLICATION_DELETE_ANY.getPermissionName(),
                LEAVE_APPLICATION_APPROVE_ANY.getPermissionName()
        ));
        rolePermissions.put(UserCategory.SYSTEM_ADMIN, Arrays.asList(
                USER_CREATE_ANY.getPermissionName(),
                USER_EDIT_SELF.getPermissionName(),
                USER_VIEW_ANY.getPermissionName(),
                USER_DELETE_ANY.getPermissionName(),

                COMPANY_PROFILE_CREATE_ANY.getPermissionName(),
                COMPANY_PROFILE_EDIT_ANY.getPermissionName(),
                COMPANY_PROFILE_VIEW_ANY.getPermissionName(),
                COMPANY_PROFILE_DELETE_ANY.getPermissionName(),

                DESIGNATION_CREATE_ANY.getPermissionName(),
                DESIGNATION_EDIT_ANY.getPermissionName(),
                DESIGNATION_VIEW_ANY.getPermissionName(),
                DESIGNATION_DELETE_ANY.getPermissionName(),

                TASK_CREATE_SELF.getPermissionName(),
                TASK_EDIT_SELF.getPermissionName(),
                TASK_VIEW_ANY.getPermissionName(),
                TASK_DELETE_ANY.getPermissionName(),
                TASK_ASSIGN_ANY.getPermissionName(),

                LEAVE_APPLICATION_CREATE_SELF.getPermissionName(),
                LEAVE_APPLICATION_VIEW_ANY.getPermissionName(),
                LEAVE_APPLICATION_EDIT_SELF.getPermissionName()
        ));
        rolePermissions.put(UserCategory.EMPLOYEE, Arrays.asList(
                USER_EDIT_SELF.getPermissionName(),
                USER_VIEW_ANY.getPermissionName(),

                COMPANY_PROFILE_VIEW_SELF.getPermissionName(),

                TASK_CREATE_SELF.getPermissionName(),
                TASK_EDIT_SELF.getPermissionName(),
                TASK_VIEW_ANY.getPermissionName(),
                TASK_DELETE_SELF.getPermissionName(),
                TASK_ASSIGN_EMPLOYEE.getPermissionName(),

                LEAVE_APPLICATION_CREATE_SELF.getPermissionName(),
                LEAVE_APPLICATION_EDIT_SELF.getPermissionName(),
                LEAVE_APPLICATION_VIEW_SELF.getPermissionName()
        ));
        rolePermissions.put(UserCategory.CONTRACTUAL, Arrays.asList(
                USER_EDIT_SELF.getPermissionName(),
                USER_VIEW_ANY.getPermissionName(),

                COMPANY_PROFILE_VIEW_SELF.getPermissionName(),

                TASK_CREATE_SELF.getPermissionName(),
                TASK_EDIT_SELF.getPermissionName(),
                TASK_VIEW_ANY.getPermissionName(),
                TASK_DELETE_SELF.getPermissionName(),
                TASK_ASSIGN_EMPLOYEE.getPermissionName(),

                LEAVE_APPLICATION_CREATE_SELF.getPermissionName(),
                LEAVE_APPLICATION_EDIT_SELF.getPermissionName(),
                LEAVE_APPLICATION_VIEW_SELF.getPermissionName()
        ));
        rolePermissions.put(UserCategory.INTERN, Arrays.asList(
                USER_EDIT_SELF.getPermissionName(),
                USER_VIEW_ANY.getPermissionName(),

                COMPANY_PROFILE_VIEW_SELF.getPermissionName(),

                TASK_CREATE_SELF.getPermissionName(),
                TASK_EDIT_SELF.getPermissionName(),
                TASK_VIEW_ANY.getPermissionName(),
                TASK_DELETE_SELF.getPermissionName(),

                LEAVE_APPLICATION_CREATE_SELF.getPermissionName(),
                LEAVE_APPLICATION_EDIT_SELF.getPermissionName(),
                LEAVE_APPLICATION_VIEW_SELF.getPermissionName()
        ));

        Collections.unmodifiableMap(rolePermissions);
    }
}
