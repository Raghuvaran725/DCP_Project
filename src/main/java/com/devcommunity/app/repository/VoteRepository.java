package com.devcommunity.app.repository;

import com.devcommunity.app.entity.Vote;
import com.devcommunity.app.util.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    long countByComment_CommentIdAndDeveloperWhoVoted_IdAndVoteType(Integer commentId, Integer id, VoteType voteType);
    boolean existsByDeveloperWhoVoted_IdAndComment_CommentId(Integer id, Integer commentId);
}