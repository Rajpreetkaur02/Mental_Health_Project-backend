package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.BlogPost;
import org.bson.types.Binary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogPostService {
    public BlogPost addPost(MultipartFile file, BlogPost post) throws IOException;

    public List<BlogPost> getPosts();

    public BlogPost getSpecificPost(String id);
}
