package git.oschina.test;
import git.oschina.App;
import git.oschina.entity.User;
import git.oschina.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhang_tao6 on 2017-08-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    /**
     * 因为是通过http连接到Neo4j数据库的，所以要预先启动Neo4j：neo4j console
     */
    @Test
    public void testInitData(){
        userService.initData();
    }
    @Test
    public void testGetUserByName(){
        User user = userService.getUserByName("Tom Hanks");
        System.out.println(user);
    }
}