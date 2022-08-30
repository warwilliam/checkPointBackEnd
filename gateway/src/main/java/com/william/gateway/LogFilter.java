package com.william.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config> {
    private static AtomicInteger COUNT_CALL_GATEWAY = new AtomicInteger(0);
    private static Logger log = Logger.getLogger(LogFilter.class.getName());
    public LogFilter() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config){
        return (exchange, chain) -> {
//Filtro prévio à invocação do serviço real associado ao gateway
            log.info("Path requisitado " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//Filtro posterior à invocação do serviço real associado ao gateway
                log.info("Tempo de resposta " + Calendar.getInstance().getTime());
                log.info("quantidade de chamadas ao gateway: " + COUNT_CALL_GATEWAY.incrementAndGet());
            }));
        };
    }
    public static class Config {
//Put the configuration properties
    }
}