package open.ppm1111.tdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        System.out.println(new BCryptPasswordEncoder().encode("test1"));
        if (user == null) {
            System.out.println("user not found");
        }
        
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("can_read");
        return new User(user.getUsername(), user.getPassword(), auths);
    }
    
}
