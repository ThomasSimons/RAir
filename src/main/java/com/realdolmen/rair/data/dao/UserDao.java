package com.realdolmen.rair.data.dao;

import com.realdolmen.rair.domain.entities.user.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDao extends AbstractDao<User, Long> {

    @Override
    protected Class<User> getDataType() {
        return User.class;
    }
}
