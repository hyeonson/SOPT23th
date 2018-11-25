package org.sopt.report5.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignUpReq {
    private String name;
    private String part;
    private String password;

    //프로필 사진 객체
    private MultipartFile profile;
    //프로필 사진 저장 url 주소
    private String profileUrl;
}
