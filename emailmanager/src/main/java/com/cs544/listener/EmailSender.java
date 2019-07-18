package com.cs544.listener;

//import com.cs544.model.Email;

import com.sendgrid.SendGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"email_queue"})
public class EmailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    @RabbitHandler
    public void receiveMessage(com.cs544.model.Email email) {
        LOGGER.info(" receive message");// [" + email.toString() + "] ");

        try {

            SendGrid sg = new SendGrid("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");
            SendGrid.Email mail = new SendGrid.Email();
            mail.setFrom("info@tripadvisor.com");
            String[] tos = new String[1];
            tos[0] = email.getEmail();

            mail.setTo(tos);

            mail.setHtml(email.getBody());
            mail.setSubject(email.getTitle());
            mail.setText(email.getBody());

            SendGrid.Response rsp = sg.send(mail);

            LOGGER.info(rsp.getMessage());

        } catch (Exception ex) {
            // throw ex;
            LOGGER.error(ex.toString());
        }
    }
}

