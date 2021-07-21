package mimimimetr.service;

import java.util.Optional;

import mimimimetr.entity.Cat;

public interface CatService {

    Optional<Cat> getById(Long id);

}
