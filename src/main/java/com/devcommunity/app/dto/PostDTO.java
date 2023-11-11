package com.devcommunity.app.dto;

import com.devcommunity.app.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO{

	private Integer postId;
	private String query;
	private LocalDateTime postDateTime;
	private String topic;
	private DeveloperDTO developer;
	private List<ResponseDTO> listOfResponse;
	private List<CommentDTO> listOfComment;
	private Integer noOfViews;
	private List<VoteDTO> vote;


	public static PostDTO toDTO(Post post) {
		return new PostDTO(post.getPostId(),post.getQuery(),post.getPostDateTime(),
				post.getTopic(),DeveloperDTO.toDTO(post.getDeveloper()),
				post.getListOfResponse().stream().map(ResponseDTO::toDTO).collect(Collectors.toList()),
				post.getListOfComment().stream().map(CommentDTO::toDTO).collect(Collectors.toList()),
				post.getNoOfViews(),
				post.getVote().stream().map(VoteDTO::toDTO).collect(Collectors.toList())
		);
	}

	public Post toObject() {
		return new Post(postId,query,postDateTime,topic,developer.toObject(),
				listOfResponse.stream().map(ResponseDTO::toObject).collect(Collectors.toList()),
				listOfComment.stream().map(CommentDTO::toObject).collect(Collectors.toList()),
				noOfViews,
				vote.stream().map(VoteDTO::toObject).collect(Collectors.toList())
		);
	}
}
