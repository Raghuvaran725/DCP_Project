package com.devcommunity.app.service;

import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.entity.Developer;
import com.devcommunity.app.exception.DeveloperCommunityException;
import com.devcommunity.app.exception.ItemNotFoundException;
import com.devcommunity.app.repository.DeveloperRepository;
import com.devcommunity.app.repository.PostRepository;
import com.devcommunity.app.repository.VoteRepository;
import com.devcommunity.app.util.VoteType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DeveloperService implements IDeveloperService{
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;
    @Override
    @Transactional
    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
        var developer = developerDTO.toObject();
        developer.setId(null);
        developer.setReputation(0);
        var userDto = userService.registerUser(developerDTO.getUser());
        developer.setMemberSince(LocalDate.now());
        developer.setUser(userDto.toObject());
        log.info("USER_INFO "+userDto.toString());
        developerRepository.save(developer);
        return DeveloperDTO.toDTO(developer);
    }

    @Override
    public DeveloperDTO updateDeveloper(DeveloperDTO developerDTO) {
        var developer = developerDTO.toObject();
        developerRepository.save(developer);
        return DeveloperDTO.toDTO(developer);
    }

    @Override
    public List<DeveloperDTO> getDeveloperByStatus(String status) {
        return devListToDtoList(developerRepository.findByStatusIgnoreCase(status));
    }

    @Override
    public DeveloperDTO getDeveloperById(Integer devId) {
        return DeveloperDTO.toDTO(developerRepository.findById(devId).orElseThrow(ItemNotFoundException::new));
    }

    @Override
    public List<DeveloperDTO> getDeveloperByReputation(Integer reputation) {
        return devListToDtoList(developerRepository.findByReputation(reputation));
    }

    @Override
    public List<DeveloperDTO> getAllDevelopers() {
       List<Developer> list = developerRepository.findAll().stream().map(developer -> {
           var posts = postRepository.findByDeveloper_Id(developer.getId());
           posts.forEach(post -> {
               final long[] count = {0};
               post.getListOfComment().forEach(comment -> {
                  count[0] = count[0] + voteRepository.countByComment_CommentIdAndDeveloperWhoVoted_IdAndVoteType(
                    comment.getCommentId(),
                    developer.getId(),
                    VoteType.UPVOTE
                  );
               });
               post.getListOfResponse().forEach(response -> {
                  response.getListOfComments().forEach(comment -> {
                      count[0] = count[0] + voteRepository.countByComment_CommentIdAndDeveloperWhoVoted_IdAndVoteType(
                              comment.getCommentId(),
                              developer.getId(),
                              VoteType.UPVOTE
                      );
                  });
              });
               developer.setReputation((int) Math.floor(count[0]/5));
           });
           developerRepository.save(developer);
           return developer;
        }).collect(Collectors.toList());

        return devListToDtoList(list);
    }

    @Override
    public List<PostDTO> getPostsByDeveloper(Integer devId) {
        return postRepository.findByDeveloper_Id(devId).stream().map(PostDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts) {
        return devListToDtoList(developerRepository.findByReputation(noOfPosts));
    }

    @Override
    public DeveloperDTO getByMaxReputation() {
        return getAllDevelopers().stream().max(Comparator.comparingInt(DeveloperDTO::getReputation)).orElseThrow();
    }

    public List<DeveloperDTO> devListToDtoList(List<Developer> developers){
        return developers.stream().map(DeveloperDTO::toDTO).collect(Collectors.toList());
    }
}
