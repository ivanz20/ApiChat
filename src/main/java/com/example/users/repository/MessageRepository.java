package com.example.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.model.ChatPrivado;
import com.example.users.model.Mensajes;
import com.example.users.model.User;

public interface MessageRepository extends JpaRepository<Mensajes, Long>{
	
	@Query(value = "Select * from mensajes ORDER BY idmensaje asc;",nativeQuery=true)
	List<Mensajes> GetOneOnOneMsn();

}
