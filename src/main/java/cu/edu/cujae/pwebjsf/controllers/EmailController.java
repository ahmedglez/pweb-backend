package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.config.GlobalConfig;
import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sendmail")
public class EmailController {

  @Autowired
  UserServices userServices;

  @Autowired
  GlobalConfig globalConfig;

  @Autowired
  EmailUtils sendEmail;

  @GetMapping("/{email}")
  public ResponseEntity<String> sendEmail(@PathVariable String email)
    throws Exception {
    int randomPIN = (int) (Math.random() * 90000000) + 1000;

    UserDto user = userServices.getUserByEmail(email);
    if (user != null) {
      user.setRecoverCode(Integer.toString(randomPIN));
      String name = user.getFirstName().split(" ")[0];
      System.out.println(user.getPassword());
      userServices.save(user);
      String htmlMsg =
        "<h3>Hola, " +
        name +
        "</h3><p>Aquí está su código de recuperación de contraseña:</p><br><p><b>" +
        " " +
        randomPIN +
        " " +
        "</b></p><br><p>Si no solicitó una recuperación de contraseña, puede ignorar este correo electrónico. " +
        " </p><br><p>Si tiene alguna pregunta, no dude en contactarnos en: " +
        " </p><p> <a href='mailto: " +
        globalConfig.getEmail_username() +
        "'>" +
        globalConfig.getEmail_username() +
        "</a>" +
        "</p><br><p>Saludos,<br>CarRent Team</p>";
      sendEmail.sendEmail(email, "Recuperación de contraseña", htmlMsg);
      return ResponseEntity.ok("Correo enviado");
    } else {
      return ResponseEntity.ok("Correo no registrado");
    }
  }


  
}
