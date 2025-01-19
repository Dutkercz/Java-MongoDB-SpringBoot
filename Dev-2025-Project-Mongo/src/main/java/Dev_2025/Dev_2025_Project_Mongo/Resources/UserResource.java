package Dev_2025.Dev_2025_Project_Mongo.Resources;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //@RequestMapping(method = RequestMethod.GET) << pode usar esse methodo para especificar
    // o endpoint rest do caminha (/users)
    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        List<User> user = service.findAll();
        return ResponseEntity.ok().body(user);
    }
}
