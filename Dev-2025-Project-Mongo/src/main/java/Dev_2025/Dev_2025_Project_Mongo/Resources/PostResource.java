package Dev_2025.Dev_2025_Project_Mongo.Resources;

import Dev_2025.Dev_2025_Project_Mongo.Domain.Post;
import Dev_2025.Dev_2025_Project_Mongo.Resources.util.URL;
import Dev_2025.Dev_2025_Project_Mongo.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById (@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String s){
        s = URL.decodeParam(s);
        List<Post> posts = postService.findByTitle(s);
        return ResponseEntity.ok().body(posts);


    }
}
