package kr.ac.hansung.edulms.dao;

import kr.ac.hansung.edulms.model.Course;
import kr.ac.hansung.edulms.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

/**
 * 수강 과목 관련 DAO (Data Access Object)
 */
@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 수강 과목 정보를 DB의 Courses 테이블에 저장
     * @param course 수강 과목 정보
     * @return 저장 성공 여부 (true: 성공, false: 실패)
     */
    public boolean insert(Course course) {

        int year = course.getYear();
        int semester = course.getSemester();
        String code = course.getCode();
        String name = course.getName();
        String division = course.getDivision();
        String professor = course.getProfessor();
        int credit = course.getCredit();

        String sqlStatement = "insert into courses (year, semester, code, name, division, professor, credit) values (?, ?, ?, ?, ?, ?, ?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, division, professor, credit}) == 1);
    }

    /**
     * 수강 과목 정보를 DB의 Courses 테이블에서 삭제
     * @param year 년도
     * @param semester 학기
     * @return 삭제 성공 여부 (true: 성공, false: 실패)
     */
    public List<Course> getCourses(int year, int semester) {

        String sqlStatement = "select * from courses " +
                "where year=? and semester=? " +
                "order by year, semester, division, code";

        return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, (rs, rowNum) -> {
            Course course = new Course();

            course.setYear(rs.getInt("year"));
            course.setSemester(rs.getInt("semester"));
            course.setCode(rs.getString("code"));
            course.setName(rs.getString("name"));
            course.setDivision(rs.getString("division"));
            course.setProfessor(rs.getString("professor"));
            course.setCredit(rs.getInt("credit"));

            return course;
        });
    }

    /**
     * 특정 기간를 제외한 모든 수강 과목의 학점 총합을 년도, 학기별로 DB의 Courses 테이블에서 조회
     * @param year 제외할 년도
     * @param semester 제와할 학기
     * @return summary - 조회된 수강 과목 정보
     */
    public List<Summary> getSummaryCourses(int year, int semester) {
        String sqlStatement = "SELECT year, semester, SUM(credit) as totalCredits " +
                "FROM courses " +
                "WHERE year!=? or semester!=? " +
                "GROUP BY year, semester " +
                "ORDER BY year, semester";

        return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, (rs, rowNum) -> {
            Summary summary = new Summary();

            summary.setYear(rs.getInt("year"));
            summary.setSemester(rs.getInt("semester"));
            summary.setTotalCredits(rs.getInt("totalCredits"));

            return summary;
        });
    }
}