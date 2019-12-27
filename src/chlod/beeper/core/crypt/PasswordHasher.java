package chlod.beeper.core.crypt;

import java.security.MessageDigest;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordHasher {

	public static String hashPassword(String rawPassword, String salt){
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes("UTF-8"));
			byte[] bytes = md.digest(rawPassword.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (Exception e){
			Logger.getLogger("BeeperCore").log(Level.SEVERE, "Hashing failed! " + e.getMessage());
			e.printStackTrace();
		}
	    return generatedPassword;
	}
	
	/**
	 * Create a new salt.<br/>
	 * <br/>
	 * The flags determine the manipulation of the salt<br/>
	 * <ul>
	 *     <li><b>r</b> - no repeating characters (two 'A's in one salt)</li>
	 *     <li><b>c</b> - no repeating consecutive characters ('aa')</li>
	 * </ul>
	 * If you duplicated a randomizer setting, it will simply get the highest priority flag.
	 * 
	 * @param length, manipulationLevel, chars
	 * @return
	 */
	public static String newSalt(int length, String flags, String characters) {
		char[] saltCharacters = characters.toCharArray();
		if (length > saltCharacters.length) Logger.getLogger("BeeperCore").log(Level.SEVERE, "Character array is smaller than required length! Salt generation is impossible.");
		String salt = null;
		boolean good = false;
		do {
			salt = "";
			Random rand = new Random();
			for (int x = 1; x <= length; x++) {
				if (flags.contains("r")) {
					String saltChar = "";
					do {
						saltChar = "" + saltCharacters[rand.nextInt() / saltCharacters.length];
					} while(salt.contains(saltChar));
					salt += saltChar;
				} else if (flags.contains("c")) {
					String saltChar = "";
					do {
						saltChar = "" + saltCharacters[rand.nextInt() / saltCharacters.length];
					} while(salt.substring(salt.length() - 1) == saltChar);
					salt += saltChar;
				} else {
					salt += saltCharacters[rand.nextInt() / saltCharacters.length];
				}
			}
			good = true;
		} while (!good);
		return salt;
	}
	
	public static String newSalt(int length, String flags) {
		return newSalt(length, flags, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890");
	}
}