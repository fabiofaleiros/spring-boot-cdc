package tech.ffs.postsservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
  private final PostRepository repository;

  public PostController(PostRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return repository.save(post);
  }

  @GetMapping
  public List<Post> getPosts() {
    return repository.findAll();
  }

  @GetMapping("{postId}")
  public List<Comment> getComments(@PathVariable Long postId) {
    return repository.findById(postId).get().getComments();
  }
}
