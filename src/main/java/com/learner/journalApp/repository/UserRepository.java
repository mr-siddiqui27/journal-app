package com.learner.journalApp.repository;

import com.learner.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {       //JournalEntry- jispar aapko operation karna hai,   ObjectId- id type in JournalEntry

    User findByUserName(String userName);
}
