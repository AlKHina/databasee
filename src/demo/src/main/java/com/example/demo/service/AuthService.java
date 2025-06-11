package com.example.demo.service;

import java.util.Base64;

import org.bson.Document;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public AuthService(UserRepository userRepository, CompanyRepository companyRepository,
                       JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
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

    public void updateAvatarFromBase64(String fullname, String companyBIN, String base64Image) {
        Document user = userRepository.findByFullnameAndCompanyBIN(fullname, companyBIN);
        if (user == null) return;

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        userRepository.updateAvatarData(fullname, companyBIN, imageBytes);
    }
}
