package com.devcommunity.app.service;


import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICommentService {

	CommentDTO addComment(CommentDTO  comment);
	Comment create(AddCommentDTO addCommentDTO);

	CommentDTO  updateComment(CommentDTO  comment);

	CommentDTO  removeComment(Integer respId);

	Integer getNoOfVotesOnCommentByVoteType(String  voteType, Integer commentId);

	CommentDTO  getByCommentId(Integer commentId);

	List<CommentDTO > getCommentsByPostId(Integer postId);

	List<CommentDTO > getCommentsByResponseId(Integer resId);
}
