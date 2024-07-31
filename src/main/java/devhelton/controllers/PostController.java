package devhelton.controllers;

import devhelton.repositories.PostRepository;
import jakarta.validation.Valid;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationSourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import devhelton.dtos.PostRecordDto;
import devhelton.models.PostModel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @PostMapping("/posts")
    public ResponseEntity<PostModel> savePost(@RequestBody @Valid PostRecordDto postRecordDto){
        var postModel = new PostModel();
        BeanUtils.copyProperties(postRecordDto, postModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(postModel));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostModel>> getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable(value="id") UUID id){
        Optional<PostModel> post = postRepository.findById(id);
        if(post.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(post.get());
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable(value="id") UUID id, @RequestBody @Valid PostRecordDto postRecordDto){
        Optional<PostModel> post = postRepository.findById(id);

        if(post.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }

        var postModel = post.get();
        BeanUtils.copyProperties(postRecordDto, postModel);

        return ResponseEntity.status(HttpStatus.OK).body(postRepository.save(postModel));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value="id") UUID id){
        Optional<PostModel> post = postRepository.findById(id);
        if(post.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }

        postRepository.delete(post.get());
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted successfully");
    }

}
