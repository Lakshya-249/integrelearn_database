package JWT_auth.authorization.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules,String> {
    @Query("SELECT new Schedules(s.sch_id,s.day,s.startTime,s.endTime,s.description,s.subject,s.tname) FROM Schedules s ")
    List<Schedules> findByschedules();

    @Modifying
    @Transactional
    @Query("DELETE FROM Schedules s WHERE s.sch_id= :uid")
    void deletefromuid(@Param("uid") String uid);
}
