package org.akaza.openclinica.web.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class OpenClinicaSamlService implements SAMLUserDetailsService
{

       @Override
       public Object loadUserBySAML(SAMLCredential credential)
                     throws UsernameNotFoundException
       {
              String email = credential.getNameID().getValue();

              GrantedAuthority[] authorities = new GrantedAuthority[] { new GrantedAuthorityImpl("HOLDER") };
              List<GrantedAuthority> authorities_l = Arrays.<GrantedAuthority>asList(authorities);
              
              UserDetails userDetails = new User(
                           email, "password", true, true, true, true, authorities_l);
 
              return userDetails;
       }
}
