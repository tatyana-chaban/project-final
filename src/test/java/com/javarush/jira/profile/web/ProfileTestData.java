package com.javarush.jira.profile.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.profile.ProfileTo;
import com.javarush.jira.profile.internal.Profile;

public class ProfileTestData {

    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_TO_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(ProfileTo.class, "lastLogin", "mailNotifications", "contacts");
    public static final long ID = 1L;
    public static final long UPDATED_MAIL_NOTIFICATIONS = 0L;
    public static final ProfileTo profileTo = new ProfileTo(1L, null, null);

    public static Profile getUpdatedProfile(){
        Profile profile = new Profile(ID);
        profile.setMailNotifications(UPDATED_MAIL_NOTIFICATIONS);
        return profile;
    }
}
