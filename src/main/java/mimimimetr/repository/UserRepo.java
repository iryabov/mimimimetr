package mimimimetr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mimimimetr.entity.User;


public interface UserRepo extends CrudRepository<User, Long> {
    
    @Query(value = "select * from usr where username = ?1", nativeQuery = true)
    public User findByUsername(String username);

}
