package pl.handbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.handbook.entity.Admin;
import pl.handbook.repository.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String name) {
        Admin admin = adminRepository.findByName(name);
        if (admin == null) {
            throw new UsernameNotFoundException(name);
        }
        return new UserPrincipal(admin);
    }
}

