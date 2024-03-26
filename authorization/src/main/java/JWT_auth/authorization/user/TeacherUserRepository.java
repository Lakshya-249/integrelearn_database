package JWT_auth.authorization.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherUserRepository extends JpaRepository<Teacher_User,String> {
    @Query("SELECT u FROM Teacher_User u WHERE u.email= :name")
    Teacher_User finduserbyemail(@Param("name") String name);
}
