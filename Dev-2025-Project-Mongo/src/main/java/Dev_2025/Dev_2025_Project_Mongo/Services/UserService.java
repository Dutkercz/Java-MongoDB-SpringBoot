package Dev_2025.Dev_2025_Project_Mongo.Services;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }
}
