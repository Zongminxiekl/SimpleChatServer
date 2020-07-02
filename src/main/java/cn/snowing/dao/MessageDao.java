package cn.snowing.dao;

import cn.snowing.domain.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 消息Dao接口
 */
@Repository
public interface MessageDao {

    /**
     * 查询所有账户信息
     *
     * @return
     */
    @Select("SELECT message_id messageId, username userName" +
            ", f_username fUsername, message_content messageContent" +
            ", post_time messageDate " +
            " from message")
    public List<Message> findAll();

    /**
     * 通过用户名查询消息记录
     * @param username
     * @return
     */
    @Select("SELECT message_id messageId, username userName" +
            ", f_username fUsername, message_content messageContent" +
            ", post_time messageDate " +
            " from message where username = #{username}")
    public List<Message> findMessageByUsername(String username);

    /**
     * 查询与用户通信的朋友的用户名，因为和好友之间会有多个消息记录。因此要使用DISTINCT关键字去重
     * @param username
     * @return
     */
    @Select("SELECT DISTINCT f_username  from message WHERE username = #{username}")
    public List<String> findFUsernameByUsername(String username);

    /**
     * 查询与用户通信的朋友的用户名
     * @param username, fUsername 有多个参数时，使用Param注解指定对应的预处理对象
     * @return 用户会话消息列表
     */
    @Select("SELECT message_id messageId, username userName " +
            ", f_username fUsername, message_content messageContent" +
            ", post_time messageDate " +
            "  from message " +
            " WHERE username = #{username} and f_username = #{fUsername} " +
            " ORDER BY post_time DESC ")
    public List<Message> findMessageByfUsernameAndUsername(@Param("username") String username, @Param("fUsername") String fUsername);
}
