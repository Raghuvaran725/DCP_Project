package com.devcommunity.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer respId;
	private String answer;
	private LocalDateTime respDateTime;
	@ManyToOne
	@JsonIgnore
	private Post post;
	@OneToOne
	private Developer developer;
	@OneToMany(mappedBy="response")
	private List<Comment> listOfComments;
	@OneToMany
	private List<Vote> vote;

}
