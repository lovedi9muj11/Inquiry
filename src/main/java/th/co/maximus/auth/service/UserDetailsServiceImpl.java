package th.co.maximus.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.auth.model.Role;
import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.auth.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired private UserRepository userRepository;
	@Value("${text.posno}")
	private String posNo;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userRepository.findByUsername(username);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : user.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            UserProfile myUserDetails = new UserProfile(user.getUsername(), user.getPassword(), authorities);
            myUserDetails.setPos(posNo);
            myUserDetails.setRoles(user.getRoles());
            return myUserDetails;
        }else{
          return null;
        }
       
    }
}
