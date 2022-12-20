package cu.edu.cujae.pwebjsf.middlewares;

import cu.edu.cujae.pwebjsf.services.CustomUserDetailsServices;
import cu.edu.cujae.pwebjsf.utils.JWTUtil;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class RolesFilterRequest extends OncePerRequestFilter {

  @Autowired
  private JWTUtil jwtUtil;

  @Autowired
  private CustomUserDetailsServices userDetailsServices;

  private boolean hasAdminRole(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      String jwt = authHeader.substring(7);
      ArrayList<String> roles = jwtUtil.extractRoles(jwt);
      System.out.println(roles);
      if (roles.contains("{authority=Administrator}")) {
        return true;
      }
      return false;
    }
    return false;
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    if (!request.getRequestURI().contains("/profile/")) {
      if (
        request.getMethod().equals("PUT") ||
        request.getMethod().equals("DELETE")
      ) {
        if (!hasAdminRole(request, response, filterChain)) {
          response.sendError(
            HttpServletResponse.SC_FORBIDDEN,
            "You don't have permission to do this action"
          );
        } else {
          System.out.println("You have permission to do this action");
        }
      }
    }
    filterChain.doFilter(request, response);
  }
}
