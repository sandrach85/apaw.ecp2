package voting.business.models.daos;

public abstract class DaoFactory {

	public static DaoFactory factory = null;

	public static void setFactory(DaoFactory daoFactory) {
		DaoFactory.factory = daoFactory;
	}

	public static DaoFactory getFactory() {
		assert factory != null;
		return factory;
	}

	public abstract ThemeDao getThemeDao();

	public abstract VoteDao getVoteDao();

}
