package com.devcommunity.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String devName;
	private String devSkill;
	private LocalDate memberSince;
	// If no. of Upvote on Post is 5, then reputation value is 1
	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
	private Integer reputation;
	// Block or Unblock
	private String status;
//	@OneToMany(mappedBy="developer")
//	private List<Post> listOfPosts;

	@OneToOne
	private User user;

}