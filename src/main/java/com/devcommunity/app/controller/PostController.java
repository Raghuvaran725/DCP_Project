package com.devcommunity.app.controller;

import com.devcommunity.app.dto.AddVoteDTO;
import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.dto.UpdatePostDTO;
import com.devcommunity.app.entity.Vote;
import com.devcommunity.app.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/post")
public class PostController{
    @Autowired
    IPostService postService;
    @PostMapping("/addPost")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.addPost(postDTO), HttpStatus.CREATED);
    }
    @PostMapping("/addVote")
    public ResponseEntity<Vote> addVote(@RequestBody AddVoteDTO addVoteDTO){
        return new ResponseEntity<>(postService.vote(addVoteDTO), HttpStatus.CREATED);
    }
    @PutMapping("/updatePost")
    public ResponseEntity<PostDTO> updatePost(@RequestBody UpdatePostDTO postDTO){
        return ResponseEntity.ok(postService.updatePost(postDTO));
    }

    @GetMapping("/getNoOfVotesOnPostByVoteType/{postId}/{voteType}")
    public ResponseEntity<Integer> getNoOfVotesOnPostByVoteType(@PathVariable("postId") Integer postId,@PathVariable("voteType") String voteType){
        return ResponseEntity.ok(postService.getNoOfVotesOnPostByVoteType(voteType,postId));
    }
    @GetMapping("/getPostById/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @DeleteMapping("/removePost/{postId}")
    public ResponseEntity<PostDTO> removePost(@PathVariable("postId") Integer postId){
        return ResponseEntity.ok(postService.removePost(postId));
    }

    @GetMapping("/getPostsByKeyword/{keyword}")
    public ResponseEntity<List<PostDTO>> getPostsByKeyword(@PathVariable("id") String keyword){
        return ResponseEntity.ok(postService.getPostsByKeyword(keyword));
    }

    @GetMapping("/getPostsByDeveloperId/{devId}")
    public ResponseEntity<List<PostDTO>> getPostsByDeveloperId(@PathVariable("devId") Integer devId){
        return ResponseEntity.ok(postService.getPostsByDeveloperId(devId));
    }

    @GetMapping("/getPostsByTopic/{topic}")
    public ResponseEntity<List<PostDTO>> getPostsByTopic(@PathVariable("topic") String topic){
        return ResponseEntity.ok(postService.getPostsByTopic(topic));
    }

    @GetMapping("/getPostsByDate/{date}")
    public ResponseEntity<List<PostDTO>> getPostsByDate(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(postService.getPostsByDate(date));
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
