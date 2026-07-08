package com.learner.journalApp.controller;

import com.learner.journalApp.entity.JournalEntry;
import com.learner.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController         // Marks the class as a REST Controller     , -Receives HTTP Requests.       , -Returns JSON/String as response.
@RequestMapping("/journal")        //Defines the Base URL.
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);

        return myEntry;
    }

    @GetMapping("id/{myId}")
    public Optional<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId);
    }


    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry){
        JournalEntry old = getJournalEntryById(myId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setContent((newEntry.getContent()!=null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent()));

        }
        journalEntryService.saveEntry(old);
        return old;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.deleteById(myId).orElse(null);
    }



}
