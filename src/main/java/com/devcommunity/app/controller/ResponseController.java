package com.devcommunity.app.controller;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.dto.ResponseDTO;
import com.devcommunity.app.entity.Response;
import com.devcommunity.app.service.IResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/response")
public class ResponseController {
    @Autowired
    IResponseService responseService;
    @PostMapping("/addResponse")
    public ResponseEntity<ResponseDTO> addResponse(@RequestBody ResponseDTO responseDTO){
        return new ResponseEntity<>(responseService.addResponse(responseDTO), HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody AddCommentDTO responseDTO){
        return new ResponseEntity<>(responseService.create(responseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/updateResponse")
    public ResponseEntity<ResponseDTO> updateResponse(@RequestBody ResponseDTO responseDTO){
        return ResponseEntity.ok(responseService.updateResponse(responseDTO));
    }

    @DeleteMapping("/removeResponse/{respId}")
    public ResponseEntity<ResponseDTO> removeResponse(@PathVariable("respId") Integer respId){
        return ResponseEntity.ok(responseService.removeResponse(respId));
    }

    @GetMapping("/getResponseByPost/{id}")
    public ResponseEntity<List<ResponseDTO>> getResponseByPost(@PathVariable("id") Integer id){
        return ResponseEntity.ok(responseService.getResponseByPost(id));
    }

    @GetMapping("/getNoOfVotesOnResponseByVoteType/{respId}/{voteType}")
    public ResponseEntity<Integer> getNoOfVotesOnResponseByVoteType(@PathVariable("respId") Integer respId,@PathVariable("voteType") String voteType){
        return ResponseEntity.ok(responseService.getNoOfVotesOnResponseByVoteType(voteType,respId));
    }

    @GetMapping("/getResponseByDeveloper/{id}")
    public ResponseEntity<List<ResponseDTO>> getResponseByDeveloper(@PathVariable("id") Integer id){
        return ResponseEntity.ok(responseService.getResponseByDeveloper(id));
    }

}
