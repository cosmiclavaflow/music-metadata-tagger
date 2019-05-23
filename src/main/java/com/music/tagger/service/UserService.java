package com.music.tagger.service;

import com.music.tagger.controller.dto.UserDto;
import com.music.tagger.exceptions.RoleNotFoundException;
import com.music.tagger.exceptions.UserAlreadyExistException;
import com.music.tagger.persistence.entity.User;

public interface UserService extends Service<User>{

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException, RoleNotFoundException;

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);
}
