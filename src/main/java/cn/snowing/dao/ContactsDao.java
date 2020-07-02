package cn.snowing.dao;

import cn.snowing.domain.Contact;
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
}
