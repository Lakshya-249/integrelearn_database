package JWT_auth.authorization.usercontrollers;

import JWT_auth.authorization.user.Doubts;
import JWT_auth.authorization.user.DoubtsRepository;
import JWT_auth.authorization.user.User;
import JWT_auth.authorization.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class doubtscontroller {

    private final UserRepository userRepository;
    private final DoubtsRepository doubtsRepository;

    public doubtscontroller(UserRepository userRepository, DoubtsRepository doubtsRepository) {
        this.userRepository = userRepository;
        this.doubtsRepository = doubtsRepository;
    }

    @PostMapping("/addDoubts")
    public Map<String,Object> adddoubt(
        @RequestBody doubtsDTO dto
    ){
        Map<String,Object> res = new HashMap<>();
        User user = userRepository.finduserbyusername(dto.getUsername());
        if(user==null){
            res.put("success",false);
            res.put("message","no user found");
            return res;
        }
        Doubts doubts = new Doubts();
        doubts.setDoubtdesc(dto.getDoubtdesc());
        doubts.setUser(user);
        doubtsRepository.save(doubts);
        res.put("success",true);
        res.put("message","doubts queried succesfully");
        return res;
    }

    @GetMapping("/getDoubts")
    public Map<String,Object> getdoubts(){
        Map<String,Object> res = new HashMap<>();
        List<Doubts> doubts = doubtsRepository.findalldoubts();
        res.put("success",true);
        res.put("data",doubts);
        return res;
    }

    @DeleteMapping("/deleteDoubts/{id}")
    public Map<String,Object> deletedoubt(
            @PathVariable("id") String id
    ){
        Map<String,Object> res = new HashMap<>();
        doubtsRepository.deletebydoubtsid(id);
        res.put("success","true");
        res.put("message","Data deleted successfully");
        return res;
    }
}
