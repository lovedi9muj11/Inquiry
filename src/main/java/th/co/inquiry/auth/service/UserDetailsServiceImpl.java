package th.co.inquiry.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.inquiry.auth.model.Role;
import th.co.inquiry.auth.model.UserDto;
import th.co.inquiry.auth.model.UserProfile;
import th.co.inquiry.auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired private UserRepository userRepository;
//    @Autowired private MasterDataDao masterDataDao;
	
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
//            List<MasterDataBean> resultList = masterDataDao.findAllByGropType(Constants.INIT_PROJECT);
//            for (MasterDataBean masterDataBean : resultList) {
//				if(masterDataBean.getValue().equals("COST_CENTER")) {
//					   myUserDetails.setCostCenter(masterDataBean.getText());
//				}
//			}
         
            myUserDetails.setRoles(user.getRoles());
            myUserDetails.setLoginFlag(user.getLoginFlag());
            return myUserDetails;
        }else{
          return null;
        }
       
    }
}
