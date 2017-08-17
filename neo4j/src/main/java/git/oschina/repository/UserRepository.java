package git.oschina.repository;

import git.oschina.entity.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhang_tao6 on 2017-08-09.
 */
@Repository
public interface UserRepository extends GraphRepository<User>{
    @Query("MATCH (user:USERS {name:{name}}) RETURN user")
    User getUserByName(@Param("name") String name);
}

