package cu.edu.cujae.pwebjsf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.pwebjsf.services.BillServices;
import cu.edu.cujae.pwebjsf.services.ContractServices;
import cu.edu.cujae.pwebjsf.services.PaymentServices;
import cu.edu.cujae.pwebjsf.services.dto.BillDto;
import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import cu.edu.cujae.pwebjsf.services.dto.ContractStringDto;
import cu.edu.cujae.pwebjsf.services.dto.PaymentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {

    @Autowired
    private ContractServices contractServices;
    @Autowired
    private BillServices billServices;
    @Autowired
    private PaymentServices paymentServices;

    @GetMapping("/all")
    public ResponseEntity<List<ContractDto>> getAll(){return ResponseEntity.ok(contractServices.getAll());}

    @GetMapping("/bills/all")
    public ResponseEntity<List<BillDto>> getAllBills(){return ResponseEntity.ok(billServices.getAll());}

    @GetMapping("/payments/all")
    public ResponseEntity<List<PaymentsDto>> getAllPayments(){return ResponseEntity.ok(paymentServices.getAll());}

    @GetMapping("/{code}")
    public ResponseEntity<ContractDto> getById(@PathVariable("code") int code){
        return ResponseEntity.ok(contractServices.getByCode(code));
    }

    @GetMapping("/bills/{code}")
    public ResponseEntity<BillDto> getBillById(@PathVariable("code") int code){
        return ResponseEntity.ok(billServices.getByCode(code));
    }

    @GetMapping("/payments/{code}")
    public ResponseEntity<PaymentsDto> getPaymentById(@PathVariable("code") int code){
        return ResponseEntity.ok(paymentServices.getByCode(code));
    }

    @PostMapping("/")
    public ResponseEntity<String> insert(@RequestBody ContractStringDto contractDto) throws ParseException {
        contractServices.save(contractDto);
        return ResponseEntity.ok("Contract inserted");
    }

    @PostMapping("/bills/")
    public ResponseEntity<String> insertBill(@RequestBody BillDto billDto){
        billServices.save(billDto);
        return ResponseEntity.ok("Bill inserted");
    }

    @PostMapping("/payments/")
    public ResponseEntity<String> insertPayment(@RequestBody PaymentsDto paymentsDto){
        paymentServices.save(paymentsDto);
        return ResponseEntity.ok("Payment inserted");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody ContractStringDto contractDto) throws ParseException {
        contractServices.save(contractDto);
        return ResponseEntity.ok("Contract updated");
    }

    @PutMapping("/bills/")
    public ResponseEntity<String> updateBill(@RequestBody BillDto billDto){
        billServices.save(billDto);
        return ResponseEntity.ok(" updated");
    }

    @PutMapping("/payments/")
    public ResponseEntity<String> updatePayment(@RequestBody PaymentsDto paymentsDto){
        paymentServices.save(paymentsDto);
        return ResponseEntity.ok("Contract updated");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code") Integer code){
        contractServices.delete(code);
        return ResponseEntity.ok("Contract deleted");
    }

    @DeleteMapping("/bills/{code}")
    public ResponseEntity<String> deleteBill(@PathVariable("code") Integer code){
        billServices.delete(code);
        return ResponseEntity.ok("Bill deleted");
    }

    @DeleteMapping("/payments/{code}")
    public ResponseEntity<String> deletePayment(@PathVariable("code") Integer code){
        paymentServices.delete(code);
        return ResponseEntity.ok("Payment deleted");
    }
}
