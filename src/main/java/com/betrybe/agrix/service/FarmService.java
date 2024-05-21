package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Find by id farm.
   *
   * @param farmId the id
   * @return the farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm findById(Long farmId) throws FarmNotFoundException {
    return farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Update farm.
   *
   * @param id   the id
   * @param farm the farm
   * @return the farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm update(Long id, Farm farm) throws FarmNotFoundException {
    Farm farmFromDb = findById(id);

    farmFromDb.setName(farm.getName());
    farmFromDb.setSize(farm.getSize());

    return farmRepository.save(farmFromDb);
  }

  /**
   * Delete by id farm.
   *
   * @param id the id
   * @return the farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm deleteById(Long id) throws FarmNotFoundException {
    Farm farm = findById(id);
    farmRepository.deleteById(id);
    return farm;
  }
}
