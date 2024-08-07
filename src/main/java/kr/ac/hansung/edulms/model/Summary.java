package kr.ac.hansung.edulms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 년도/학기별 학점 총합 정보 모델
 */
@Getter @Setter
@ToString
@NoArgsConstructor
public class Summary {

    private int year;
    private int semester;
    private int totalCredits;
}
