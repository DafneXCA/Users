package com.diplomado.Users.web.rest;

import com.diplomado.Users.domain.entities.Rol;
import com.diplomado.Users.dto.RolDTO;
import com.diplomado.Users.exception.RequestException;
import com.diplomado.Users.service.RolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/rols")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> getRols(){
        return ResponseEntity.ok().body(rolService.listRols());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return ResponseEntity.ok(rolService.getRolById(id)
                .orElseThrow(()-> new RequestException("Rol not found", HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<RolDTO> save(@Valid @RequestBody final RolDTO rolDTO) throws URISyntaxException {
        RolDTO rolFromDB=rolService.save(rolDTO);
        return ResponseEntity.created(new URI("v1/rols/"+rolFromDB.getId())).body(rolFromDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable final Integer id,@RequestBody final RolDTO rolDTO){
        if (rolDTO.getId() == null){
            throw new RequestException("Invalid rol id, null value", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(rolDTO.getId(), id)) {
            throw new RequestException("Invalid id",HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok().body(rolService.update(rolDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer id){
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
