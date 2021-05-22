package com.mcitmocks.mcitmocks.Availability;

import com.mcitmocks.mcitmocks.User.User;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private UUID id;


    @Column(
            name = "startTime",
            nullable = false
    )
    private OffsetDateTime startTime;


    @Column(
            name = "taken",
            nullable = false
    )
    private boolean taken;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public Availability() {

    }
    public Availability(OffsetDateTime startTimeParam, boolean takenParam){
        this.startTime = startTimeParam;
        this.taken = takenParam;
    }

    public UUID getId() {
        return id;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public boolean isTaken() {
        return taken;
    }

    public User getUser() {
        return user;

    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability)) return false;
        return id != null && id.equals(((Availability) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
