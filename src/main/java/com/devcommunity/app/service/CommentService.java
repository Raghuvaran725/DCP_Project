package com.devcommunity.app.service;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.entity.Comment;
import com.devcommunity.app.repository.CommentRepository;
import com.devcommunity.app.repository.DeveloperRepository;
import com.devcommunity.app.repository.PostRepository;
import com.devcommunity.app.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ResponseRepository responseRepository;


    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = commentDTO.toObject();
        comment.setCreatedDate(LocalDate.now());
        comment.setCommentId(null);
        commentRepository.save(comment);
        return CommentDTO.toDTO(comment);
    }

    @Override
    public Comment create(AddCommentDTO c) {
        var dev = developerRepository.findById(c.getDeveloperId()).orElseThrow();
        Comment comment = new Comment(null,c.getComment(),dev,LocalDate.now(),null,null,null);
        if(c.getIsPost()){
            comment.setPost(postRepository.findById(c.getPostId()).orElseThrow());
        } else {
            comment.setResponse(responseRepository.findById(c.getResponseId()).orElseThrow());
        }
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDTO) {
        Comment comment = commentDTO.toObject();
        commentRepository.save(comment);
        return CommentDTO.toDTO(comment);
    }

    @Override
    public CommentDTO removeComment(Integer respId) {
        Comment comment = commentRepository.findById(respId).orElseThrow();
        commentRepository.delete(comment);
        return CommentDTO.toDTO(comment);
    }

    @Override
    public Integer getNoOfVotesOnCommentByVoteType(String voteType, Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return comment.getPost().getNoOfViews();
    }

    @Override
    public CommentDTO getByCommentId(Integer commentId) {
        return CommentDTO.toDTO(commentRepository.findById(commentId).orElseThrow());
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPost_PostId(postId)
                .stream().map(CommentDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getCommentsByResponseId(Integer resId) {
        return commentRepository.findByResponse_RespId(resId)
                .stream().map(CommentDTO::toDTO)
                .collect(Collectors.toList());
    }
}
