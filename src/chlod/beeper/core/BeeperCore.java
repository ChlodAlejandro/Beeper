package chlod.beeper.core;

import java.util.HashMap;
import java.util.Map;

public class BeeperCore {

	private final String VERSION = "0.01a";
	private Map<String, Integer> VERSION_CODES = new HashMap<String, Integer>();
	
	public BeeperCore() {
		VERSION_CODES.put("0.01a", 000001);
	}
	
	public Integer getVersionCodeFromVersion(String version) {
		return VERSION_CODES.get(version);
	}
	
	public String getVersion() {
		return VERSION;
	}
	
	public Integer getVersionCode() {
		return VERSION_CODES.get(getVersion());
	}
	
}
