package mimimimetr.service;

import java.util.List;
import java.util.Optional;

import mimimimetr.entity.CatCouple;


public interface CatCoupleService {

    List<CatCouple> findAll();

    Optional<CatCouple> findById(Long id);

    List<CatCouple> getAvailableList(Long userId);

}
