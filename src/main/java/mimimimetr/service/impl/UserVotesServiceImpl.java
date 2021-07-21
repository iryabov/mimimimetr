package mimimimetr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mimimimetr.entity.UserVotes;
import mimimimetr.repository.UserVotesRepo;
import mimimimetr.service.UserVotesService;

@Service
public class UserVotesServiceImpl implements UserVotesService {
    
    @Autowired
    private UserVotesRepo userVotesRepo;
    
    @Override
    public List<UserVotes> findAllById(Long userId) {
        return userVotesRepo.findAllById(userId);
    }
    
    @Override
    public void save(UserVotes userVote) {
        userVotesRepo.save(userVote);
    }

}
