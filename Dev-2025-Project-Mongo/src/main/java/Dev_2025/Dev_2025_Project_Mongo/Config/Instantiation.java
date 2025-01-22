package Dev_2025.Dev_2025_Project_Mongo.Config;

import Dev_2025.Dev_2025_Project_Mongo.DTO.AuthorDTO;
import Dev_2025.Dev_2025_Project_Mongo.DTO.CommentsDTO;
import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import Dev_2025.Dev_2025_Project_Mongo.Domain.User;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.PostRepository;
import Dev_2025.Dev_2025_Project_Mongo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, simpleDateFormat.parse("10/06/2025"), "Partiu Mudança", "Estou me mudando para SM! abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, simpleDateFormat.parse("01/06/2025"), "Feliz ano novo", "Muitas paz e sucesso a todos!", new AuthorDTO(maria) );

        CommentsDTO c1 = new CommentsDTO("Boa sorte", simpleDateFormat.parse("10/06/2025"), new AuthorDTO(alex) );
        CommentsDTO c2 = new CommentsDTO("Feliz Ano novo, sucesso na nova casa.", simpleDateFormat.parse("10/06/2025"), new AuthorDTO(bob) );
        CommentsDTO c3 = new CommentsDTO("Nos vemos logo, abraços", simpleDateFormat.parse("11/06/2025"), new AuthorDTO(alex) );

        post1.setComents(Arrays.asList(c1, c3));
        post2.setComents(List.of(c2));
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.setPosts(Arrays.asList(post1, post2));
        userRepository.save(maria);



    }
}
