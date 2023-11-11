package com.devcommunity.app.service;

import com.devcommunity.app.dto.AddVoteDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.dto.UpdatePostDTO;
import com.devcommunity.app.entity.Comment;
import com.devcommunity.app.entity.Developer;
import com.devcommunity.app.entity.Post;
import com.devcommunity.app.entity.Vote;
import com.devcommunity.app.exception.ItemAlreadyExistException;
import com.devcommunity.app.repository.CommentRepository;
import com.devcommunity.app.repository.DeveloperRepository;
import com.devcommunity.app.repository.PostRepository;
import com.devcommunity.app.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post = postDTO.toObject();
        post.setPostId(null);
        post.setNoOfViews(0);
        post.setPostDateTime(LocalDateTime.now());
        postRepository.save(post);
        return PostDTO.toDTO(post);
    }

    @Override
    public PostDTO updatePost(UpdatePostDTO postDTO) {
        Post post =postRepository.findById(postDTO.getPostId()).orElseThrow();
        post.setQuery(postDTO.getQuery());
        post.setTopic(postDTO.getTopic());
        postRepository.save(post);
        return PostDTO.toDTO(post);
    }

    @Override
    public Integer getNoOfVotesOnPostByVoteType(String voteType, Integer postId) {
        return postRepository.findById(postId).orElseThrow().getNoOfViews();
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        var post = postRepository.findById(postId).orElseThrow();
        post.setNoOfViews(post.getNoOfViews() + 1);
        postRepository.save(post);
        return PostDTO.toDTO(post);
    }

    @Override
    public PostDTO removePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.deleteById(postId);
        return PostDTO.toDTO(post);
    }

    @Override
    public List<PostDTO> getPostsByKeyword(String keyword) {
        return postRepository.findByQueryContains(keyword)
                .stream().map(PostDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostsByDeveloperId(Integer develoerId) {
        return postRepository.findByDeveloper_Id(develoerId)
                .stream().map(PostDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostsByTopic(String topic) {
        return postRepository.findByTopicContainsIgnoreCase(topic)
                .stream().map(PostDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostsByDate(LocalDate date) {
        return postRepository.findAll().stream()
                .filter(item -> item.getPostDateTime().toLocalDate().equals(date))
                .map(PostDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(PostDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public Vote vote(AddVoteDTO r) {
        if(voteRepository.existsByDeveloperWhoVoted_IdAndComment_CommentId(r.getDeveloperId(),r.getCommentId()))
            throw new ItemAlreadyExistException("Already Voted for this comment");
        Comment comment = commentRepository.findById(r.getCommentId()).orElseThrow();
        Developer developer = developerRepository.findById(r.getDeveloperId()).orElseThrow();
        Vote vote = new Vote(null,r.getVoteType(),developer,comment);
        voteRepository.save(vote);
        comment.setVote(vote);
        commentRepository.save(comment);
        return vote;
    }
}
