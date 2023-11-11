package com.devcommunity.app.dto;

import com.devcommunity.app.entity.Developer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class DeveloperDTO  {
	private Integer id;
	private String devName;
	private String devSkill;
	private LocalDate memberSince;
	// If no. of Upvote on Post is 5, then reputation value is 1
	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
	private Integer reputation;
	// Block or Unblock
	private String status;
	@JsonIgnore
	private List<PostDTO> listOfPosts;
	private UserDTO user;

	public static DeveloperDTO toDTO(Developer d) {
		return new DeveloperDTO(d.getId(),d.getDevName(),d.getDevSkill(),d.getMemberSince(),d.getReputation(),d.getStatus(),
				null, UserDTO.toDTO(d.getUser()));
	}

	public Developer toObject() {
		return new Developer(id,devName,devSkill,memberSince,reputation,status,
				 user.toObject());
	}
}