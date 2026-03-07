package com.finix.controller;

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

import com.finix.constants.URLConstantsFinix;
import com.finix.dtos.PortfolioDTO;
import com.finix.entities.PortfolioEntity;
import com.finix.services.PortfolioService;

@RestController
@RequestMapping(URLConstantsFinix.URL_BASE + "/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> findAll() {
        return ResponseEntity.ok(this.portfolioService.findAll());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<PortfolioDTO> addPortfolio(@PathVariable Long userId,
                                                     @RequestBody PortfolioEntity portfolio) {
        return ResponseEntity.ok(this.portfolioService.add(userId, portfolio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.portfolioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioDTO> update(@PathVariable Long id,
                                               @RequestBody PortfolioEntity portfolio) {
        return ResponseEntity.ok(this.portfolioService.update(id, portfolio));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PortfolioDTO>> findPortfoliosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(this.portfolioService.findPortfoliosByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolioById(@PathVariable Long id) {

        boolean deleted = this.portfolioService.deletePortfolioByID(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

	
	
}
