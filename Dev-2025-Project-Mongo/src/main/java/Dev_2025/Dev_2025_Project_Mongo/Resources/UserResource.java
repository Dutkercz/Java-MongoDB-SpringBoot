package Dev_2025.Dev_2025_Project_Mongo.Resources;

import Dev_2025.Dev_2025_Project_Mongo.DTO.UserDTO;
import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Resources.exceptions.StandardErrorException;
import Dev_2025.Dev_2025_Project_Mongo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    /// Usar o padrão DTO para retornar usuarios.

    @Autowired
    private UserService service;

    //@RequestMapping(method = RequestMethod.GET) << pode usar esse methodo para especificar
    // o endpoint rest do caminho (/users)
    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
        List<User> user = service.findAll();
        List<UserDTO> listDTO = user.stream().map(UserDTO::new).toList();
        // or with lambda expression: ... =  user.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User u = new User();
        try{
            u = service.findById(id);

        }catch (StandardErrorException e){
            System.out.println("Error. User not find.");
        }
        return ResponseEntity.ok().body(new UserDTO(u));
    }

    @PostMapping
    public ResponseEntity<Void> insert (@RequestBody  UserDTO odto){
        User o = service.fromDto(odto);
        o = service.insert(o);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update (@RequestBody  UserDTO odto, @PathVariable String id) {
        User o = service.fromDto(odto);
        o.setId(id);
        service.update(o);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    private ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User o = service.findById(id);
        return ResponseEntity.ok().body(o.getPosts());
    }
}
