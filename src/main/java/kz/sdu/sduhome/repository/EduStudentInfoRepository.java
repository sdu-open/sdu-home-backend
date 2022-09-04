package kz.sdu.sduhome.repository;

import kz.sdu.sduhome.entity.EduStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduStudentInfoRepository extends JpaRepository<EduStudentInfo, Integer> {
}