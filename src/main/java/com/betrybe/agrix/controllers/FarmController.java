package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for handling farm-related endpoints.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Constructs a new FarmController with the specified FarmService.
   */
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Creates a new farm based on the provided FarmDto.
   */
  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.create(farmDto.toEntity());
    FarmDto createdFarmDto = new FarmDto(farm.getId(), farm.getName(), farm.getSize());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdFarmDto);
  }

  /**
   * Retrieves a list of all farms saved in the database.
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    return ResponseEntity.ok(allFarms);
  }

  /**
   * Retrieves a specific farm by its ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Farm> getById(@PathVariable Long id) {
    Farm farm = farmService.getById(id);
    return ResponseEntity.ok(farm);
  }
}
