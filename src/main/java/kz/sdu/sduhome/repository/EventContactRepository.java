package kz.sdu.sduhome.repository;


import kz.sdu.sduhome.entity.EventContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventContactRepository extends JpaRepository<EventContact, Integer> {
}