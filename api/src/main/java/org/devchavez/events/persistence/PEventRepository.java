package org.devchavez.events.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PEventRepository extends CrudRepository<PEvent, UUID> {
	
	@Query(value = "SELECT *"
			+ " FROM public.\"event\" e"
			+ " WHERE 1 = 1"
			+   " AND (:createdDate IS NULL OR date_trunc('day', e.created_at) = CAST(:createdDate AS TIMESTAMPTZ))"
			+ 	" AND (:email IS NULL OR e.email = CAST(:email AS VARCHAR))"
			+ 	" AND (:environment IS NULL OR e.environment = CAST(:environment AS VARCHAR))"
			+ 	" AND (:component IS NULL OR e.component = CAST(:component AS VARCHAR))"
			+   " AND (:message IS NULL OR to_tsvector('english', e.message) @@ to_tsquery('english', CAST(:message AS VARCHAR)))",
			nativeQuery = true)
	List<PEvent> search(@Param("createdDate") String createdDate,
			@Param("email") String email, 
			@Param("environment") String environment, 
			@Param("component") String componen,
			@Param("message") String message);
}
