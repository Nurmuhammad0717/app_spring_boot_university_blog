package uz.pdp.app_hanshin_university.service;

import java.util.UUID;

public interface FriendListUserService {

    void follow(UUID profileId, UUID followerId);

    void unfollow(UUID profileId, UUID followerId);

}
