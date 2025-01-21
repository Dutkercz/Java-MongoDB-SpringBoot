package Dev_2025.Dev_2025_Project_Mongo.Repositories;

import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String > {
}
