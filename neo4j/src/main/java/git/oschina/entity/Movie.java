package git.oschina.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by zhang_tao6 on 2017-08-09.
 */
@Data
@NodeEntity(label = "MOVIES")
public class Movie {
    public Movie(String name) {
        this.name = name;
    }

    @GraphId
    private Long nodeId;
    @Property(name = "name")
    private String name;
}
