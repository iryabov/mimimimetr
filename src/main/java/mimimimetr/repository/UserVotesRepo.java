package mimimimetr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mimimimetr.entity.UserVotes;

public interface UserVotesRepo extends CrudRepository<UserVotes, Long> {

    @Query(value = "select * from user_votes where usr = ?1", nativeQuery = true)
    public List<UserVotes> findAllById(Long id);
}
