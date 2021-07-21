package mimimimetr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mimimimetr.entity.VoteResult;


public interface VoteResultRepo extends CrudRepository<VoteResult, Long> {

    @Transactional
    @Modifying
    @Query(value="update vote_result set number_votes = number_votes + 1 where cat = ?1", nativeQuery = true)
    public void update(Long catId);
    
    @Query(value="select * from vote_result order by number_votes desc", nativeQuery = true)
    public List<VoteResult> getAll();
    
}
