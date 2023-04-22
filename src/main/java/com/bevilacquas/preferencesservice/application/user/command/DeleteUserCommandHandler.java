package com.bevilacquas.preferencesservice.application.user.command;

import static com.bevilacquas.preferencesservice.domain.entities.User.*;

import an.awesome.pipelinr.Command.Handler;
import com.bevilacquas.preferencesservice.domain.entities.User;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;

public class DeleteUserCommandHandler implements Handler<DeleteUserCommand, Boolean> {

  private final UsersRepository repo;

  public DeleteUserCommandHandler(UsersRepository repo) {
    this.repo = repo;
  }

  @Override
  public Boolean handle(DeleteUserCommand command) {
    try {
      repo.delete(buildFromUserRequest(command.userRequest()));
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
