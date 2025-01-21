package Dev_2025.Dev_2025_Project_Mongo.Services;

import Dev_2025.Dev_2025_Project_Mongo.DTO.UserDTO;
import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.UserRepository;
import Dev_2025.Dev_2025_Project_Mongo.Services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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
    public User insert (User o){
        return userRepository.insert(o);
    }

    public void delete (String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDto(UserDTO odto){
        return new User(odto.getId(), odto.getName(), odto.getEmail());
    }

    public User update (User o){
        User newObj = findById(o.getId());
        updateData(newObj, o);
        return userRepository.save(newObj);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }


}
