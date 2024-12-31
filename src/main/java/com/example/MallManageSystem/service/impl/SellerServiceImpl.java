package com.example.MallManageSystem.service.impl;

import com.example.MallManageSystem.dao.entity.SellerDO;
import com.example.MallManageSystem.dao.mapper.SellerMapper;
import com.example.MallManageSystem.dto.req.seller.*;
import com.example.MallManageSystem.dto.resp.seller.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerServiceImpl implements SellerService {
    private final SellerMapper sellerMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public RegisterSellerRespDTO registerSeller(RegisterSellerReqDTO reqDTO) throws MallException {
        if (sellerMapper.selectListByAccount(reqDTO.getAccount()).isEmpty()) {
            SellerDO sellerDO = SellerDO.builder()
                    .account(reqDTO.getAccount())
                    .password(passwordEncoder.encode(reqDTO.getPassword()))
                    .build();
            sellerMapper.insert(sellerDO);
        } else {
            throw MallException.builder()
                    .message("该账户已创建")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public RemoveSellerByIdRespDTO removeSellerById(RemoveSellerByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (sellerMapper.selectById(id) != null) {
            sellerMapper.deleteById(id);
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public UpdateSellerInfoRespDTO updateSellerInfo(UpdateSellerInfoReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (sellerMapper.selectById(id) != null) {
            SellerDO sellerDO = SellerDO.builder()
                    .id(reqDTO.getId())
                    .name(reqDTO.getName())
                    .phone(reqDTO.getPhone())
                    .email(reqDTO.getEmail())
                    .introduction(reqDTO.getIntroduction())
                    .build();
            sellerMapper.updateById(sellerDO);
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public QuerySellerByIdRespDTO querySellerById(QuerySellerByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        SellerDO sellerDO = sellerMapper.selectById(id);
        if (sellerDO != null) {
            return QuerySellerByIdRespDTO.builder()
                    .account(sellerDO.getAccount())
                    .name(sellerDO.getName())
                    .phone(sellerDO.getPhone())
                    .email(sellerDO.getEmail())
                    .introduction(sellerDO.getIntroduction())
                    .build();
        } else {
            throw MallException.builder()
                    .message("该账户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @Override
    public LoginSellerRespDTO loginSeller(LoginSellerReqDTO reqDTO) throws MallException {
        List<SellerDO> list = sellerMapper.selectListByAccount(reqDTO.getAccount());
        if (!list.isEmpty()) {
            SellerDO sellerDO = list.get(0);
            if (!passwordEncoder.matches(reqDTO.getPassword(), sellerDO.getPassword())) {
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
