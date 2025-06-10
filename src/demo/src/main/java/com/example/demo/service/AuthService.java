package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bson.Document;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Company;
import com.example.demo.model.User;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, CompanyRepository companyRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String fullname, String password, String companyBIN) {
        Document user = userRepository.findByFullnameAndCompanyBIN(fullname, companyBIN);
        if (user == null) return null;

        String hash = user.getString("password");
        if (hash == null || !passwordEncoder.matches(password, hash)) return null;

        return jwtUtil.generateToken(fullname + "|" + companyBIN);
    }

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        if (!companyRepository.existsByBin(user.getCompanyBIN())) {
            Company company = new Company();
            company.setBin(user.getCompanyBIN());
            company.setName("Компания " + user.getCompanyBIN());
            companyRepository.save(company);
        }
    }

    public boolean updateAvatar(String fullname, String companyBIN, MultipartFile file) throws IOException {
    Document user = userRepository.findByFullnameAndCompanyBIN(fullname, companyBIN);
    if (user == null) return false;

    String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    String uploadDir = "uploads/";
    Path uploadPath = Paths.get(uploadDir);

    if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
    }

    Path filePath = uploadPath.resolve(filename);
    Files.write(filePath, file.getBytes());

    String avatarUrl = "/uploads/" + filename;
    userRepository.updateAvatarUrl(fullname, companyBIN, avatarUrl);

    return true;
}
}
