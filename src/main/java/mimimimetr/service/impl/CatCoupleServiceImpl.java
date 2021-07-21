package mimimimetr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mimimimetr.entity.CatCouple;
import mimimimetr.entity.UserVotes;
import mimimimetr.repository.CatCoupleRepo;
import mimimimetr.service.CatCoupleService;
import mimimimetr.service.UserVotesService;


@Service
public class CatCoupleServiceImpl implements CatCoupleService {

    @Autowired
    private CatCoupleRepo catCoupleRepo;

    @Autowired
    private UserVotesService userVotesService;

    @Override
    public List<CatCouple> findAll() {
        return (List<CatCouple>) catCoupleRepo.findAll();
    }

    @Override
    public List<CatCouple> getAvailableList(Long userId) {
        List<CatCouple> catCouples = findAll();
        List<UserVotes> userVotes = userVotesService.findAllById(userId);
        List<CatCouple> availableCouples = new ArrayList<>();
        
        if (userVotes.isEmpty()) {
            return catCouples;
        }
        
        int count = 0;
        for (int i = 0; i < catCouples.size(); i++) {
            for (int j = 0; j < userVotes.size(); j++) {
                if (userVotes.get(j).getCatCouple().getId().equals(catCouples.get(i).getId())) {
                    count++;
                }
                if (j == userVotes.size() - 1) {
                    if (count == 0) {
                        availableCouples.add(catCouples.get(i));
                        
                    } else {
                        count = 0;
                    }
                }
            }
        }

        return availableCouples;
    }
    
    @Override
    public Optional<CatCouple> findById(Long id) {
        return catCoupleRepo.findById(id);
    }

}
