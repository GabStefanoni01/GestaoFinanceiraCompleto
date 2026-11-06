package com.gestao.financas.security;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
 private final JwtService jwt; private final UserDetailsService users;
 public JwtAuthenticationFilter(JwtService jwt,UserDetailsService users){this.jwt=jwt;this.users=users;}
 @Override protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException{
  String h=req.getHeader("Authorization");
  if(h==null||!h.startsWith("Bearer ")){chain.doFilter(req,res);return;}
  try{String token=h.substring(7),username=jwt.extractUsername(token);
   if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null){
    UserDetails user=users.loadUserByUsername(username);
    if(jwt.isTokenValid(token,user.getUsername())&&user.isEnabled()){
     var auth=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
     auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));SecurityContextHolder.getContext().setAuthentication(auth);
    }
   }
  }catch(JwtException|IllegalArgumentException|UsernameNotFoundException ex){SecurityContextHolder.clearContext();}
  chain.doFilter(req,res);
 }
}