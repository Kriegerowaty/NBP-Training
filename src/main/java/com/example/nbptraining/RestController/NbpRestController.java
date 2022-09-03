package com.example.nbptraining.RestController;

import com.example.nbptraining.Service.NbpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NbpRestController {
    final NbpService nbpService;

    public NbpRestController(NbpService nbpService) { this.nbpService = nbpService; }

    @GetMapping("/zloto/{currency}/{startDate}/{endDate}")
    public ResponseEntity<String> zloto(@PathVariable String currency, @PathVariable String startDate,
                                        @PathVariable String endDate) throws JsonProcessingException {
        return ResponseEntity.ok(nbpService.calculateGold(currency, startDate, endDate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) { return  ResponseEntity.ok(nbpService.getID(id)); }
}
