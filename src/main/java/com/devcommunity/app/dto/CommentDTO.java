package com.devcommunity.app.dto;

import com.devcommunity.app.entity.Comment;
import com.devcommunity.app.entity.Response;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO  {
	private Integer commentId;
	private String text;
	private DeveloperDTO createdBy;
	private LocalDate createdDate;
	private VoteDTO vote;

	public static CommentDTO toDTO(Comment comment) {
		return new CommentDTO(comment.getCommentId(),comment.getText(),DeveloperDTO.toDTO(comment.getCreatedBy()),comment.getCreatedDate(),
				VoteDTO.toDTO(comment.getVote()));
	}


	public Comment toObject() {
		return new Comment(commentId,text,createdBy.toObject(),createdDate,vote.toObject(),null,null);
	}
}
