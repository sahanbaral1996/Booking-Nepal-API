package com.booking.services;


import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.*;

import com.booking.entity.Users;
import com.booking.repository.UserRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Value("${aws.cognito.userPoolId}")
    private String AWS_POOL_ID;

    @Value("${aws.cognito.clientId}")
    private String AWS_CLIENT_ID;

    private final AWSCognitoIdentityProvider identityProvider;
    private final UserRepository userRepository;

    public UserService(AWSCognitoIdentityProvider identityProvider, UserRepository userRepository) {
        this.identityProvider = identityProvider;
        this.userRepository = userRepository;
    }

    public List<Users> getAll() throws RuntimeException {
        List<Users> userList = userRepository.findAll();
        return userList;
    }

    private boolean doesUserExist(String email){
        AdminGetUserRequest userRequest = new AdminGetUserRequest().withUserPoolId(AWS_POOL_ID).withUsername(email);
        try{

            AdminGetUserResult result = identityProvider.adminGetUser(userRequest);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Users saveUser(Users user) throws RuntimeException {
        try {
            if(doesUserExist(user.getUsername())){
                throw new RuntimeException("User Already exists!");
            }
            AdminCreateUserRequest createUserRequest = new AdminCreateUserRequest().
                    withUserPoolId(AWS_POOL_ID).
                    withUsername(user.getUsername()).
                    withUserAttributes(new AttributeType().withName("email").withValue(user.getUsername())).
                    withDesiredDeliveryMediums(DeliveryMediumType.EMAIL)
                    .withForceAliasCreation(Boolean.FALSE);
            AdminCreateUserResult result = identityProvider.adminCreateUser(createUserRequest);
            Users savedUser = userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
