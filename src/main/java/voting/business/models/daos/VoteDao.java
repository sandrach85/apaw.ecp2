package voting.business.models.daos;

import java.util.List;

import voting.business.models.entities.Theme;
import voting.business.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	public List<Vote> findByTheme(Theme theme);

}
