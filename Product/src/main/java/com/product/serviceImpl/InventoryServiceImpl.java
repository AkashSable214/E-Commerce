package com.product.serviceImpl;

import com.product.model.Inventory;
import com.product.model.Product;
import com.product.repository.InventoryRepository;
import com.product.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductProductId(productId);
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Override
    public Inventory createInventory(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existing = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        existing.setStackQuantity(inventory.getStackQuantity());
        existing.setReservedQuantity(inventory.getReservedQuantity());
        existing.setWareHouseLocation(inventory.getWareHouseLocation());
        existing.setReOrderLevel(inventory.getReOrderLevel());
        existing.setSupplierId(inventory.getSupplierId());
        existing.setCostPrice(inventory.getCostPrice());
        existing.setStatus(inventory.getStatus());

        return inventoryRepository.save(existing);
    }

    @Override
    public void deleteInventory(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventoryRepository.delete(inventory);
    }


}
