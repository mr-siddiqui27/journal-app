package com.learner.journalApp.service;


// BEST PRACTICE-
// Controller calls -> service
// Service calls -> repository
// Controller ---> Service ---> Repository

import com.learner.journalApp.entity.JournalEntry;
import com.learner.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;            // Dependency injection

    public void saveEntry(JournalEntry journalEntry){
        try{
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);
        }catch (Exception e){
            log.error("Exception", e);
        }

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
