package net.justvis.mythos.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class ControlledSlot extends Slot {
    private final Item allowedItem;

    public ControlledSlot(Inventory inventory, int index, int x, int y, @Nullable Item allowedItem) {
        super(inventory, index, x, y);
        this.allowedItem = allowedItem;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if(allowedItem == null)
            return false;
        else
            return stack.getItem() == allowedItem;
    }
}
