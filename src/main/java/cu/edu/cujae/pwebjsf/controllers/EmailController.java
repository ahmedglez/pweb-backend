package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendmail")
public class EmailController {

  @Autowired
  UserServices userServices;

  @GetMapping("/{email}")
  public ResponseEntity<String> sendEmail(@PathVariable String email)
    throws Exception {
    SendEmail sendEmail = new SendEmail();
    int randomPIN = (int) (Math.random() * 90000000) + 1000;

    UserDto user = userServices.getUserByEmail(email);
    if (user != null) {
      user.setRecoverCode(Integer.toString(randomPIN));
      String name = user.getFirstName().split(" ")[0];
      userServices.save(user);
      sendEmail.sendEmail(
        email,
        name,
        "Codigo de verificacion",
        Integer.toString(randomPIN)
      );
      return ResponseEntity.ok("Correo enviado");
    } else {
      return ResponseEntity.ok("Correo no registrado");
    }
  }
}