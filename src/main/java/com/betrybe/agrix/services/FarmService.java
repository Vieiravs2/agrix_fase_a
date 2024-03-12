package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Farm Service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  /**
   * Constructor com injeção de dependência para o FarmRepository.
   *
   * @param farmRepository FarmRepository
   */
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Cria uma nova fazenda e a salva no banco de dados.
   *
   * @param farm Farm
   * @return Farm salva
   */
  @Transactional
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }
}
