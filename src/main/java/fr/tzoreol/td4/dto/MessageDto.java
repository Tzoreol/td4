package fr.tzoreol.td4.dto;

import fr.tzoreol.td4.ejbs.Message;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("messageDto")
@RequestScoped
public class MessageDto {
    @EJB
    private Message messageBean;

    private String time;
    private String username;
    private String message;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public List<MessageDto> getMessages() {
        return this.messageBean.getMessages();
    }

    public String send() {
        this.messageBean.send(this.username, this.message);

        return "chat";
    }
}
