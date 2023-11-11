package com.devcommunity.app.service;


import com.devcommunity.app.dto.AddVoteDTO;
import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.dto.UpdatePostDTO;
import com.devcommunity.app.entity.Post;
import com.devcommunity.app.entity.Vote;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface IPostService {

	PostDTO addPost(PostDTO post);

	PostDTO updatePost(UpdatePostDTO post);

	Integer getNoOfVotesOnPostByVoteType(String voteType, Integer postId);

	PostDTO getPostById(Integer postId);

	PostDTO removePost(Integer postId);

	List<PostDTO> getPostsByKeyword(String keyword);

	List<PostDTO> getPostsByTopic(String topic);

	List<PostDTO> getPostsByDate(LocalDate date);

	List<PostDTO> getAllPosts();
	Vote vote(AddVoteDTO r);
	List<PostDTO> getPostsByDeveloperId(Integer develoerId);

}