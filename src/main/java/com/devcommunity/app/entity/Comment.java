package com.devcommunity.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String text;
	@JsonIgnore
	@ManyToOne
	private Developer createdBy;
	private LocalDate createdDate;
	@ManyToOne
	private Vote vote;
	@JsonIgnore
	@ManyToOne
	private Post post;
	@JsonIgnore
	@ManyToOne
	private Response response;
}
