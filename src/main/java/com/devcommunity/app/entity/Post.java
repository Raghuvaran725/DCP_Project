package com.devcommunity.app.entity;

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
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String query;
	private LocalDateTime postDateTime;
	private String topic;
	@ManyToOne
	private Developer developer;
	@OneToMany(mappedBy="post")
	private List<Response> listOfResponse;
	@OneToMany(mappedBy="post")
	private List<Comment> listOfComment;
	private Integer noOfViews;
	@OneToMany
	private List<Vote> vote;
}
