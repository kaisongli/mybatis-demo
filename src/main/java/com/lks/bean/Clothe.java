package com.lks.bean;

/**
 * Created by likaisong on 2019/3/2.
 */
public class Clothe {
    private int clotheId;

    private String clotheColor;

    private int userId;

    private User user;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {

        return user;
    }

    public int getUserId() {
        return userId;
    }

    public int getClotheId() {
        return clotheId;
    }

    public void setClotheId(int clotheId) {
        this.clotheId = clotheId;
    }

    public String getClotheColor() {
        return clotheColor;
    }

    public void setClotheColor(String clotheColor) {
        this.clotheColor = clotheColor;
    }

    public void setUSerId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clothe[");
        sb.append("clotheId=").append(clotheId);
        sb.append(",clotheColor=").append(clotheColor);
        sb.append(",userId=").append(userId);
        sb.append(",user=").append(user);
        sb.append(']');
        return sb.toString();
    }
}
