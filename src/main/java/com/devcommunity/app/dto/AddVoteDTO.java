package com.devcommunity.app.dto;

import com.devcommunity.app.util.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddVoteDTO {
    private Integer developerId;
    private Integer commentId;
    private VoteType voteType;
}
