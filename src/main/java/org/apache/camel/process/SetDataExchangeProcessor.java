package org.apache.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.pojos.Person;

public class SetDataExchangeProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        // Mandar un string 
        // System.out.println("1. Body In = " + exchange.getIn().getBody());
        // exchange.getMessage().setBody("Body definido a partir de SetDataExchangeProcessor");
        // exchange.getMessage().setHeader("Cabecera 1", "Header definido a partir de SetDataExchangeProcessor");

        // Mandar un objeto
        Person person = new Person("Andrea", 21);
        exchange.getMessage().setBody(person); // En body
        exchange.getMessage().setHeader("Header person", person); // En header
    }

    // getOut ahora se reemplaza por getMessage
}