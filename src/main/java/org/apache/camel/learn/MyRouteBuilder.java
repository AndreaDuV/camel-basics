package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.process.*;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        from("timer:simple?period=10000")
            //.process(new SetDataExchangeProcessor())
            //.to("direct:procesarMensaje")
            .to("direct:consumirWSRest")
            .end();

        from("direct:procesarMensaje")
            .log("Iniciando procesamiento de mensaje")
            .process(new ProcessDataExchangeProcessor())
            .end();

        from("direct:consumirWSRest")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .to("https://restcountries.com/v3.1/all")
            .log("Response from WSRest = ${body}")
            .process(new ProcessDataResponseWSRest())
            .end();
    }

}
