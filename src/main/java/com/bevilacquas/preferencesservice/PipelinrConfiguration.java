package com.bevilacquas.preferencesservice;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Command.Handler;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelinrConfiguration {

  @Bean
  public Pipeline pipeline(
      ObjectProvider<Handler> preferenceRequestHandler,
      ObjectProvider<Notification.Handler> preferenceNotificationHandlers,
      ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
        .with(preferenceRequestHandler::stream)
        .with(preferenceNotificationHandlers::stream)
        .with(middlewares::orderedStream);
  }
}