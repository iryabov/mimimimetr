package mimimimetr.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mimimimetr.entity.Cat;
import mimimimetr.repository.CatRepo;
import mimimimetr.service.CatService;


@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepo catRepo;

    @Override
    public Optional<Cat> getById(Long id) {
        return catRepo.findById(id);
    }
    
}
