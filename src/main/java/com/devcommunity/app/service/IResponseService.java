package com.devcommunity.app.service;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.ResponseDTO;
import com.devcommunity.app.entity.Response;

import java.util.List;

public interface IResponseService {

	ResponseDTO addResponse(ResponseDTO  response);
	Response create(AddCommentDTO r);

	ResponseDTO  updateResponse(ResponseDTO  response);

	ResponseDTO  removeResponse(Integer respId);

	List<ResponseDTO > getResponseByPost(Integer postId);

	Integer getNoOfVotesOnResponseByVoteType(String  voteType, Integer resId);

	List<ResponseDTO > getResponseByDeveloper(Integer devId);

}
