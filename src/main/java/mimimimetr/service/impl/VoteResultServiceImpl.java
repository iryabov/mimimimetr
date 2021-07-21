package mimimimetr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mimimimetr.entity.VoteResult;
import mimimimetr.repository.VoteResultRepo;
import mimimimetr.service.VoteResultService;


@Service
public class VoteResultServiceImpl implements VoteResultService {

    @Autowired
    private VoteResultRepo voteResultRepo;

    @Override
    public void update(Long catId) {
        voteResultRepo.update(catId);
    }
    
    @Override
    public List<VoteResult> getAll() {
        
        return voteResultRepo.getAll();
    }
}
