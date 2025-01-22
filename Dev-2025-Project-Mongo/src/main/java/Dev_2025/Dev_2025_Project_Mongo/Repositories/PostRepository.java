package Dev_2025.Dev_2025_Project_Mongo.Repositories;

import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String > {


    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{'title': { $regex: ?0, $options: 'i'}}")
    List<Post> searchByTitle (String s);

    @Query("{ $and: [ " +
            "{ 'date': { $gte: ?1 } }, " +
            "{ 'date': { $lte: ?2 } }, " +
            "{ $or: [ " +
            "{ 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }, " +
            "{ 'comments.text': { $regex: ?0, $options: 'i' } } " +
            "] } " +
            "] }")
    List<Post> fullSearch (String s, Date minDate, Date maxDate);


}
