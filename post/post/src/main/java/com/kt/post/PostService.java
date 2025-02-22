package com.kt.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class PostService {
        
    private List<Post> posts = new ArrayList<Post>();
    private int nextId=1;

    public Post addPost(Post post) {
        post.setId((nextId++));
        posts.add(post);    
        return post;

    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(int id) {
        return posts.stream()
        .filter(post->post.getId()==id)
        .findFirst().orElse(null);
                
    }
  
    //수정
    public Post updatePost(int id, String title, String content, String author) {
        Post post=getPost(id);
        if (post!=null) {
            post.setTitle(title);
            post.setContent(content);
            post.setAuthor(author);
            return post;
        }
        return null;
    }
    

    //삭제 -> 성공여부 T,F로 반환하기 위해 boolean으로 반환
    public boolean deletePost(int id) {
        boolean removedpost = posts.removeIf(post->post.getId()==id);
        if (removedpost) {
            System.out.println("삭제완료");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
        return removedpost;
    
        // return posts.removeIf(post->post.getId()==id);
    
    }



}
