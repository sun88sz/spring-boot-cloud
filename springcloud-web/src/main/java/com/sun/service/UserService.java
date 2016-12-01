package com.sun.service;

import com.sun.bean.User;
import com.sun.dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Created by Sun on 16/11/7.
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private IUserDAO userDAO;

	public List<User> findAll() {
		List<User> all = userDAO.findAll();
		return all;
	}

	public List<User> findByUsername(String username) {
		List<User> list = userDAO.findByUsername(username);
		return list;
	}

	public User save(User u) {
		User save = userDAO.save(u);
		return save;
	}

	public User getById(Long id) {
		User one = userDAO.findOne(id);
		return one;
	}

	public User update(Long id, User u) {
		User user = getById(id);
		return userDAO.saveAndFlush(u);
	}

	public Page<User> findBySpecAndPaginate(com.sun.bean.Page page) {
		Page<User> users = userDAO.findAll((root, query, cb) -> {
			root = query.from(User.class);
			Path<String> nameExp = root.get("username");
			Path<Long> userIdExp = root.get("userId");

			query.where(cb.like(nameExp, "%139%"), cb.greaterThan(userIdExp, 300l));

			return null;
		} , new PageRequest(page.getPageNo(), page.getPageSize(),
				new Sort(Sort.Direction.DESC, new String[] { "userId" })));
		return users;
	}

	public Page<User> findByOr(com.sun.bean.Page page) {
		Page<User> users = userDAO.findAll((root, query, cb) -> {
			root = query.from(User.class);
			Path<String> nameExp = root.get("username");
			Path<Long> userIdExp = root.get("userId");

			Predicate orp = cb.or(cb.like(nameExp, "%1391%"), cb.greaterThan(userIdExp, 300l),
					cb.and(cb.like(nameExp, "%xx%"), cb.lt(userIdExp, 500l)));
			return orp;
		} , new PageRequest(page.getPageNo(), page.getPageSize(),
				new Sort(Sort.Direction.DESC, new String[] { "userId" })));
		return users;
	}

}
