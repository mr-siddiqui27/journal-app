package com.learner.journalApp.service;


// BEST PRACTICE-
// Controller calls -> service
// Service calls -> repository
// Controller ---> Service ---> Repository

import com.learner.journalApp.entity.JournalEntry;
import com.learner.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;            // Dependency injection

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public Optional<JournalEntry> deleteById(ObjectId id){
        Optional<JournalEntry> journal = findById(id);
        journalEntryRepository.deleteById(id);
        return journal;
    }

}
