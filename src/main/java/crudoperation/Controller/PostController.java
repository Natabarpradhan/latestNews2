package crudoperation.Controller;

import crudoperation.Payload.PostDto;
import crudoperation.Service.PostService;
import crudoperation.emailService.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    private EmailService emailService;

    public PostController(PostService postService, EmailService emailService) {

        this.postService = postService;
        this.emailService= emailService;
    }
    @PostMapping("/save")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        emailService.sendEmail(postDto.getEmail(), "Welcome", " Registration is successfully completed");
        return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);

    }
    @GetMapping()
    public List<PostDto>getAllPostds(){
       return postService.getAllPosts();
    }
    @GetMapping("{id}")
    public ResponseEntity<PostDto>getById(@PathVariable(name="id")long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable(name="id") long id){
        PostDto postupdate = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postupdate,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id")long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("postSucessfully Deleted",HttpStatus.OK);
    }
}
