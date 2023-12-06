package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.BlogPost;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogPostService {
    public BlogPost addPost(MultipartFile file, BlogPost post) throws IOException;

    public List<BlogPost> getPosts();

    BlogPost getSpecificPost(String id);
}
