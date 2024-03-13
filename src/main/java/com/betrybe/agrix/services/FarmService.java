package com.betrybe.agrix.services;

import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service responsible for handling farm-related operations.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  /**
   * Constructs a new FarmService with the specified FarmRepository.
   */
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Creates a new farm and saves it to the database.
   */
  @Transactional
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Retrieves a list of all farms saved in the database.
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
  * Retrieves a specific farm by its ID.
  */
  public Farm getById(Long id) {
    Optional<Farm> farm = farmRepository.findById(id);

    if (!farm.isEmpty()) {
      return farm.get();
    }

    throw new FarmNotFoundException();
  }
}
