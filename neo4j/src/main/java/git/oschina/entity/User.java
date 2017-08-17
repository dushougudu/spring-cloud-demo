package git.oschina.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.List;

/**
 * Created by zhang_tao6 on 2017-08-09.
 */
@Data
@NodeEntity(label = "USERS")
public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @GraphId
    private Long nodeId;
    @Property(name = "name")
    private String name;
    //关系直接定义在节点中
    @Relationship(type = "IS_FRIEND_OF", direction = Relationship.OUTGOING)
    private List<User> friends;
    //使用外部定义的关系
    @Relationship(type = "HAS_SEEN")
    private List<Seen> hasSeenMovies;
}

