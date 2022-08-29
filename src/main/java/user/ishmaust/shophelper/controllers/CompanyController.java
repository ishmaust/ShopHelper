package user.ishmaust.shophelper.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.servicies.CompanyServiceImpl;
import user.ishmaust.shophelper.servicies.interfacies.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyServiceImpl companyService) {
    this.companyService = companyService;
  }
}
