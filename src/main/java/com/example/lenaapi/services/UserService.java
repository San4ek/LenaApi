package com.example.lenaapi.services;

import com.example.lenaapi.entites.User;
import com.example.lenaapi.exceptions.user.NoSuchUserException;
import com.example.lenaapi.exceptions.user.SuchUserAlreadyExistsException;
import com.example.lenaapi.exceptions.user.UserIsBlockedException;
import com.example.lenaapi.models.CredentialsModel;
import com.example.lenaapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User registerUser(CredentialsModel credentialsModel) throws SuchUserAlreadyExistsException {
        if (userRepository.existsByLogin(credentialsModel.getLogin())) {
            throw new SuchUserAlreadyExistsException();
        } else {
            return userRepository.save(new User(credentialsModel.getLogin(), credentialsModel.getPassword()));
        }
    }

    public int updateBlockUser(String login, boolean isBLocked) throws NoSuchUserException {
        if (!userRepository.existsByLogin(login)) throw new NoSuchUserException();

        return userRepository.updateBlockStatus(login, isBLocked);
    }

    public User authUser(CredentialsModel credentialsModel) throws NoSuchUserException, UserIsBlockedException {

        Optional<User> optionalUser=userRepository.findByLoginAndPassword(credentialsModel.getLogin(), credentialsModel.getPassword());

        if (optionalUser.isEmpty()) throw  new NoSuchUserException();

        if (optionalUser.get().isBlocked()) throw new UserIsBlockedException();

        return optionalUser.get();
    }

    public long changeUserCredentials(CredentialsModel credentialsModel, Long id) throws SuchUserAlreadyExistsException, NoSuchUserException {

        Optional<User> optionalUser=userRepository.findByLogin(credentialsModel.getLogin());

        if (optionalUser.isPresent() && !optionalUser.get().getId().equals(id)) {
            throw new SuchUserAlreadyExistsException();
        }

        User user=new User();
        user.setId(id);
        user.setLogin(credentialsModel.getLogin());
        user.setPassword(credentialsModel.getPassword());
        user.setBlocked(credentialsModel.isBlocked());

        return userRepository.save(user).getId();
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByRole(User.Role.USER);
    }
}
