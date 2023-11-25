package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import com.MentalHealthProject.mentalHealth.services.UserExtraDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/extra")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExtraDetailsController {
    @Autowired
    private UserExtraDetailsService userExtraDetailsService;

    @GetMapping("/detail/{userId}")
    public UserExtraDetails getSpecificDetail(@PathVariable String userId) {
        return this.userExtraDetailsService.getSpecificDetail(userId);
    }

    @PostMapping("/addDetails")
    public UserExtraDetails addDetails(@RequestBody UserExtraDetails userExtraDetails) {
        return this.userExtraDetailsService.addDetails(userExtraDetails);
    }

    @GetMapping("/getMood/{userId}")
    public List<Mood> getMood(@PathVariable String userId, @RequestHeader(name="MyDate") String date) {
        return this.userExtraDetailsService.getMood(userId, date);
    }

    @GetMapping("/getJoinedGroups/{userId}")
    public List<String> getGroupsJoined(@PathVariable String userId) {
        return this.userExtraDetailsService.getGroupsJoined(userId);
    }

    @PutMapping(value = "/addMood/{userId}")
    public UserExtraDetails addMood(@PathVariable String userId, @RequestBody Mood userMood) {
        return this.userExtraDetailsService.addMood(userId, userMood);
    }

    @PutMapping(value = "/addGroup/{userId}")
    public ResponseEntity<HttpStatus> addGroups(@PathVariable String userId, @RequestBody String groupId) {
        try {
            this.userExtraDetailsService.addGroups(userId, groupId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/moodsAvg/{userId}")
    public Map<String, Integer> moodsAvg(@PathVariable String userId) {
        return this.userExtraDetailsService.returnAvg(userId);
    }

    @PutMapping(value = "/task/{userId}")
    public void addTasks(@PathVariable String userId, @RequestBody List<Boolean> completed) {
        this.userExtraDetailsService.addTasks(userId, completed);
    }

    @GetMapping("/tasksCompleted/{userId}")
    public ResponseEntity<List<Boolean>> tasksCompleted(@PathVariable String userId) {
        try {
            List<Boolean> ans = this.userExtraDetailsService.tasksCompleted(userId);
            return ResponseEntity.status(HttpStatus.OK).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
