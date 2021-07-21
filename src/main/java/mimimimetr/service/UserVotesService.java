package mimimimetr.service;

import java.util.List;

import mimimimetr.entity.UserVotes;

public interface UserVotesService {

    List<UserVotes> findAllById(Long userId);

    void save(UserVotes userVote);

}
