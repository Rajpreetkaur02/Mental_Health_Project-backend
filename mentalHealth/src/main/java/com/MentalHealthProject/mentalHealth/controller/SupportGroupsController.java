package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
import com.MentalHealthProject.mentalHealth.services.SupportGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupportGroupsController {

    @Autowired
    private SupportGroupsService supportGroupsService;

    @GetMapping("/supportGroups")
    public List<SupportGroups> getSupportGroups() {
        return this.supportGroupsService.getSupportGroups();
    }

    @PostMapping("/addGroups")
    public SupportGroups addSupportGroups(@RequestBody SupportGroups supportGroups) {
        return this.supportGroupsService.addSupportGroups(supportGroups);
    }

    @GetMapping("/{id}")
    public SupportGroups getSpecificGroup(@PathVariable String id) {
        return this.supportGroupsService.getSpecificGroup(id);
    }

    @PutMapping(value = "/updateGroupMembers/{id}")
    public ResponseEntity<SupportGroups> updateGroup(@PathVariable String id) {
        SupportGroups group = this.supportGroupsService.updateGroup(id);
        return ResponseEntity.ok(group);
    }
}
