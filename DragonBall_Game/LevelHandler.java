public interface LevelHandler{

	void startWorld(LivesIterator li);
	void startNext();
	void setNextLevel(LevelHandler NextLevel);
}