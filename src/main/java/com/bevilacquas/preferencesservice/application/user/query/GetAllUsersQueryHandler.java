package com.bevilacquas.preferencesservice.application.user.query;

import static java.util.stream.Collectors.toList;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsersQueryHandler implements Command.Handler<GetAllUsersQuery, List<UserResponse>>{

    private final UsersRepository repo;

    public GetAllUsersQueryHandler(UsersRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UserResponse> handle(GetAllUsersQuery getAllUsersQuery) {
        return repo
                .getAllUsers()
                .stream()
                .map(UserResponse::buildFromUser)
                .collect(toList());
    }
}
