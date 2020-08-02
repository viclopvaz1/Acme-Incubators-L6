
package acme.features.anonymous.technologyrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.technologyrecords.TechnologyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTechnologyRecordRepository extends AbstractRepository {

	@Query("select tr from TechnologyRecord tr where tr.id = ?1")
	TechnologyRecord findOneById(int id);

	@Query("select tr from TechnologyRecord tr order by tr.star desc")
	Collection<TechnologyRecord> findMany();

}
