package com.diplomado.Users.web.rest;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.dto.DetailedDTO;
import com.diplomado.Users.dto.UserDTO;
import com.diplomado.Users.exception.RequestException;
import com.diplomado.Users.service.UserDetailService;
import com.diplomado.Users.service.mapper.DetailedMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/usersDetail")
public class UserDetailController {

    private final UserDetailService userDetailService;
    private final DetailedMapper detailedMapper;

    public UserDetailController(UserDetailService userDetailService, DetailedMapper detailedMapper) {
        this.userDetailService = userDetailService;
        this.detailedMapper = detailedMapper;
    }

    @GetMapping
    public ResponseEntity<List<DetailedDTO>> getUsersDetail(){

            return ResponseEntity.ok().body(userDetailService.listUserDetail());

    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedDTO> getUserDetailById(@PathVariable final Long id){
        return ResponseEntity.ok(userDetailService.getUserDetailById(id)
                .orElseThrow(()-> new RequestException("User detail not found", HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<DetailedDTO> save(@Valid @RequestBody final UserDetail userDetail) throws URISyntaxException {
        if (userDetail.getId()!=null){
            throw new RequestException("The user detail with that ID already exists", HttpStatus.NOT_FOUND);
        }
        if (userDetail.getUser()==null){
            throw new RequestException("The user detail required user", HttpStatus.NOT_FOUND);
        }

        DetailedDTO userDetailFromDB= detailedMapper.toDTO(userDetailService.save(userDetail));

        return ResponseEntity.created(new URI("v1/rols/"+userDetailFromDB.getId())).body(userDetailFromDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedDTO> update(@PathVariable final Long id,@Valid @RequestBody final UserDetail userDetail){
        if (userDetail.getId() == null){
            throw new RequestException("Invalid user id, null value", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(userDetail.getId(), id)) {
            throw new RequestException("Invalid id",HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(detailedMapper.toDTO(userDetailService.update(userDetail)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        userDetailService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
