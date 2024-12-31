package com.example.MallManageSystem.service.impl;

import com.example.MallManageSystem.dao.entity.UserDO;
import com.example.MallManageSystem.dao.mapper.UserMapper;
import com.example.MallManageSystem.dto.req.user.*;
import com.example.MallManageSystem.dto.resp.user.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public RegisterUserRespDTO registerUser(RegisterUserReqDTO reqDTO) throws MallException {
        if (userMapper.selectListByAccount(reqDTO.getAccount()).isEmpty()) {
            UserDO userDO = UserDO.builder()
                    .account(reqDTO.getAccount())
                    .password(passwordEncoder.encode(reqDTO.getPassword()))
                    .build();
            userMapper.insert(userDO);
        } else {
            throw MallException.builder()
                    .message("该账户已创建")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public RemoveUserByIdRespDTO removeUserById(RemoveUserByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (userMapper.selectById(id) != null) {
            userMapper.deleteById(id);
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public UpdateUserInfoRespDTO updateUserInfo(UpdateUserInfoReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (userMapper.selectById(id) != null) {
            UserDO userDO = UserDO.builder()
                    .id(reqDTO.getId())
                    .name(reqDTO.getName())
                    .phone(reqDTO.getPhone())
                    .email(reqDTO.getEmail())
                    .gender(reqDTO.getGender())
                    .build();
            userMapper.updateById(userDO);
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public QueryUserByIdRespDTO queryUserById(QueryUserByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        UserDO userDO = userMapper.selectById(id);
        if (userDO != null) {
            return QueryUserByIdRespDTO.builder()
                    .account(userDO.getAccount())
                    .name(userDO.getName())
                    .phone(userDO.getPhone())
                    .email(userDO.getEmail())
                    .gender(userDO.getGender())
                    .build();
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @Override
    public LoginUserRespDTO loginUser(LoginUserReqDTO reqDTO) throws MallException {
        List<UserDO> list = userMapper.selectListByAccount(reqDTO.getAccount());
        if (!list.isEmpty()) {
            UserDO userDO = list.get(0);
            if (!passwordEncoder.matches(reqDTO.getPassword(), userDO.getPassword())) {
                throw MallException.builder()
                        .message("密码错误")
                        .statusCode(HttpStatus.NOT_FOUND)
                        .build();
            }
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

}
