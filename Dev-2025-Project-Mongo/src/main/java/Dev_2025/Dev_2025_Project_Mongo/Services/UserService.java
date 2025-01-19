package Dev_2025.Dev_2025_Project_Mongo.Services;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.UserRepository;
import Dev_2025.Dev_2025_Project_Mongo.Services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> userAux = userRepository.findById(id);
        return userAux.orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

}
