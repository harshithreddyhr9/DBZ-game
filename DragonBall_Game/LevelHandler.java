public interface LevelHandler{

	void startWorld();
	void startNext();
	void setNextLevel(LevelHandler NextLevel);
}