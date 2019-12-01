package th.co.maximus.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.auth.model.Role;
import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.auth.repository.UserRepository;
import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MasterDataDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired private UserRepository userRepository;
    @Autowired private MasterDataDao masterDataDao;
//	@Value("${text.posno}")
//	private String posNo;
	
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
            List<MasterDataBean> resultList = masterDataDao.findAllByGropType(Constants.INIT_PROJECT);
            for (MasterDataBean masterDataBean : resultList) {
				if(masterDataBean.getValue().equals("POS")) {
					   myUserDetails.setPos(masterDataBean.getText());
				}
				if(masterDataBean.getValue().equals("POS_NAME")) {
					   myUserDetails.setPosName(masterDataBean.getText());
				}
				if(masterDataBean.getValue().equals("BRANCH_AREA")) {
					   myUserDetails.setBranchArea(masterDataBean.getText());
				}
				if(masterDataBean.getValue().equals("BRANCH_CODE")) {
					   myUserDetails.setBranchCode(masterDataBean.getText());
				}
				if(masterDataBean.getValue().equals("TAX_ID_CAT")) {
					   myUserDetails.setTaxIdCat(masterDataBean.getText());
				}
				if(masterDataBean.getValue().equals("COST_CENTER")) {
					   myUserDetails.setCostCenter(masterDataBean.getText());
				}
			}
         
            myUserDetails.setRoles(user.getRoles());
            myUserDetails.setLoginFlag(user.getLoginFlag());
            return myUserDetails;
        }else{
          return null;
        }
       
    }
}
