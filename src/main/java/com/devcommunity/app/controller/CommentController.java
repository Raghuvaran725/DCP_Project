package com.devcommunity.app.controller;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.entity.Comment;
import com.devcommunity.app.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    ICommentService commentService;
    @PostMapping("/addComment")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.addComment(commentDTO), HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> addComment(@RequestBody AddCommentDTO addCommentDTO){
        return new ResponseEntity<>(commentService.create(addCommentDTO), HttpStatus.CREATED);
    }
    @PutMapping("/updateComment")
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.updateComment(commentDTO));
    }

    @DeleteMapping("/removeComment/{respId}")
    public ResponseEntity<CommentDTO> removeComment(@PathVariable("respId") Integer respId){
        return ResponseEntity.ok(commentService.removeComment(respId));
    }

    @GetMapping("/getNoOfVotesOnCommentByVoteType/{respId}/{voteType}")
    public ResponseEntity<Integer> getNoOfVotesOnCommentByVoteType(@PathVariable("respId") Integer respId,@PathVariable("voteType") String voteType){
        return ResponseEntity.ok(commentService.getNoOfVotesOnCommentByVoteType(voteType,respId));
    }

    @GetMapping("/getByCommentId/{id}")
    public ResponseEntity<CommentDTO> getByCommentId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.getByCommentId(id));
    }
    @GetMapping("/getCommentsByResponseId/{id}")
    public ResponseEntity<List<CommentDTO>> getCommentsByResponseId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.getCommentsByResponseId(id));
    }
    @GetMapping("/getCommentsByPostId/{id}")
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.getCommentsByPostId(id));
    }
}
