package JWT_auth.authorization.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAnalysisRepository extends JpaRepository<StudentAnalysis,Integer> {

    @Query("SELECT new StudentAnalysis(s.as_id,s.subject,s.marks) FROM StudentAnalysis s WHERE s.user= :id")
    List<StudentAnalysis> findbyanalysis(@Param("id") User id);

}
