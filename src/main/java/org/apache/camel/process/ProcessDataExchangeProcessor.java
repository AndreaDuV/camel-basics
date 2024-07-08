package org.apache.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.pojos.Person;

public class ProcessDataExchangeProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        // Recibir un String, Objeto
        //System.out.println("2. Body In = " + exchange.getIn().getBody());
        System.out.println("2. Header Person = " + exchange.getIn().getHeader("Header person"));

        Person person = exchange.getIn().getBody( Person.class );  //Body
        Person person2 = exchange.getIn().getHeader("Header person", Person.class); //Header
        
        if ( person2 == null ) {
            System.err.println("Person is null");
        } else {
            System.err.println("Person name = " + person.getName());
        }

   
    }

}
