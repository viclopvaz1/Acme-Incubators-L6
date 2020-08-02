
package acme.features.anonymous.toolrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolrecords.ToolRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousToolRecordRepository extends AbstractRepository {

	@Query("select tr from ToolRecord tr where tr.id = ?1")
	ToolRecord findOneById(int id);

	@Query("select tr from ToolRecord tr order by tr.star desc")
	Collection<ToolRecord> findMany();

}
