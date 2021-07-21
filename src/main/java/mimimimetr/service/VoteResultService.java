package mimimimetr.service;

import java.util.List;

import mimimimetr.entity.VoteResult;

public interface VoteResultService {

    void update(Long catId);

    List<VoteResult> getAll();

}
