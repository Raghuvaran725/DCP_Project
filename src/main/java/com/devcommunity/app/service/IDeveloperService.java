package com.devcommunity.app.service;



import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.dto.PostDTO;

import java.util.List;

public interface IDeveloperService {

	DeveloperDTO addDeveloper(DeveloperDTO developer);

	DeveloperDTO updateDeveloper(DeveloperDTO developer);

	List<DeveloperDTO> getDeveloperByStatus(String status);

	DeveloperDTO getDeveloperById(Integer devId);

	List<DeveloperDTO> getDeveloperByReputation(Integer reputation);

	List<DeveloperDTO> getAllDevelopers();

	List<PostDTO> getPostsByDeveloper(Integer devId);

	List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts);

	DeveloperDTO getByMaxReputation();

}
