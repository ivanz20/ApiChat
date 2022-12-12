package com.example.users.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmailAndPassword(String email,String password);

	Optional<User> findByEmail(String email);

	Optional<User> findUserById(Long id);
	
	@Query(value = "SELECT * FROM usuarios WHERE status='online' or status='busy'",nativeQuery=true)
	List<User> findByOnline();
	
	
	@Modifying
	@Transactional
	@Query(value =  "UPDATE usuarios user SET  user.status =:statususer where user.id =:iduser",nativeQuery=true)
	int UpdateStatusUserById(@Param("iduser") Long idUser,@Param("statususer") String Status);


	
}
