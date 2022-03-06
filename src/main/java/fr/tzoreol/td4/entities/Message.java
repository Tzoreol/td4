package fr.tzoreol.td4.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllMessages", query = "SELECT m FROM Message m")
})
public class Message {
    @GeneratedValue
    @Id
    private Long id;

    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
