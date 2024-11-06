package com.embarkx.firstjobapp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {

        boolean updated= companyService.updateCompany(id, company);
        if(updated){
            return new ResponseEntity<>("job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("job not updated", HttpStatus.BAD_REQUEST);

    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.CreateCompany(company);
        return new ResponseEntity<>("company created", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean deleted=companyService.deleteCompany(id);
        if(deleted)
        return new ResponseEntity<>("company deleted",HttpStatus.OK);
        else return new ResponseEntity<>("company not deleted",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        if(companyService.getcompany(id)!=null)
        return new ResponseEntity<>(companyService.getcompany(id),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
