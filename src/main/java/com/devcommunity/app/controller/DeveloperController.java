package com.devcommunity.app.controller;

import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/developer")
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @PostMapping("/addDeveloper")
    public ResponseEntity<DeveloperDTO> addDeveloper(@RequestBody DeveloperDTO developerDT){
        return new ResponseEntity<>(developerService.addDeveloper(developerDT), HttpStatus.CREATED);
    }
    @PutMapping("/updateDeveloper")
    public ResponseEntity<DeveloperDTO> updateDeveloper(@RequestBody DeveloperDTO developerDT){
        return ResponseEntity.ok(developerService.updateDeveloper(developerDT));
    }

    @GetMapping("/getDeveloperByStatus/{status}")
    public ResponseEntity<List<DeveloperDTO>> getDeveloperByStatus(@PathVariable("status") String status){
        return ResponseEntity.ok(developerService.getDeveloperByStatus(status));
    }

    @GetMapping("/getDeveloperById/{id}")
    public ResponseEntity<DeveloperDTO> getDeveloperById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(developerService.getDeveloperById(id));
    }

    @GetMapping("/getDeveloperByReputation/{reputation}")
    public ResponseEntity<List<DeveloperDTO>> getDeveloperByReputation(@PathVariable("reputation") Integer reputation){
        return ResponseEntity.ok(developerService.getDeveloperByReputation(reputation));
    }

    @GetMapping("/getAllDevelopers")
    public ResponseEntity<List<DeveloperDTO>> getAllDevelopers(){
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }

    @GetMapping("/getPostsByDeveloper/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByDeveloper(@PathVariable("id") Integer id){
        return ResponseEntity.ok(developerService.getPostsByDeveloper(id));
    }

    @GetMapping("/getByMaxReputation")
    public ResponseEntity<DeveloperDTO> getByMaxReputation(){
        return ResponseEntity.ok(developerService.getByMaxReputation());
    }
}
