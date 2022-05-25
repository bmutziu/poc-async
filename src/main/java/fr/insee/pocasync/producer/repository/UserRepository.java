package fr.insee.pocasync.producer.repository;

import java.util.UUID;

import fr.insee.pocasync.producer.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  UserEntity findByUsername(String username);
}
