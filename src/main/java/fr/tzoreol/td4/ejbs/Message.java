package fr.tzoreol.td4.ejbs;

import fr.tzoreol.td4.dto.MessageDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Message {
    void send(String username, String message);
    List<MessageDto> getMessages();
}
