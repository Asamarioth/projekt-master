package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.entities.Uzytkownik;

import java.util.ArrayList;
import java.util.List;
import web.repositories.UzytkownikRepository;

@Service
public class UzytkownikService {

    @Autowired
    private UzytkownikRepository memberRepository;

    public Uzytkownik createMember(Uzytkownik member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRole("ADMIN");
        memberRepository.save(member);
        return member;
    }
}
