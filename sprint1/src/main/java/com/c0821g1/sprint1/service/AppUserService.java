package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.security.AppUser;

public interface AppUserService  {
    void saveAppUser(AppUser appUser);
    AppUser findAppUserByEmail(String email);
}
