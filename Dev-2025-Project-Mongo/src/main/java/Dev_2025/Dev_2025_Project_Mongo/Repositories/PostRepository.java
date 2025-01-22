package Dev_2025.Dev_2025_Project_Mongo.Repositories;

import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String > {


    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{'title': { $regex: ?0, $options: 'i'}}")
    List<Post> searchByTitle (String s);


}
