package com.bevilacquas.preferencesservice.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.application.solution.commands.DeleteSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.commands.UpdateSolutionCommand;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import com.bevilacquas.preferencesservice.application.user.command.CreateUserCommand;
import com.bevilacquas.preferencesservice.application.user.command.DeleteUserCommand;
import com.bevilacquas.preferencesservice.application.user.command.UpdateUserCommand;
import com.bevilacquas.preferencesservice.application.user.query.GetAllUsersQuery;
import com.bevilacquas.preferencesservice.application.user.query.GetUserByIdQuery;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        var result = new GetUserByIdQuery(UUID.fromString(id)).execute(pipeline);
        if(result != null) return new ResponseEntity<>(result, OK);
        else return new ResponseEntity<>(NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest ur) {
        return new ResponseEntity<>(new CreateUserCommand(ur).execute(pipeline), CREATED);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest ur) {
        return new ResponseEntity<>(new UpdateUserCommand(ur).execute(pipeline), OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteSolution(@RequestBody UserRequest ur) {
        return new ResponseEntity<>(new DeleteUserCommand(ur).execute(pipeline), OK);
    }
}
