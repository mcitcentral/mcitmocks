package com.mcitmocks.mcitmocks.Availability;

import com.mcitmocks.mcitmocks.User.User;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="availability")
public class Availability {
    @Id
    @GeneratedValue
    private UUID id;


    @Column(
            name="startTime",
            nullable=false
    )
    private OffsetDateTime startTime;

    @Column(
            name="taken",
            nullable=false,
            columnDefinition = "BOOLEAN"
    )
    private boolean taken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId_fk")
    private User user;

    protected Availability(){

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
}
