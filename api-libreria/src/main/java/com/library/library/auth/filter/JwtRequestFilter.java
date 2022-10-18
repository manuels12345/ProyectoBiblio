package com.library.library.auth.filter;

import com.library.library.auth.service.JwtUtils;
import com.library.library.auth.service.UserDetailsCustomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
/*@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtRequestFilter implements Filter {*/
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
/*
    static Logger logger = LoggerFactory.getLogger((CorsFilter.class));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        System.out.println("CORSFilter HTTP Request: " + request.getMethod());

        //disable chain
        response.addHeader("Access-Control_Max-Age","-1");
        //Authorize (allow) all domains to consume the content
        response.addHeader("Access-Control_Allow-Origin","http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials","false");
        response.addHeader("Access-Control-Allow-Methods","GET,POST,PUT, OPTIONS,PATCH");
        response.setHeader("Access-Control-Allow-Headers","Origin.Accept,X-Request-With,Content-Type, Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        //For HTTP OPTIONS VERB/METHOD reply with ACCETED status code -- per CORS handshake
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            chain.doFilter(req,res);
        }
        logger.info(request.getRemoteAddr());
    }
*/

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        final  String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }
        if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsCustomService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authReq =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                Authentication auth = authenticationManager.authenticate((authReq));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(request, response);
    }

}
