package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
   boolean updateCompany(Long id, Company company);
   void CreateCompany(Company company);
   boolean deleteCompany(Long id);
 Company getcompany(Long id);
}
