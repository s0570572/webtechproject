package de.htwberlin.webtech.project.backgroundlogic;

public class User {
    Integer userid;
    String username;
    String email;

    public User() {
    }

    public User(Integer userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
