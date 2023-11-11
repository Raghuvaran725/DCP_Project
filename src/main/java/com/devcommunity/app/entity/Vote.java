package com.devcommunity.app.entity;


import com.devcommunity.app.util.VoteType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voteId;
	private VoteType voteType;
	@OneToOne
	private Developer developerWhoVoted;
	@OneToOne
	@JsonIgnore
	private Comment comment;
}
