package kr.ac.hansung.edulms.service;

import kr.ac.hansung.edulms.dao.CourseDao;
import kr.ac.hansung.edulms.model.Course;
import kr.ac.hansung.edulms.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    private int nowYear = 2024; // 수강신청 대상 년도
    private int nowSemester = 2; // 수강신청 대상 학기

    /**
     * 학년별 이수 학점 조회 페이지
     * 수강신청 대상 기간을 제외하고 년도, 학기별로 학점 총점 조회 메소드
     * @return
     */
    public List<Summary> getCalculatedCourses() {
        return courseDao.getSummaryCourses(nowYear, nowSemester);
    }

    /**
     * 학년별 상세 이수 학점 조회 페이지
     * 특정 기간의 수강 과목 상세 조회 메소드
     * @param year 조회 대상 년도
     * @param semester 조회 대상 학기
     * @return
     */
    public List<Course> getCompletionCourses(int year, int semester) {
        return courseDao.getCourses(year, semester);
    }

    /**
     * 수강 신청 조회 페이지
     * 수강신청 대상 기간의 수강 신청한 과목 조회 메소드
     * @return 수강 신청한 과목 리스트(List<Course>)
     */
    public List<Course> getRegistrationCourses() {
        return courseDao.getCourses(nowYear, nowSemester);
    }

    /**
     * 수강 신청하기 페이지
     * 신규로 수강 과목의 정보(Course)를 DB에 저장하는 메소드
     * @param course 신청한 수강 과목 정보
     * @return 저장 성공 여부 (true: 성공, false: 실패)
     */
    public boolean insertCourse(Course course) {
        return courseDao.insert(course);
    }
}
