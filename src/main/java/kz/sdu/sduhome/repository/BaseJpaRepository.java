package kz.sdu.sduhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJpaRepository<E, ID> extends JpaRepository<E, ID> {
}
