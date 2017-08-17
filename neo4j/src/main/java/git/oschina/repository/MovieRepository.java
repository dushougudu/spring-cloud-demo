package git.oschina.repository;

import git.oschina.entity.Movie;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhang_tao6 on 2017-08-09.
 */
@Repository
public interface MovieRepository extends GraphRepository<Movie> {
}
