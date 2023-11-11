package com.devcommunity.app.dto;


import com.devcommunity.app.entity.Vote;
import com.devcommunity.app.util.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO  {
	private Integer voteId;
	private VoteType voteType;
	private DeveloperDTO developerWhoVoted;



	public static VoteDTO toDTO(Vote v) {
		if(v == null) return null;
		return new VoteDTO(v.getVoteId(),v.getVoteType(),DeveloperDTO.toDTO(v.getDeveloperWhoVoted()));
	}

	public Vote toObject() {
		return new Vote(voteId,voteType,developerWhoVoted.toObject(),null);
	}
}
