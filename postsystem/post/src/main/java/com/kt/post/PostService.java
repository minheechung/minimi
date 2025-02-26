package com.kt.post;

// import java.util.ArrayList;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PostService {
        
    
    private final PostRepository postRepository;

    public Post addPost(Post post) {
        return postRepository.save(post);

    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
        
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElse(null);
        
    }

    //수정
    @Transactional
    public Post updatePost(int id, String title, String content, String author) {
        Post post=postRepository.findById(id).orElse(null);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        return postRepository.save(post);

    }
    

    //삭제 -> 성공여부 T,F로 반환하기 위해 boolean으로 반환
    public boolean deletePost(int id) { 
        if (postRepository.existsById(id)) {
        postRepository.deleteById(id);
        return true;
        } else {
          return false;
        }
    }
}
   