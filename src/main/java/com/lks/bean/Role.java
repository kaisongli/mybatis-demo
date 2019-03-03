package com.lks.bean;

import java.util.List;

/**
 * Created by likaisong on 2019/3/3.
 */
public class Role {
    private int roleId;

    private String roleName;

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {

        return users;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {

        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role[");
        sb.append("roleId=").append(roleId);
        sb.append(",roleName=").append(roleName);
        sb.append(']');
        return sb.toString();
    }
}
