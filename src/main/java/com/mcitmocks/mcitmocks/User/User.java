package com.mcitmocks.mcitmocks.User;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String email;
    private String timeZone;

    protected User() {}

    public User(String email) {
        this.email = email;
    }

    public User(String email, String timeZone) {
        this.email = email;
        this.timeZone = timeZone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
