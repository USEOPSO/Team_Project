package com.teampj.physicheck.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;  // 수정
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.physicheck.dao.MainDAO;
import com.teampj.physicheck.dto.CustomerDTO;
import com.teampj.physicheck.dto.DietDTO;
import com.teampj.physicheck.dto.NoticeDTO;
import com.teampj.physicheck.dto.ReserveDTO;
import com.teampj.physicheck.dto.ReviewDTO;

// http://localhost/gsonEx/ 실행
// Android 실행 -> http://" + id + " "/gsonEx/android/"
@RequestMapping("/android/")
@Controller
public class AndroidController {
   // private Logger log = Logger.getLogger(this.getClass());
   private static final Logger log = LoggerFactory.getLogger(AndroidController.class);
   
   @Autowired
   MainDAO mainDao;
   
   static String sessionId;
   
   @RequestMapping("androidSignIn")
   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
   public Map<String, String> androidSignIn(HttpServletRequest req){ //jsonData
      log.info("androidSignIn()");
      // 안드로이드에서 전달한 값
      // Service로 빼기 바람 -> 순남쌤
      String id = req.getParameter("id");
      String password = req.getParameter("password");
      
      System.out.println("android id => " + id);
      System.out.println("android pwd => " + password);
      
      Map<String, String> in = new HashMap<String, String>();
      in.put("id", id);
      in.put("password", password);
      
      //로그인
      // JSONObject out = new JSONObject();
      String authority = mainDao.confirmIdPwd(in);
      System.out.println("id : " +id);
      System.out.println("authority : " + authority);
      
      // 웹에서 안드로이드로 전달할 값      
      Map<String, String> out = new HashMap<String, String>();
      if(authority != null) {
         log.info("로그인 성공: " + authority);
         out.put("id", id);   // key는 CustomerDTO의 멤버변수와 일치
         
      } else {
         log.info("로그인 실패");
         out.put("id", null);
      }
      
      return out;
/*
INFO : spring.mvc.gsonEx.AndroidController - androidSignIn()
android id => hong
android pwd => 1234
id : hong
authority : ROLE_USER
INFO : spring.mvc.gsonEx.AndroidController - 로그인 성공: ROLE_USER
*/
   }
      
   
   // 앱 마이페이지 
   @ResponseBody
   @RequestMapping("androidMyPageMain")
   public Map<String, Object> androidMyPageMain(HttpServletRequest req) {
      log.info("androidMyPageMain()");
      System.out.println("androidMyPageMain()");   
      // 안드로이드에서 전달한 id값
      String id = req.getParameter("id");
      
      System.out.println("id : " + id);
      sessionId = id;
      
      // 회원정보 조회
      CustomerDTO customer = mainDao.getMemberInfo(id);
      
      System.out.println("customer : " + customer);
      
      Map<String, Object> map = new HashMap<String, Object>();
      
      map.put("data1", customer.getName());
      map.put("data2", 0);   // 리뷰
      map.put("data3", 0);   // 공지사항
      map.put("data4", 0);   // 다이어트
      map.put("customer", customer);
   
      return map;
   }

   // 식단 리스트
   @RequestMapping("androidDiet")
   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
   public Object androidDiet(HttpServletRequest req){
      System.out.println("androidDiet url");

      List<DietDTO> list = mainDao.mobileDietList();
      
      System.out.println("식단dtoList : " + list);
      Object object = list;
      return object;
   }
  
   // 공지사항
   @RequestMapping("androidNotice")
   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
   public Object androidNotice(HttpServletRequest req){
      log.info("androidNotice()");
      System.out.println("androidNotice()");   
      
      List<NoticeDTO> list = mainDao.mobileNoticeList();

      System.out.println("공지사항 dtoList : " + list);
      Object object = list;
      return object;
   }
   
   // 리뷰 리스트
   @RequestMapping("androidReview")
   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
   public Object androidReview(HttpServletRequest req){
      log.info("androidReview()");
      System.out.println("androidReview()");
      
      List<ReviewDTO> list = mainDao.mobileReviewList();
      
      System.out.println("리뷰 dtoList : " + list);
      Object object = list;
      return object;
   }
   
   // 예약 리스트
   @RequestMapping("androidReserve1")
   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
   public Object androidReserve(HttpServletRequest req){
      log.info("androidReserve()");
      System.out.println("androidReserve()");
      String testid = sessionId;
      
      // 안드로이드에서 전달한 id값
      String id = testid;
      
      System.out.println("id : " + id);
      sessionId = id;
      
      List<ReserveDTO> list = mainDao.mobileReserveList(sessionId);
      
      System.out.println("예약 dtoList : " + list);
      Object object = list;
      return object;
   }
   
}