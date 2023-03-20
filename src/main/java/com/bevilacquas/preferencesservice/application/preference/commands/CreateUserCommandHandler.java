package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.response.UserResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;
import org.springframework.stereotype.Component;

import static com.bevilacquas.preferencesservice.application.preference.response.UserResponse.buildFromUser;
import static com.bevilacquas.preferencesservice.domain.entities.User.buildFromUserRequest;

@Component
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, UserResponse>{

    private final UsersRepository repo;

    public CreateUserCommandHandler(UsersRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserResponse handle(CreateUserCommand createUserCommand) {
        return buildFromUser(
                repo.save(
                        buildFromUserRequest(createUserCommand.ur())
                )
        );
    }
}
