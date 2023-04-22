package com.bevilacquas.preferencesservice.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import com.bevilacquas.preferencesservice.application.user.command.CreateUserCommand;
import com.bevilacquas.preferencesservice.application.user.query.GetAllUsersQuery;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController implements Command<UserResponse> {

    private final Pipeline pipeline;

    public UsersController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(new GetAllUsersQuery().execute(pipeline), OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest ur) {
        return new ResponseEntity<>(new CreateUserCommand(ur).execute(pipeline), CREATED);
    }
}
