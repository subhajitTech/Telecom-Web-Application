package com.casestudyserver.services.user;


import com.casestudyserver.dto.SignupRequest;
import com.casestudyserver.dto.UserDto;

public interface UserService {

     Boolean hasUserWithEmail(String email);

     UserDto createUser(SignupRequest signupRequest) throws Exception;

}
