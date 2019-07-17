package com.mum.ea.project.carRental.Controller;

import com.mum.ea.project.carRental.Model.RentalCompany;
import com.mum.ea.project.carRental.Service.RentalCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carRental")
public class RentalCompanyController {
    @Autowired
    private RentalCompanyService compService;

    @GetMapping("/company")
    public List<RentalCompany> getAll() {
        return compService.getallCompany();
    }

    @GetMapping("/company/{destination}")
    public List<RentalCompany> getAllRentalCompanyDestination() {
        return compService.getallCompany();
    }


    @GetMapping("/company/search")
    public List<RentalCompany> getCarByBrand(@RequestParam String location) {
        return compService.getCompByLocation(location);
    }
    @GetMapping("/company/{id}")
    public RentalCompany getcarId(@PathVariable long id) {
        return compService.getCompany(id);
    }
    @PostMapping("/company")
    public void add(@RequestBody RentalCompany rentalCompany) {
        compService.add(rentalCompany);
    }

    @PutMapping("/company/{id}")
    public void update(@RequestBody RentalCompany rentalCompany) {
        compService.update(rentalCompany);
    }

    @DeleteMapping("/company/{id}")
    public void delete(@PathVariable int id) {
        compService.delete(id);
    }
}
