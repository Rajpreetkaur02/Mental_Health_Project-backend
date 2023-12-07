package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.BlogPostDao;
import com.MentalHealthProject.mentalHealth.entities.BlogPost;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    private BlogPostDao blogPostDao;


    @Override
    public BlogPost addPost(MultipartFile file, BlogPost post) throws IOException {
        post.setImg(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
//        post.setTimestamp(new Date());
        return this.blogPostDao.save(post);
    }

    @Override
    public List<BlogPost> getPosts() {
        return this.blogPostDao.findAll();
    }

    @Override
    public BlogPost getSpecificPost(String id) {
        Optional<BlogPost> blogPost = blogPostDao.findById(id);
        return blogPost.get();
    }
}
