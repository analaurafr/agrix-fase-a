package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   * @param farmService    the farm service
   * @param farmRepository the farm repository
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.farmRepository = farmRepository;
  }

  /**
   * Find by id crop.
   *
   * @param id the id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Create crop.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the crop
   */
  public Crop create(Long farmId, Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Update crop.
   *
   * @param id   the id
   * @param crop the crop
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop update(Long id, Crop crop) throws CropNotFoundException {
    Crop cropFromDb = findById(id);

    cropFromDb.setName(crop.getName());
    cropFromDb.setPlantedArea(crop.getPlantedArea());

    return cropRepository.save(cropFromDb);
  }

  /**
   * Delete by id crop.
   *
   * @param id the id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop deleteById(Long id) throws CropNotFoundException {
    Crop crop = findById(id);
    cropRepository.deleteById(id);
    return crop;
  }

  /**
   * Sets farm crop.
   *
   * @param cropId the crop id
   * @param farmId the farm id
   * @return the farm crop
   * @throws CropNotFoundException the crop not found exception
   * @throws FarmNotFoundException the farm not found exception
   */
  public Crop setFarmCrop(Long cropId, Long farmId)
      throws CropNotFoundException, FarmNotFoundException {
    Crop crop = findById(cropId);
    Farm farm = farmService.findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /**
   * Find all by farm id list.
   *
   * @param farmId the farm id
   * @return the list
   * @throws FarmNotFoundException the farm not found exception
   */
  public List<Crop> findAllByFarmId(Long farmId) throws FarmNotFoundException {
    Farm farm = farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);

    return cropRepository.findByFarmId(farmId);
  }
}
