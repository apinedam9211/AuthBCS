package co.com.bcs.authserverbcs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.com.bcs.authserverbcs.domain.Credentials;
import co.com.bcs.authserverbcs.repository.CredentialRepository;


public class JdbcUserDetails implements UserDetailsService{

	  	@Autowired
	    private CredentialRepository usuariosRepository;

	    @Override
	    public UserDetails loadUserByUsername (String username)  {
	        Credentials usuarios = usuariosRepository.findByName(username);


	        if(usuarios==null){

	            throw new UsernameNotFoundException("User"+username+"can not be found");
	        }

	        User user = new User(usuarios.getName(),usuarios.getPassword(),true,true,true,true,usuarios.getAuthorities());

	        return  user;


	    }
	
}
