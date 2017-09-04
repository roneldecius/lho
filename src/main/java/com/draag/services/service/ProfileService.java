package com.draag.services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.draag.services.DatabaseClass;
import com.draag.services.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		if (profiles.isEmpty()) {
			Profile profile = new Profile(DatabaseClass.getNextProfileId(), "RonelDecius", "Ronel", "Decius");
			profiles.put(profile.getProfileName(), profile);
		}
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(DatabaseClass.getNextProfileId());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
