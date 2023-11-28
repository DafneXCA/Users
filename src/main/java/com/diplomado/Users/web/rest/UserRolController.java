package com.diplomado.Users.web.rest;

import com.diplomado.Users.domain.entities.UserRol;
import com.diplomado.Users.dto.UserRolDTO;
import com.diplomado.Users.exception.RequestException;
import com.diplomado.Users.repositories.UserRolRepository;
import com.diplomado.Users.service.UserRolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/userRols")
public class UserRolController {

    private final UserRolService userRolService;
    private final UserRolRepository userRolRepository;
    public UserRolController(UserRolService userRolService, UserRolRepository userRolRepository) {
        this.userRolService = userRolService;
        this.userRolRepository = userRolRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserRolDTO>> getUserRols(){
        return ResponseEntity.ok().body(userRolService.listUserRol());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRolDTO> getUserRolById(@PathVariable final Integer id){
        return ResponseEntity.ok(userRolService.getUserRolById(id)
                .orElseThrow(()-> new RequestException("User rol not found", HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<UserRolDTO> save(@Valid @RequestBody final UserRol userRol) throws URISyntaxException {

        userRol.setActive(true);
        userRol.setCreatedAt(LocalDateTime.now());

        UserRolDTO userRolFromDB=userRolService.save(userRol);

        return ResponseEntity.created(new URI("v1/rols/"+userRolFromDB.getId())).body(userRolFromDB);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserRolDTO> update(@PathVariable final Integer id, @RequestBody final UserRol userRol){
        if (userRol.getId() == null){
            throw new RequestException("Invalid user rol id, null value", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(userRol.getId(), id)) {
            throw new RequestException("Invalid id",HttpStatus.BAD_REQUEST);
        }

        UserRol userRolUpdate= userRolRepository.findById(id).orElse(null);
        if (userRolUpdate==null) {
            throw new RequestException("Not found user rol",HttpStatus.NOT_FOUND);
        }
        userRolUpdate.setActive(userRol.getActive());
        return ResponseEntity.ok().body(userRolService.update(userRolUpdate));
    }

}
