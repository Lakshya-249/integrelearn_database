package JWT_auth.authorization.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubtsRepository extends JpaRepository<Doubts,String>{
    @Query("SELECT new Doubts(d.doubtId,d.doubtdesc,d.user.std_username) FROM Doubts d")
    List<Doubts> findalldoubts();

    @Modifying
    @Transactional
    @Query("DELETE FROM Doubts d WHERE d.doubtId= :id")
    void deletebydoubtsid(@Param("id") String id);
}
