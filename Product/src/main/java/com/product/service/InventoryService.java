package com.product.service;

import com.product.model.Inventory;

public interface InventoryService {

    Inventory getInventoryByProductId(Long productId);

    Inventory createInventory(Inventory inventory);

    Inventory updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);

    Inventory getInventoryById(Long id);
}

