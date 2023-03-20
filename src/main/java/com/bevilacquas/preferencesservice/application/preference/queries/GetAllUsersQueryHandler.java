package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.response.UserResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
