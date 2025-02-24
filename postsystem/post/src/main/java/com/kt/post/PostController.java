package com.kt.post;

import java.net.URI;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor

public class PostController {
    private final PostService postService;

  
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        URI location = URI.create("/posts/" + post.getId());
        return ResponseEntity.created(location).body(postService.addPost(post));
    }

    //모든 글 조회
    @GetMapping
    public ResponseEntity<List<Post>> list() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    //특정 글 조회
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }   

    //글 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Post entity) {
    
        Post updatedPost = postService.updatePost(id, entity.getTitle(), entity.getContent(), entity.getAuthor());
        
        return ResponseEntity.ok(updatedPost.getId() + "번 글이 수정되었습니다.");
    }
    //글삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return postService.deletePost(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }

}
