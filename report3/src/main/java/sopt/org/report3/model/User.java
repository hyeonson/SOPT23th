package sopt.org.report3.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class User {
    private int user_idx;
    private String name;
    private String part;
}
