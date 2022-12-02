package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.ContractServices;
import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {

    @Autowired
    private ContractServices contractServices;

    @GetMapping("/all")
    public ResponseEntity<List<ContractDto>> getAll(){return ResponseEntity.ok(contractServices.getAll());}

    @GetMapping("/{code}")
    public ResponseEntity<ContractDto> getById(@PathVariable("code") int code){
        return ResponseEntity.ok(contractServices.getByCode(code));
    }

    @PostMapping("/")
    public ResponseEntity<String> insert(@RequestBody ContractDto contractDto){
        contractServices.save(contractDto);
        return ResponseEntity.ok("Contract inserted");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody ContractDto contractDto){
        contractServices.save(contractDto);
        return ResponseEntity.ok("Contract updated");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code") Integer code){
        contractServices.delete(code);
        return ResponseEntity.ok("Contract deleted");
    }
}
