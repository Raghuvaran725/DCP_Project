package com.devcommunity.app.dto;

import com.devcommunity.app.entity.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

	private Integer respId;
	private String answer;
	private LocalDateTime respDateTime;
	private DeveloperDTO developer;
	private List<CommentDTO> listOfComments;
	private List<VoteDTO> vote;


	public static ResponseDTO toDTO(Response r) {
		return new ResponseDTO(r.getRespId(),r.getAnswer(),r.getRespDateTime(),
				DeveloperDTO.toDTO(r.getDeveloper()),
				r.getListOfComments().stream().map(CommentDTO::toDTO).collect(Collectors.toList()),
				r.getVote().stream().map(VoteDTO::toDTO).collect(Collectors.toList()));
	}

	public Response toObject() {
		return new Response(respId,answer,respDateTime,null,developer.toObject(),
				listOfComments.stream().map(CommentDTO::toObject).collect(Collectors.toList()),
				vote.stream().map(VoteDTO::toObject).collect(Collectors.toList()));
	}
}
