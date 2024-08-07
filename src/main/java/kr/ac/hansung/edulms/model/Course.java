package kr.ac.hansung.edulms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

/**
 * 수강 과목 정보 모델
 */
@Getter @Setter
@ToString
@NoArgsConstructor
public class Course {

    private int year;
    private int semester;
    private String code;
    @Size(min=10, max=100)
    private String name;
    private String division;
    private String professor;
    private int credit;
}
