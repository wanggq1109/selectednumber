package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository
public interface IUserDao extends CrudRepository<User, Long>{
	public User findByName(String name);
}
