package ridingLesson;

import main.domain.Rider;
import main.domain.Horse;
import main.domain.Type;
import main.domain.SkillLevel;

public interface RidingLessonStableInterface {
	default int getPrice() {
		return 99999;
	};
	String getTeacher();
	Rider[] getRiders();
	Horse[] getHorses();
	void setHorses(Horse[] horses);
	Type getType();
	SkillLevel getSkillLevel();
	int getDuration();
}
