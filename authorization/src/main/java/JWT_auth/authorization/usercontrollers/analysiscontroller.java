package JWT_auth.authorization.usercontrollers;

import JWT_auth.authorization.user.StudentAnalysis;
import JWT_auth.authorization.user.StudentAnalysisRepository;
import JWT_auth.authorization.user.User;
import JWT_auth.authorization.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("/api/auth")
public class analysiscontroller {

    private final UserRepository userRepository;
    private final StudentAnalysisRepository studentAnalysisRepository;

    public analysiscontroller(UserRepository userRepository, StudentAnalysisRepository studentAnalysisRepository) {
        this.userRepository = userRepository;
        this.studentAnalysisRepository = studentAnalysisRepository;
    }

    @PostMapping("/addmarks")
    public Map<String,Object> addmarks(
            @RequestBody analysisDTO analysis
    ){
        Map<String,Object> res = new HashMap<>();
        User user = userRepository.finduserbyusername(analysis.getUser());
        if(user==null){
            res.put("success",false);
            res.put("message","No user found");
            return res;
        }
        StudentAnalysis studentAnalysis = new StudentAnalysis();
        studentAnalysis.setAs_id(analysis.getAs_id());
        studentAnalysis.setSubject(analysis.getSubject());
        studentAnalysis.setMarks(analysis.getMarks());
        studentAnalysis.setUser(user);
        
        studentAnalysisRepository.save(studentAnalysis);

        res.put("success",true);
        res.put("message","Marks inserted successfully");
        return res;
    }

    @GetMapping("/getmarks/{username}")
    public Map<String,Object> getmarks(
            @PathVariable("username") String username
    ){
        Map<String,Object> res = new HashMap<>();
        User user = userRepository.finduserbyusername(username);
        if(user==null){
            res.put("success",false);
            res.put("message","No user found");
            return res;
        }
        List<StudentAnalysis> studentAnalyses = studentAnalysisRepository.findbyanalysis(user);

        res.put("success",true);
        res.put("data",studentAnalyses);
        return res;
    }

    @GetMapping("/getmarksbyid/{id}")
    public Map<String,Object> getmarks2(
            @PathVariable("id") Integer id
    ){
        Optional<StudentAnalysis> stda = studentAnalysisRepository.findById(id);
        Map<String,Object> res = new HashMap<>();
        res.put("success",true);
        res.put("data",stda);
        return res;
    }

    @DeleteMapping("/deletemarks/{id}")
    public Map<String,Object> deletemarks(
            @PathVariable("id") Integer id
    ){
        Map<String,Object> res = new HashMap<>();
        Optional<StudentAnalysis> std = studentAnalysisRepository.findById(id);
        if(std.isEmpty()){
            res.put("success",false);
            res.put("message","No mark to delete");
            return res;
        }
        studentAnalysisRepository.deleteById(id);
        res.put("success",true);
        res.put("message","mark deleted succesfully");
        return res;
    }
}
