package org.family.repository;

import org.family.pojo.UserInfo;
import org.springframework.data.repository.CrudRepository;


/**
 * UserInfo持久化类;
 * @author DanteFung
 * @version v.0.1
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
	
	/**通过username查找用户信息;*/
	public UserInfo findByUsername(String username);
	
}
