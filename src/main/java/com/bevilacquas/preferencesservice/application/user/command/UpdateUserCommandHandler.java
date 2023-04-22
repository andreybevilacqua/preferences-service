package com.bevilacquas.preferencesservice.application.user.command;

import static com.bevilacquas.preferencesservice.application.user.UserResponse.buildFromUser;
import static com.bevilacquas.preferencesservice.domain.entities.User.buildFromUserRequest;

import an.awesome.pipelinr.Command.Handler;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;

public class UpdateUserCommandHandler implements Handler<UpdateUserCommand, UserResponse> {

  private final UsersRepository usersRepository;

  public UpdateUserCommandHandler(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public UserResponse handle(UpdateUserCommand command) {
    return buildFromUser(
        usersRepository.save(
            buildFromUserRequest(command.userRequest())
        )
    );
  }
}
