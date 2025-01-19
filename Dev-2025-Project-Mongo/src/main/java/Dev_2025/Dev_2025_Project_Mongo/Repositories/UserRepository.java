package Dev_2025.Dev_2025_Project_Mongo.Repositories;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
