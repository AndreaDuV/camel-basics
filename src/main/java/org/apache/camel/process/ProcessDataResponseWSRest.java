package org.apache.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.pojos.Person;

public class ProcessDataResponseWSRest implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println("2. Body -> " + exchange.getIn().getBody( String.class ));

   
    }

}
