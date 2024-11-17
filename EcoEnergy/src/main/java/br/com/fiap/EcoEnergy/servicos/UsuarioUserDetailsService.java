//package br.com.fiap.EcoEnergy.servicos;
//
//import java.util.stream.Collectors;
//
//import br.com.fiap.EcoEnergy.model.Usuarios;
//import br.com.fiap.EcoEnergy.repository.UsuariosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UsuarioUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsuariosRepository uRep;
//
//    @Override
//    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
//
//        Usuarios user = uRep.findByNome(nome)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//
//        return new User(user.getNome(),user.getSenha(),user.getRoles()
//                .stream().map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList()));
//    }
//
//
//
//}