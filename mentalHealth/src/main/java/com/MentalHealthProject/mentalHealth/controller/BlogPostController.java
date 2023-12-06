package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.BlogPost;
import com.MentalHealthProject.mentalHealth.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping(value = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlogPost> createPost(@RequestParam MultipartFile file, BlogPost post) throws IOException {
        return ResponseEntity.ok(this.blogPostService.addPost(file, post));
    }

    @GetMapping("/allPosts")
    public List<BlogPost> getPosts() {
        return this.blogPostService.getPosts();
    }

    @GetMapping("/post/{id}")
    public BlogPost getSpecificPost(@PathVariable String id){return this.blogPostService.getSpecificPost(id);}
}
