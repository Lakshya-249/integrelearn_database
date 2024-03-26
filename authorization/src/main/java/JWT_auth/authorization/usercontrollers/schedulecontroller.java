package JWT_auth.authorization.usercontrollers;

import JWT_auth.authorization.user.ScheduleRepository;
import JWT_auth.authorization.user.Schedules;
import JWT_auth.authorization.user.TeacherUserRepository;
import JWT_auth.authorization.user.Teacher_User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("/api/auth")
public class schedulecontroller {

    private final TeacherUserRepository teacherUserRepository;
    private final ScheduleRepository scheduleRepository;

    public schedulecontroller(TeacherUserRepository teacherUserRepository, ScheduleRepository scheduleRepository) {
        this.teacherUserRepository = teacherUserRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping("/addschedule")
    public Map<String,Object> addschedule(
            @RequestBody scheduleDTO schedulesdto
    ){
        Map<String,Object>res = new HashMap<>();

        Teacher_User T_user = teacherUserRepository.finduserbyemail(schedulesdto.getUser());
        if (T_user == null) {
            // Handle case where teacher with the provided email does not exist
            res.put("success",false);
            res.put("message","No teacher with this email");
            return res;
        }
        Schedules schedules = new Schedules();
        schedules.setSch_id(schedulesdto.getSch_id());
        schedules.setDay(schedulesdto.getDay());
        schedules.setStartTime(schedulesdto.getStartTime());
        schedules.setEndTime(schedulesdto.getEndTime());
        schedules.setDescription(schedulesdto.getDescription());
        schedules.setTeacherUser(T_user);
        schedules.setTname(T_user.getFirstname());
        schedules.setSubject(T_user.getSubject());

        scheduleRepository.save(schedules);

        res.put("message","schedules included");
        res.put("success",true);

        return res;
    }

    @GetMapping("/getschedules")
    public Map<String,Object> getschedules(){
        Map<String,Object> res = new HashMap<>();
        List<Schedules> schedules = scheduleRepository.findByschedules();

        res.put("success",true);
        res.put("data",schedules);
        return res;
    }

    @DeleteMapping("/deleteschedule/{id}")
    public Map<String,Object> deleteschedule(
            @PathVariable("id") String id
    ){
        Map<String,Object> res =new HashMap<>();
        scheduleRepository.deletefromuid(id);
        res.put("success",true);
        res.put("message","Schedule Deleted succesfully");
        return res;
    }

}
