package com.scape06.fishing;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;

@ScriptManifest(author = "Empathy", category = Category.FISHING, description = "2006Scape AIO Fisher", name = "06Scape Fisher", servers = { "2006Scape" }, version = 1.0)
public class EmpFisher extends Script {


	@Override
	public boolean onExecute() {
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(20);
		}
		provide(Arrays.asList(new Fishing(), new Walking(), new Dropping()));
		MainData.startXp = Skill.FISHING.getExperience();
		return true;
	}
}
