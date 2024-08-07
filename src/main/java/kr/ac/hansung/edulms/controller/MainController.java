package kr.ac.hansung.edulms.controller;

import kr.ac.hansung.edulms.model.Course;
import kr.ac.hansung.edulms.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private CourseService courseService;

    /**
     * 홈페이지 요청 처리 메소드 (GET)
     * @param request
     * @return home.jsp
     */
    @RequestMapping(value = "/")
    public String home(HttpServletRequest request) {

        String url = request.getRequestURL().toString();
        String clientIPaddr = request.getRemoteAddr();

        log.info("Request URL: {}, Client IP: {}", url, clientIPaddr);

        return "home";
    }

    /**
     * 로그인 페이지 요청 처리 메소드 (GET)
     * @param error 로그인 실패 여부 (true: 실패, false: 성공)
     * @param logout 로그아웃 여부 (true: 로그아웃, false: 로그인)
     * @param model
     * @return login.jsp
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value="logout", required=false) String logout,
                        Model model) {

        if(error != null) {
            model.addAttribute("errorMsg", "Invalid username and password");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully");
        }

        return "login";
    }

    /**
     * 학년별 이수 학점 조회 페이지 요청 처리 메서드 (GET)
     * @param model
     * @return completionCourses.jsp
     */
    @GetMapping("/completion/courses")
    public String showCompletionCourses(Model model) {

        model.addAttribute("summaries", courseService.getCalculatedCourses());

        return "completionCourses";
    }

    /**
     * 학년별 이수 학점 조회 상세 페이지 요청 처리 메서드 (GET)
     * @param year 년도
     * @param semester 학기
     * @param model
     * @return completionCoursesDetail.jsp
     */
    @GetMapping("/completion/courses/detail")
    public String showCompletionCoursesDetail(
            @RequestParam int year,
            @RequestParam int semester,
            Model model) {

        model.addAttribute("courses", courseService.getCompletionCourses(year, semester));

        return "completionCoursesDetail";
    }

    /**
     * 수강 신청하기 페이지 요청 처리 메서드 (GET)
     * @return registration.jsp
     */
    @GetMapping("/registration")
    public String showRegistration() {

        return "registration";
    }

    /**
     * 수강 신청 조회 페이지 요청 처리 메서드 (GET)
     * @param model
     * @return registrationCourses.jsp
     */
    @GetMapping("/registration/courses")
    public String showRegistrationCourses(Model model) {

        model.addAttribute("courses", courseService.getRegistrationCourses());

        return "registrationCourses";
    }

    /**
     * 수강 신청 요청 처리 메서드 (POST)
     * @param course 수강 과목 정보
     * @return registrationCourses.jsp
     */
    @PostMapping("/registration")
    public String insertCourse(Course course) {
        System.out.println("course = " + course);
        courseService.insertCourse(course);

        return "redirect:/registration/courses";
    }
}


