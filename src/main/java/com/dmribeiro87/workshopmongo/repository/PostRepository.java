package com.dmribeiro87.workshopmongo.repository;

import com.dmribeiro87.workshopmongo.domain.Post;
import com.dmribeiro87.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
