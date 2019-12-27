package chlod.beeper.core.objects.client;

import chlod.beeper.core.crypt.PasswordHasher;
import chlod.beeper.core.exceptions.AuthenticationException;

public class Password {
	
	private String HashedPassword;
	private String HashedSalt;
	
	public Password(String rawPassword) {
		HashedSalt = PasswordHasher.newSalt(32, "c");
		HashedPassword = PasswordHasher.hashPassword(rawPassword, HashedSalt);
	}
	
	public void changePassword(String oldPassword, String newPassword) throws AuthenticationException {
		if (HashedPassword == PasswordHasher.hashPassword(oldPassword, HashedSalt)) {
			HashedSalt = PasswordHasher.newSalt(32, "c");
			HashedPassword = PasswordHasher.hashPassword(newPassword, HashedSalt);
		} else {
			throw new AuthenticationException("Incorrect password!");
		}
	}

}
