package com.exampleblog.firstblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exampleblog.firstblog.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    
}
