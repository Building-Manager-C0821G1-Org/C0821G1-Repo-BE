package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.AppUserRepository;
import com.c0821g1.sprint1.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public void saveAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser findAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }
}
