package org.sopt.report5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report5.dto.User;
import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.model.SignUpReq;
import org.sopt.report5.service.JwtService;
import org.sopt.report5.service.UserService;
import org.sopt.report5.utils.ResponseMessage;
import org.sopt.report5.utils.StatusCode;
import org.sopt.report5.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.sopt.report5.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    //report 5 추가 내용 시작
    @GetMapping("/time")
    public ResponseEntity getTIme() {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.GET_SERVER_TIME_SUCCESS, dayTime.format(new Date(time))), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name") final Optional<String> name,
                                  @RequestParam("part") final Optional<String> part) {
        try {
            //name이 null일 경우 false, null이 아닐 경우 true
            if(name.isPresent() && part.isPresent())
                return new ResponseEntity<>(userService.findByNameAndPart(name.get(), part.get()), HttpStatus.OK);
            if(name.isPresent())
                return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);
            if(part.isPresent())
                return new ResponseEntity<>(userService.findByPart(part.get()), HttpStatus.OK);
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 조회 API
     * @param userIdx   회원 고유 번호
     * @return ResponseEntity
     */
    @GetMapping("/{userIdx}")
    public ResponseEntity getUserByIdx(@PathVariable(value = "userIdx") final int userIdx) {
        return new ResponseEntity<>(userService.findByUserIdx(userIdx), HttpStatus.OK);
    }

    //report 추가 내용 끝

    @PostMapping("test1")
    public String test1(final SignUpReq signUpReq) {
        //application/x-www-form-urlecoded 형식
        return signUpReq.toString();
    }

    @PostMapping("test2")
    public String test2(@RequestBody final SignUpReq signUpReq) {
        //application/json 객체 형식
        return signUpReq.toString();
    }


    /**
     * 회원 가입
     *
     * @param signUpReq 회원 가입 폼
     * @param profile   프로필 사진 객체
     * @return ResponseEntity
     */
    //@RequestPart
    //value = "profile" 파일의 키 값은 profile
    //required = false 파일을 필수로 받지 않겠다.
    //@Auth
    @PostMapping("")
    public ResponseEntity signup(
            SignUpReq signUpReq,
            @RequestPart(value = "profile", required = false) final MultipartFile profile
    ) {
        try {
            //파일을 signUpReq에 저장
            if (profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.save(signUpReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 수정 API
     * 인증 필요
     * @param userIdx   회원 고유 번호
     * @param signUpReq 수정할 회원 정보 객체
     * @return ResponseEntity
     */
    @Auth
    @PutMapping("/{userIdx}")
    public ResponseEntity signUp(
            @PathVariable(value = "userIdx") final int userIdx,
            SignUpReq signUpReq,
            @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            if (profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.update(userIdx, signUpReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 삭제 API
     * 인증 필요
     * @param userIdx 회원 고유 번호
     * @return ResponseEntity
     */
    @Auth
    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx") final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
