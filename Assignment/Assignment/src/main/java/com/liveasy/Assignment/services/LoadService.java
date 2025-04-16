package com.liveasy.Assignment.services;

import com.liveasy.Assignment.models.*;
import com.liveasy.Assignment.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load createLoad(Load load) {
        load.setDatePosted(LocalDateTime.now());
        load.setStatus(LoadStatus.POSTED);
        return loadRepository.save(load);
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Optional<Load> getLoadById(UUID id) {
        return loadRepository.findById(id);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public List<Load> getLoadsByTruckType(String truckType) {
        return loadRepository.findByTruckType(truckType);
    }

    public Load updateLoad(UUID id, Load updatedLoad) {
        return loadRepository.findById(id).map(load -> {
            Facility updatedFacility = updatedLoad.getFacility();

            if (updatedFacility != null) {
                Facility existingFacility = load.getFacility();
                if (existingFacility == null) {
                    existingFacility = new Facility();
                }

                existingFacility.setLoadingPoint(updatedFacility.getLoadingPoint());
                existingFacility.setUnloadingPoint(updatedFacility.getUnloadingPoint());
                existingFacility.setLoadingDate(updatedFacility.getLoadingDate());
                existingFacility.setUnloadingDate(updatedFacility.getUnloadingDate());

                load.setFacility(existingFacility);
            }

            load.setProductType(updatedLoad.getProductType());
            load.setTruckType(updatedLoad.getTruckType());
            load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            load.setWeight(updatedLoad.getWeight());
            load.setComment(updatedLoad.getComment());

            return loadRepository.save(load);
        }).orElse(null);
    }


    public void deleteLoad(UUID id) {
        loadRepository.deleteById(id);
    }

    public void updateLoadStatus(UUID loadId, LoadStatus status) {
        loadRepository.findById(loadId).ifPresent(load -> {
            load.setStatus(status);
            loadRepository.save(load);
        });
    }

}

