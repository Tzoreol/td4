package fr.tzoreol.td4.ejbs.impl;

import fr.tzoreol.td4.dto.MessageDto;
import fr.tzoreol.td4.ejbs.Message;
import fr.tzoreol.td4.listeners.ApplicationListener;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class MessageBean implements Message {
    @Override
    public void send(String username, String message) {
        fr.tzoreol.td4.entities.Message messageToSend = new fr.tzoreol.td4.entities.Message();
        messageToSend.setUsername(username);
        messageToSend.setMessage(message);
        messageToSend.setTime(new Date());

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(messageToSend);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<MessageDto> getMessages() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<fr.tzoreol.td4.entities.Message> query = em.createNamedQuery("findAllMessages", fr.tzoreol.td4.entities.Message.class);

        List<fr.tzoreol.td4.entities.Message> messages = query.getResultList();

        List<MessageDto> toReturn = new ArrayList<>();
        messages.forEach(m -> {
            MessageDto messageDto = new MessageDto();
            messageDto.setUsername(m.getUsername());
            messageDto.setMessage(m.getMessage());
            messageDto.setTime(m.getTime().toString());

            toReturn.add(messageDto);
        });

        return toReturn;
    }
}
