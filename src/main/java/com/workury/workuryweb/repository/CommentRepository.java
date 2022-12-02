package com.workury.workuryweb.repository;

import com.workury.workuryweb.entity.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository
    extends MongoRepository<CommentEntity, String> {}
