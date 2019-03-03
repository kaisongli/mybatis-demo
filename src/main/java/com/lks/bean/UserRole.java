package com.lks.bean;

/**
 * Created by likaisong on 2019/3/3.
 */
public class UserRole {

    private User user;

    private Role role;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {

        return user;
    }

    public Role getRole() {
        return role;
    }
}
