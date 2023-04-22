package com.bevilacquas.preferencesservice.application.user.query;

import an.awesome.pipelinr.Command.Handler;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;

public class GetUserByIdQueryHandler implements Handler<GetUserByIdQuery, UserResponse> {

  private final UsersRepository repo;

  public GetUserByIdQueryHandler(UsersRepository repo) {
    this.repo = repo;
  }

  @Override
  public UserResponse handle(GetUserByIdQuery command) {
    return repo.findById(command.id()).map(UserResponse::buildFromUser).orElse(null);
  }
}
