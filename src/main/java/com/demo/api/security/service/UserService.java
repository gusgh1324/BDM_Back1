package com.demo.api.security.service;

import com.demo.api.dto.UserDTO;
import com.demo.api.entity.User;
import com.demo.api.security.util.JWTUtil;

import java.util.List;

public interface UserService {
  default User dtoToEntity(UserDTO userDTO) {
    User user = User.builder()
        .name(userDTO.getName())
        .email(userDTO.getEmail())
        .password(userDTO.getPassword())
        .userImage(userDTO.getUserImage())
        .dataStorage(userDTO.getDataStorage())
        .fromSocial(userDTO.isFromSocial())
        .role(userDTO.getRole())
        .build();
    return user;
  }

  default UserDTO entityToDTO(User user) {
    UserDTO userDTO = UserDTO.builder()
            .mno(user.getMno())
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .userImage(user.getUserImage())
        .dataStorage(user.getDataStorage())
        .fromSocial(user.isFromSocial())
        .role(user.getRole())
        .build();
    return userDTO;
  }

  Long registerUser(UserDTO userDTO);

  void updateUser(UserDTO userDTO);

  void removeUser(Long mno);

  UserDTO getUser(Long num);

  List<UserDTO> getAllUsers();

  String login(String email, String pass, JWTUtil jwtUtil, boolean isSocial);

  UserDTO findByEmail(String email, boolean social);
}