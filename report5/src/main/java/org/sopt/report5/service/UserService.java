package org.sopt.report5.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report5.dto.User;
import org.sopt.report5.mapper.UserMapper;
import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.model.SignUpReq;
import org.sopt.report5.utils.ResponseMessage;
import org.sopt.report5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    private final S3FileUploadService s3FileUploadService;

    /**
     * 생성자 의존성 주입
     *
     * @param userMapper
     * @param s3FileUploadService
     */
    public UserService(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    /**
     * 모든 회원 조회
     *
     * @return DefaultRes
     */
    public DefaultRes getAllUsers() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }

    /**
     * 이름으로 회원 조회
     *
     * @param name 이름
     * @return DefaultRes
     */
    public DefaultRes findByName(final String name) {
        final List<User> userList = userMapper.findByName(name);
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }
    /**
     * 파트로 회원 조회
     *
     * @param email 이메일
     * @return DefaultRes
     */
    public DefaultRes findByEmail(final String email) {
        final List<User> userList = userMapper.findByEmail(email);
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }
    /**
     * 이름과 파트로 회원 조회
     *
     * @param name 이름
     * @param part 파트
     * @return DefaultRes
     */
    public DefaultRes findByNameAndEmail(final String name, final String email) {
        final List<User> userList = userMapper.findByNameAndEmail(name, email);
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }
    /**
     * 유저 고유번호로 회원 조회
     *
     * @param userIdx 유저 고유번호
     * @return DefaultRes
     */
    public DefaultRes findByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if(user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }
    /**
     * 회원 가입
     *
     * @param signUpReq 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes save(SignUpReq signUpReq) {
        try {
            //파일이 있다면 파일을 S3에 저장 후 경로를 저장
            if (signUpReq.getProfile() != null)
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));

            userMapper.save(signUpReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 정보 수정
     *
     * @param userIdx   회원 고유 번호
     * @param signUpReq 수정할 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes update(final int userIdx, final SignUpReq signUpReq) {
        User temp = userMapper.findByUserIdx(userIdx);
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            if (signUpReq.getName() != null) temp.setName(signUpReq.getName());
            if (signUpReq.getEmail() != null) temp.setEmail(signUpReq.getEmail());
            if (signUpReq.getPassword() != null) temp.setPassword(signUpReq.getPassword());
            userMapper.update(userIdx, temp);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 탈퇴
     *
     * @param userIdx 회원 고유 번호
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes deleteByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            userMapper.deleteByUserIdx(userIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
