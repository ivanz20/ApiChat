package com.example.users.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.users.model.ChatPrivado;

@Repository
public interface Chat1Repository extends JpaRepository<ChatPrivado, Long>{


	@Query(value = "SELECT idchat,id_destinatario,id_remitente,lastmessage FROM chat_privados WHERE id_destinatario=:id_destinatario OR id_remitente=:id_destinatario",nativeQuery=true)
	List<ChatPrivado> FindUserChatsById(@Param("id_destinatario") Long iddest);
	
	
}
