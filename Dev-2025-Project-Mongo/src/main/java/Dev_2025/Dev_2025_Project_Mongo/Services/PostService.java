package Dev_2025.Dev_2025_Project_Mongo.Services;

import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.PostRepository;
import Dev_2025.Dev_2025_Project_Mongo.Services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository  postRepository;


    public Post findById (String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchByTitle (String text) {
        return postRepository.searchByTitle(text);
    }

    public List<Post> fullSearch (String s, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+ 24 * 60 * 60 * 1000); //calculo para considerar as 24h do dia em questão.
        return postRepository.fullSearch(s, minDate, maxDate);
    }

}
