package crudoperation.Service;

import crudoperation.Entity.Post;
import crudoperation.Exception.ResourceNotFoundException;
import crudoperation.Payload.PostDto;
import crudoperation.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements PostService{

    private PostRepository postRepository;

    public ServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
      Post post=mapToEntity(postDto);
        Post newpost = postRepository.save(post);
        PostDto postResponse = mapToDto(newpost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post","id",id));
        return mapToDto(post);

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());
        post.setMobile(postDto.getMobile());

        Post update = postRepository.save(post);
        return mapToDto(update  );
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "sucessfully deleted", id)
        );
        postRepository.delete(post);
    }


    //convert Entity into Dto
    private PostDto mapToDto(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setName(post.getName());
        postDto.setEmail(post.getEmail());
        postDto.setMobile(post.getMobile());
        return postDto;
    }
    //dto to entity
    private Post mapToEntity(PostDto postDto){
            Post post =new Post();
            post.setName(postDto.getName());
            post.setEmail(postDto.getEmail());
            post.setMobile(postDto.getMobile());

        return post ;
    }
}
