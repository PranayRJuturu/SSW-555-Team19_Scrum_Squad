package com.product.Backend_Solar.ServiceImplementation;

import com.product.Backend_Solar.Entity.Users;
import com.product.Backend_Solar.Repository.UsersRepo;
import com.product.Backend_Solar.Service.UserService;
import com.product.Backend_Solar.UsersDTO.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UsersRepo usersRepo;

    public UsersDTO create_User(UsersDTO usersDTO) {

        Users user = userDtoToEntity(usersDTO);
        Users savedUser = usersRepo.save(user);
        return entityToUserDto(savedUser);
    }

    private Users userDtoToEntity(UsersDTO usersDTO){
        Users usersData = new Users();
        usersData.setEmail(usersDTO.getEmail());
        usersData.setUsername(usersDTO.getUsername());
        usersData.setPassword(usersDTO.getPassword());
        usersData.setId(usersDTO.getRole());
        usersData.setId(0);
        return usersData;
    }

    private UsersDTO entityToUserDto(Users savedUser){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(savedUser.getId());
        usersDTO.setEmail(savedUser.getEmail());
        usersDTO.setPassword(savedUser.getPassword());
        usersDTO.setUsername(savedUser.getUsername());
        usersDTO.setRole(0);
        return usersDTO;
    }




}
