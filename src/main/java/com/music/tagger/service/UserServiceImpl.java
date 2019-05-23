package com.music.tagger.service;

import com.music.tagger.controller.dto.UserDto;
import com.music.tagger.exceptions.RoleNotFoundException;
import com.music.tagger.exceptions.UserAlreadyExistException;
import com.music.tagger.exceptions.UserNotFoundException;
import com.music.tagger.persistence.entity.User;
import com.music.tagger.persistence.repository.RoleRepository;
import com.music.tagger.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException, RoleNotFoundException {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        User user = new User();

        user.setName(accountDto.getFirstName() + " " + accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setEnabled(true);
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER").orElseThrow(RoleNotFoundException::new)));
        return userRepository.save(user);
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserAlreadyExistException::new);
    }

    @Override
    public void saveAndFlush(User entity) {
        userRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }
}
