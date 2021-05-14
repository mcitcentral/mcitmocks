package com.mcitmocks.mcitmocks.User;

import com.mcitmocks.mcitmocks.Availability.Availability;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users",
        uniqueConstraints = {
                @UniqueConstraint(name="student_email_unique",columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name="id",
            nullable = false,
            updatable = false)
    private String id;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "timeZone",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String timeZone;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Availability> availabilitySet = new HashSet<>();

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
