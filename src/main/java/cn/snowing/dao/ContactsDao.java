package cn.snowing.dao;

import cn.snowing.domain.Contact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联系人表持久层接口
 */
@Repository
public interface ContactsDao {

    /**
     * 查询所有联系人
     * @return
     */
    @Select("select username username, f_username fUsername, remark remark from contacts")
    public List<Contact> findAll();

    /**
     * 通过用户名查询联系人列表
     * @param username
     * @return
     */
    @Select("select username username, f_username fUsername, remark remark from contacts where username=#{username}")
    public List<Contact> findContactsByUsername(String username);

    //通过用户包和好友的用户名删除联系人记录
    @Delete("delete from contacts where f_username=#{f_username} and username=#{username}" )
    public void deleteContact(@Param("username")String username, @Param("f_username")String f_username);

    /**
     * 添加一条联系人记录
     * @param contact
     */
    @Insert("insert into contacts(username, f_username, remark) values(#{username}, #{fUsername}, #{remark})")
    public void insertContact(Contact contact);
}
