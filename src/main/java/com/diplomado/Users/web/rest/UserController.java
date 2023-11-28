package com.diplomado.Users.web.rest;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.dto.UserDTO;
import com.diplomado.Users.exception.RequestException;
import com.diplomado.Users.repositories.UserRepository;
import com.diplomado.Users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if (detailed){
            return ResponseEntity.ok().body(userService.listUsersDetailed());
        }else {
            return ResponseEntity.ok().body(userService.listUsers());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Long id){
        return ResponseEntity.ok(userService.getUserById(id)
                .orElseThrow(()-> new RequestException("User not found", HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody final User user) throws URISyntaxException {
        if (user.getId()!=null){
            throw new RequestException("The user with that ID already exists", HttpStatus.NOT_FOUND);
        }

        user.setCreatedAt(LocalDateTime.now());
        UserDTO userFromDB=userService.save(user);

        return ResponseEntity.created(new URI("v1/rols/"+userFromDB.getId())).body(userFromDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable final Long id,@Valid @RequestBody final User user){
        if (user.getId() == null){
            throw new RequestException("Invalid user id, null value", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(user.getId(), id)) {
            throw new RequestException("Invalid id",HttpStatus.BAD_REQUEST);
        }



        user.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
