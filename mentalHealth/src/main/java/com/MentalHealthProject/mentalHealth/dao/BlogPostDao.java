package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostDao extends MongoRepository<BlogPost, String> {

}
