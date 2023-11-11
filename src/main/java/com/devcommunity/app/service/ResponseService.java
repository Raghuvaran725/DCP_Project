package com.devcommunity.app.service;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.ResponseDTO;
import com.devcommunity.app.entity.Response;
import com.devcommunity.app.repository.DeveloperRepository;
import com.devcommunity.app.repository.PostRepository;
import com.devcommunity.app.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseService implements IResponseService{
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public ResponseDTO addResponse(ResponseDTO responseDTO) {
        Response response = responseDTO.toObject();
        response.setRespDateTime(LocalDateTime.now());
        responseRepository.save(response);
        return ResponseDTO.toDTO(response);
    }

    @Override
    public Response create(AddCommentDTO r) {
        var dev = developerRepository.findById(r.getDeveloperId()).orElseThrow();
        var post = postRepository.findById(r.getPostId()).orElseThrow();
        Response response = new Response(null,r.getComment(),LocalDateTime.now(),post,dev,new ArrayList<>(),new ArrayList<>());
        responseRepository.save(response);
        return response;
    }

    @Override
    public ResponseDTO updateResponse(ResponseDTO response) {
         responseRepository.save(response.toObject());
        return response;
    }

    @Override
    public ResponseDTO removeResponse(Integer respId) {
        var R = responseRepository.findById(respId).orElseThrow();
        responseRepository.deleteById(respId);
        return ResponseDTO.toDTO(R);
    }

    @Override
    public List<ResponseDTO> getResponseByPost(Integer postId) {
        return responseRepository.findByPost_PostId(postId)
                .stream().map(ResponseDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNoOfVotesOnResponseByVoteType(String voteType, Integer resId) {
        return responseRepository.findById(resId).orElseThrow().getPost().getNoOfViews();
    }

    @Override
    public List<ResponseDTO> getResponseByDeveloper(Integer devId) {
        return responseRepository.findByDeveloper_Id(devId)
                .stream().map(ResponseDTO::toDTO)
                .collect(Collectors.toList());
    }
}
