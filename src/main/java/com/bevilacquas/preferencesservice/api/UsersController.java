package com.bevilacquas.preferencesservice.api;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.user.command.CreateUserCommand;
import com.bevilacquas.preferencesservice.application.user.query.GetAllUsersQuery;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
