package com.example.demo.controllers;

import com.example.demo.models.Profile;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

  private final ProfileRepository profileRepository;

  public ProfileController(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  // Эндпоинт для создания нового профиля (POST /api/profiles)
  @PostMapping
  public Profile createProfile(@RequestBody Profile profile) {
    return profileRepository.save(profile);
  }

  // Эндпоинт для поиска профилей (GET /api/profiles/search?keyword=Java&username=Alice)
  @GetMapping("/search")
  public List<Profile> searchProfiles(@RequestParam String keyword,
                                      @RequestParam String username) {
    return profileRepository.findByBioAndUsername(keyword, username);
  }
}
