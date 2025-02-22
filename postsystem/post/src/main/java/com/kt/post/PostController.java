package com.kt.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    //모든 글 조회
    @GetMapping("/posts")
    public List<Post> list() {
        List<Post> posts=postService.getAllPosts();
        return posts;
    }

    //특정 글 조회
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.getPost(id);
    }   

    //글 수정
    @PutMapping("posts/{id}")
    public String update(@PathVariable int id, @RequestBody Post entity) {
        String title = entity.getTitle();
        String content = entity.getContent();
        String author = entity.getAuthor();
        postService.updatePost(id, title, content, author);
        
        return "수정완료";
    }
    //글삭제
    @DeleteMapping("posts/{id}")
    public String delete(@PathVariable int id) {
        postService.deletePost(id);
        return "삭제완료";
    }

}
