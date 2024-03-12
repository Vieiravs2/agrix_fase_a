package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Farm Controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Create a new farm.
   */
  @PostMapping
  public ResponseEntity<FarmDto> create(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.create(farmDto.toEntity());
    FarmDto createdFarmDto = new FarmDto(farm.getId(), farm.getName(), farm.getSize());
    return new ResponseEntity<>(createdFarmDto, HttpStatus.CREATED);
  }
}
