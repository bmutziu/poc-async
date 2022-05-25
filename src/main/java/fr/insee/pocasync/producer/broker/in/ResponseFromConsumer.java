package fr.insee.pocasync.producer.broker.in;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class ResponseFromConsumer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Transactional
    public void receiveResponse(String destination, String jmsCorrelationId) {
        String response = (String) jmsTemplate.receiveSelectedAndConvert(destination, "JMSCorrelationID = '" + jmsCorrelationId + "'");
        log.info("##################################");
        log.info("PRODUCER : Ok from consumer for correlation_id <" + jmsCorrelationId + ">");
        log.info("##################################");
    }
}
